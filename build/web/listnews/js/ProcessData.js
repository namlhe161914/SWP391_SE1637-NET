//const { debug } = required("console");

var lang = Cookies.get('lang');
if (lang == null || lang == undefined) lang = 'vi';
function AlertError(msg) {
    window.alert(msg);
}
var Resource = new Object();
LoadResource();
function LoadResource() {
    const API_AGENCY_URL = '/DataJson/Resource/Resources_' + lang + '.json';
    $.ajax({ url: API_AGENCY_URL, dataType: "json", async: false, success: function (c) { Resource = c; }, error: function (c) { console.log("Dữ liệu không tồn tại") } });
}
function GetSource(code) {
    var result = Resource[code];
    if (result != undefined) return result;
    else return '[' + code + ']';
}
var getUrlParameter = function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return typeof sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
};
function RemoveUnicode(str) {
    str = str.toLowerCase();
    str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
    str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
    str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
    str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
    str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
    str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
    str = str.replace(/đ/g, "d");
    str = str.replace(/!|@|%|\^|\*|\(|\)|\+|\=|\<|\>|\?|\/|,|\.|\:|\;|\'| |\"|\&|\#|\[|\]|~|$|_|–|”|“|`/g, "-");
    str = str.replace(/\s+/g, "-");
    str = str.replace(/-+-/g, "-"); //thay thế 2- thành 1- 
    str = str.replace(/^\-+|\-+$/g, "");
    return str;
}
function ProcessData() {
    //#region Submit
    this.SendContact = function () {
        var $formContact = $("#SendContact");
        $formContact.validate({
            rules: {
                FullName: { required: true },
              
                Phone: { required: true, minlength: 10, maxlength: 12 },
                Email: { required: true, email: true },
                Address: { required: true },
            },
            messages: {
                FullName: { required: GetSource("EnterFullName") },
               
                Phone: { required: GetSource("EnterPhone"), minlength: GetSource("MinLength10"), maxlength: GetSource("MaxLength12") },
                Email: { required: GetSource("EnterEmail"), email: GetSource("ValidEmail") },
                Address: { required: GetSource("EnterContent") },
            },
            submitHandler: function () {
                var d = $formContact.serialize();
                $(".btnSendContact").attr("disabled", "disabled").hide();
                $(".load").show();
                var action = $formContact.attr('action');
                //$formContact.ajaxSubmit({
                //    success: function (data) {
                //        if (data.errors === false) {
                //            $formContact[0].reset();
                //            $('.alrt-contact').html(data.message).addClass('text-success').slideDown();
                //            setInterval(function () { window.location.reload(); }, 10000);
                //            $(".load").hide();
                //            $(".btnSendContact").show().prop('disabled', true);
                //        }
                //        else {
                //            $(".btnSendContact").show();
                //            $(".load").hide();
                //            $('.alrt-contact').html(data.message).slideDown().delay(10000).slideUp();
                //            console.log(data.logs);
                //        }
                //    }
                //});
                //return false;
                $.post(action, d, function (data) {
                    if (data.errors) {
                        $(".btnSendContact").attr("disabled", "").show();
                        $(".load").hide();
                        $('.alrt-contact').html(data.message).slideDown().delay(5000).slideUp();
                    } else {
                        $('.alrt-contact').html(data.message).addClass('success').slideDown();
                        $("#SendContact")[0].reset();
                        setInterval(function () { window.location.reload(); }, 5000);
                        $(".load").hide();
                        $(".btnSendContact").show();
                    }
                });
                return false;
            }
        });
    };
    //#region Submit
    this.SendApply = function () {
        var $formContact = $("#Apply");
        $formContact.validate({
            rules: {
                FirstName: { required: true },
                LastName: { required: true },
                Email: { required: true, email: true },
                Phone: { required: true, minlength: 10, maxlength: 12 }
            },
            messages: {
                FirstName: { required: GetSource("EnterFirstName") },
                LastName: { required: GetSource("EnterLastName") },
                Email: { required: GetSource("EnterEmail"), email: GetSource("ValidEmail") },
                Phone: { required: GetSource("EnterPhone"), minlength: GetSource("MinLength10"), maxlength: GetSource("MaxLength12") }
            },
            submitHandler: function () {
                $(".btnSendContact").hide();
                $(".load").show();
                $formContact.ajaxSubmit({
                    success: function (data) {
                        if (data.errors === false) {
                            $formContact[0].reset();
                            $('.alrt-contact').html(data.message).addClass('text-success').slideDown();
                            setInterval(function () { window.location.reload(); }, 5000);
                            $(".load").hide();
                            $(".btnSendContact").show().prop('disabled', true);
                        }
                        else {
                            $(".btnSendContact").show();
                            $(".load").hide();
                            $('.alrt-contact').html(data.message).slideDown().delay(5000).slideUp();
                            console.log(data.logs);
                        }
                    }
                });
                return false;
            }
        });
        $('#submit').click(function () {
            $formContact.submit();
        });
    };
    //#region Submit
    this.SendRequestQuote = function () {
        var $formContact = $("#SendRequestQuote");
        $formContact.validate({
            rules: {
                FullName: { required: true },
                TotalArea: { required: true },
                who: { required: true },
                Email: { required: true, email: true },
                Phone: { required: true, minlength: 10, maxlength: 12 }
            },
            messages: {
                FullName: { required: GetSource("EnterFirstName") },
                who: { required: GetSource("EnterFirstName") },
                TotalArea: { required: GetSource("EnterFirstName") },
                Email: { required: GetSource("EnterEmail"), email: GetSource("ValidEmail") },
                Phone: { required: GetSource("EnterPhone"), minlength: GetSource("MinLength10"), maxlength: GetSource("MaxLength12") }
            },
            submitHandler: function () {
                $(".btnSendContact").hide();
                $(".load").show();
                $('.alrt-contact').hide();
                if ($('input[name="edit-agree-policy"]:checked').length > 0) {
                    $formContact.ajaxSubmit({
                        success: function (data) {
                            if (data.errors === false) {
                                $formContact[0].reset();
                                $('.alrt-contact').html(data.message).addClass('text-success').slideDown();
                                setInterval(function () { window.location.reload(); }, 5000);
                                $(".load").hide();
                                $(".btnSendContact").show().prop('disabled', true);
                            }
                            else {
                                $(".btnSendContact").show();
                                $(".load").hide();
                                $('.alrt-contact').html(data.message).slideDown().delay(5000).slideUp();

                            }
                        }
                    });
                } else {
                    $(".load").hide();
                    $(".btnSendContact").show()
                    $('.alrt-contact').html(GetSource("Vuilongdongydk")).slideDown().delay(10000).slideUp();
                }


                return false;
            }
        });
        $('#submit').click(function () {
            $formContact.submit();
        });
    };
    //#region Submit
    this.SendOrder = function () {
        var $formContact = $("#SendOrder");
        $formContact.validate({
            rules: {
                fullname: { required: true },
                TotalArea: { required: true },
                who: { required: true },
                paymentemail: { required: true, email: true },
                paymentmobile: { required: true, minlength: 10, maxlength: 12 }
            },
            messages: {
                fullname: { required: GetSource("EnterFirstName") },
                who: { required: GetSource("EnterFirstName") },
                TotalArea: { required: GetSource("EnterFirstName") },
                paymentemail: { required: GetSource("EnterEmail"), email: GetSource("ValidEmail") },
                paymentmobile: { required: GetSource("EnterPhone"), minlength: GetSource("MinLength10"), maxlength: GetSource("MaxLength12") }
            },
            submitHandler: function () {
                $(".btnSendContact").hide();
                $(".load").show();
                $('.alrt-contact').hide();
                if ($('input[name="edit-agree-policy"]:checked').length > 0) {
                    $formContact.ajaxSubmit({
                        success: function (data) {
                            if (data.errors === false) {
                                $formContact[0].reset();
                                $('.alrt-contact').html(data.message).addClass('text-success').slideDown();
                                setInterval(function () { window.location.reload(); }, 5000);
                                $(".load").hide();
                                $(".btnSendContact").show().prop('disabled', true);
                            }
                            else {
                                $(".btnSendContact").show();
                                $(".load").hide();
                                $('.alrt-contact').html(data.message).slideDown().delay(5000).slideUp();

                            }
                        }
                    });
                } else {
                    $(".load").hide();
                    $(".btnSendContact").show()
                    $('.alrt-contact').html(GetSource("Vuilongdongydk")).slideDown().delay(10000).slideUp();
                }

                return false;
            }
        });
        $('#submit').click(function () {
            $formContact.submit();
        });
    };
    //#region Submit
    this.SendRequestPopup = function () {
        var $formContact = $("#SendRequestPopup");
        if (Jsonconfig.hasOwnProperty("IsFullName") && Jsonconfig['IsFullName'] == true) {
            $.validator.addMethod("nRequired", $.validator.methods.required, "Họ tên bắt buộc nhập!");
            $.validator.addClassRules("fullname", { nRequired: true });
        }
        if (Jsonconfig.hasOwnProperty("IsPhone") && Jsonconfig['IsPhone'] == true) {
            $.validator.addMethod("pRequired", $.validator.methods.required, "Số điện thoại bắt buộc nhập!");
            $.validator.addClassRules("phone", { pRequired: true });
        }
        if (Jsonconfig.hasOwnProperty("IsAddress") && Jsonconfig['IsAddress'] == true) {
            $.validator.addMethod("aRequired", $.validator.methods.required, "Địa chỉ bắt buộc nhập!");
            $.validator.addClassRules("address", { aRequired: true });
        }
        if (Jsonconfig.hasOwnProperty("IsEmail") && Jsonconfig['IsEmail'] == true) {
            $.validator.addMethod("eRequired", $.validator.methods.required, "Email bắt buộc nhập!");
            $.validator.addMethod("eEmail",
                function (value, element) {
                    return /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test(value);
                },
                "Email không đúng"
            );
            $.validator.addClassRules("email", { eRequired: true, eEmail: true });
        }
        if (Jsonconfig.hasOwnProperty("IsCity") && Jsonconfig['IsCity'] == true) {
            $.validator.addMethod("cRequired", $.validator.methods.required, "Tỉnh/Thành bắt buộc chọn!");
            $.validator.addClassRules("city", { cRequired: true });
        }
        if (Jsonconfig.hasOwnProperty("IsDistrict") && Jsonconfig['IsDistrict'] == true) {
            $.validator.addMethod("dRequired", $.validator.methods.required, "Quận/Huyện bắt buộc chọn!");
            $.validator.addClassRules("district", { dRequired: true });
        }
        if (Jsonconfig.hasOwnProperty("IsContent") && Jsonconfig['IsContent'] == true) {
            $.validator.addMethod("ctRequired", $.validator.methods.required, "Nội dung bắt buộc nhập!");
            $.validator.addClassRules("content", { ctRequired: true });
        }
        $formContact.validate({
            submitHandler: function () {
                var d = $formContact.serialize();
                $(".btnSendContact").hide();
                $(".load").show();
                var action = $formContact.attr('action');
                var token = $('input[name="__RequestVerificationToken"]', $formContact).val();
                $.post(action, d, function (data) {
                    if (data.errors) {
                        $(".btnSendContact").show();
                        $(".load").hide();
                        $('.alrt-contact').html(data.message).slideDown().delay(10000).slideUp();
                    } else {
                        $formContact[0].reset();
                        $('.alrt-contact').html(data.message).addClass('text-success').slideDown();
                        setInterval(function () { window.location.reload(); }, 1000);
                        $(".load").hide();
                        $(".btnSendContact").show().attr('disabled', 'disabled');
                    }
                });
                return false;
            }
        });
    };
    this.RegisterEmail = function () {
        var $formContact = $("#RegisterEmail");
        $formContact.validate({
            rules: {
                Email: { required: true, email: true }
            },
            messages: {
                Email: { required: "Vui lòng nhập email của bạn!", email: "Email không đúng định dạng!" }
            },
            submitHandler: function () {
                var d = $formContact.serialize();
                var action = $formContact.attr('action');
                $.post(action, d, function (data) {
                    if (data.errors) {
                        $('.alrt-email').html(data.message).fadeIn();
                        setInterval(function () { $('.alrt-email').html('').fadeOut(); }, 6000);
                    } else {
                        $('.alrt-email').addClass('text-success').html(data.message).fadeIn();
                        setInterval(function () { window.location.reload(); }, 6000);
                    }
                });
                return false;
            }
        });
    };
    //#endregion   
    //#region LoadData
    this.LoadMoreAjax = function (urlContent, container, type) {
        $(container).append(TemplateLoading());
        $.ajax({
            url: encodeURI(urlContent),
            cache: false,
            type: "POST",
            success: function (data) {
                var html = ``;
                if (type === 'Product') {
                    if (data.listProductItem.length > 0) {
                        html += PartialProduct(data);
                    }
                    else {
                        $('.Total').html(0);
                    }
                }
                else {
                    if (data.listContentItem.length > 0) {
                        html += PartialNews(data);
                    }
                }
                if (data.page === 1) {
                    $(container).html(html);
                } else {
                    $(container).append(html);
                }
                $(container).find('.hidden').fadeIn().removeClass('hidden');
                $(container).children('.load').remove();
            },
            errors: function () {
            }
        });
    };
    this.LoadHtml = function (urlContent, container) {
        $.ajax({
            url: encodeURI(urlContent),
            cache: false,
            type: "POST",
            success: function (data) {
                $(container).html(data);
            },
            errors: function () {
            }
        });
    };
    //#endregion
    //#region Utility
    function loadAjax(urlContent, container) {
        $(container).append(TemplateLoading);
        $("html,body").animate({ scrollTop: $(container).offset().top - 200 }, 1e3);
        $.ajax({
            url: encodeURI(urlContent),
            cache: false,
            type: "POST",
            success: function (data) {
                $(container).html(data);
                $(container).children('.list-search').find('.hidden').removeClass('hidden').fadeIn();
            }
        });
    }
    function TemplateLoading() {
        return `<div class="load text-center">
                                <div class="loadingio-spinner-spinner-uzlublexfob sending">
                                    <div class="ldio-c4d59ljt0jh">
                                        <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
                                    </div>
                                </div>
                            </div>`;
    }
    function CheckLink(nameAscci, LinkUrl) {
        if (LinkUrl !== '' && LinkUrl !== null && LinkUrl !== undefined) {
            //LinkUrl = $.trimEnd(LinkUrl,"/");
            return LinkUrl;
        }
        if (nameAscci != '' && (LinkUrl == undefined || LinkUrl == '')) {
            return "/" + nameAscci;
        }
        return "javascript:void(0)";
    }
    function formatDate(str) {
        if (str == null) return "";
        else {
            var date = new Date(str);
            return date.getDate() + "/" + (date.getMonth() + 1) + "/" + date.getFullYear();
        }
    }
    function formatFrice(n, currency) {
        if (n == null)
            return "Liên hệ";
        else
            return n.toFixed(0).replace(/./g, function (c, i, a) {
                return i > 0 && c !== "." && (a.length - i) % 3 === 0 ? "," + c : c;
            }) + currency;
    }
    //#endregion
    $(function () {
        $('.menu-cnt>ul>li>a').each(function () {
            
            var link = window.location.origin + window.location.pathname;
            if (this.href.trim() === link) {
                $(".menu-top > li").removeClass('active');
                $(this).closest('li').addClass('active');
            }

        });
        $('.sub-menu li a').each(function () {
            
            var link = window.location.origin + window.location.pathname;
            if (this.href.trim() === link) {
                $(".menu-top > li").removeClass('active');
                $(this).parents('.menu-cnt>ul>li').addClass('active');
            }

        });
    });
}
//#region Call function
var process = new ProcessData();
$(function () {
    $('.lang1').click(function (e) {

        e.preventDefault();
        var current = $(this).data('lang');
        if (current === lang) return;
        else {
            Cookies.set('lang', current, { expires: 1 });
            window.location.href = "/?nocache=" + (new Date()).getTime();
        }
    });
    if ($('#Apply').length > 0) {
        process.SendApply();
    }
    if ($('#Order').length > 0) {
        process.SendOrder();
    }
    if ($('#RegisterEmail').length > 0) {
        process.RegisterEmail();
    }
});
//#region hidden
function getValueFormMutilSelect(form) {
    var arrParam = '';
    var idMselect;
    $(form).find("input[type='checkbox']:checked, input[type='radio']:checked, input[type='text'],input[type='number'], input[type='hidden'], select").each(function () {
        idMselect = $(this).attr("name");
        if ($(this).val() != '')
            arrParam += "&" + idMselect + "=" + $(this).val();
    });
    if (arrParam != '')
        arrParam = arrParam.substring(1);
    return arrParam;
}
function getparram(container) {
    var arrParam = new Object();
    $(container).find("input[type='checkbox']:checked, input[type='radio']:checked, input[type='text'],input[type='number'], input[type='hidden'], select").each(function () {
        var idMselect = '';
        idMselect = $(this).attr("name");
        var va = $(this).val();
        if ($(this).val() != '' && idMselect != '' && idMselect != undefined)
            arrParam[idMselect] = va;
    });
    return arrParam;
}
function TemplateLoading() {
    return `<div class="load text-center">
                                <div class="loadingio-spinner-spinner-uzlublexfob sending">
                                    <div class="ldio-c4d59ljt0jh">
                                        <div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div><div></div>
                                    </div>
                                </div>
                            </div>`;
}
function formatPrice(n, currency) {
    if (n == null)
        return "Liên hệ";
    else
        return n.toFixed(0).replace(/./g, function (c, i, a) {
            return i > 0 && c !== "." && (a.length - i) % 3 === 0 ? "," + c : c;
        }) + currency;
}

//#endregion
$('.lg-choice').click(function () {
    $('.drop-down').toggleClass('active');
});
function createCookie(name, value, days, domain) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
        var expires = "; expires=" + date.toGMTString();
    } else {
        var expires = "";
    }
    document.cookie = name + "=" + value + expires + "; domain=" + domain + "; path=/";
}

function eraseCookie(name, domain) {
    createCookie(name, "", -1, domain);
}
function changeLang(n) {
    var t = n.attr("data-lang");
    //eraseCookie("googtrans");
    //createCookie("googtrans",t,1);
    eraseCookie("googtrans", ".adctopweb.com");
    eraseCookie("googtrans", ".bat.adctopweb.com");
    eraseCookie("googtrans", "adctopweb.com");
    eraseCookie("googtrans", "bat.adctopweb.com");
    createCookie("googtrans", t, 1, "")
    // createCookie("googtrans", t, 1, "")
    window.location.reload();
}
