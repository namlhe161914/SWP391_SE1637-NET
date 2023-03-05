$(".sr-lang .search img").click(function () {
    $(".search-box").toggleClass("active")
})
$(".down-doc button").click(function () {
    $(".drop-down").toggleClass("active")
})
$(function () {
    $(".slide-bn").lightSlider({ adaptiveHeight: !0, item: 1, slideMargin: 0, loop: !0, pager: !0, auto: !0, speed: 800, pause: 30000 });
    var partner = $(".slide-partner").lightSlider({ adaptiveHeight: !1, item: 5, slideMargin: 10, loop: !0, pager: !0, auto: !0, speed: 800, pause: 5000, responsive: [{ breakpoint: 1e3, settings: { item: 5 } }, { breakpoint: 800, settings: { item: 4, dots: !1 } }, { breakpoint: 600, settings: { item: 4 } }, { breakpoint: 480, settings: { item: 3 } }] }); $(".partner-cnt .bg-prev").click(function () { partner.goToPrevSlide() }), $(".partner-cnt .bg-next").click(function () { partner.goToNextSlide() });
    var construc = $(".construction .lst-pro").lightSlider({ adaptiveHeight: !0, item: 3, slideMargin: 30, loop: !0, pager: !0, auto: !0, speed: 800, pause: 5000, responsive: [{ breakpoint: 1e3, settings: { item: 3 } }, { breakpoint: 800, settings: { item: 3, dots: !1, slideMargin: 15 } }, { breakpoint: 600, settings: { item: 2, slideMargin: 15 } }, { breakpoint: 480, settings: { item: 1, slideMargin: 15 } }] });
    $(".construction .bg-prev").click(function () { construc.goToPrevSlide() }), $(".construction .bg-next").click(function () { construc.goToNextSlide() });
    var tech = $(".slide-lead").lightSlider({ adaptiveHeight: !0, item: 4, slideMargin: 20, loop: !0, pager: !1, auto: !0, speed: 800, responsive: [{ breakpoint: 1e3, settings: { item: 3 } }, { breakpoint: 800, settings: { item: 3, dots: !1, slideMargin: 15 } }, { breakpoint: 600, settings: { item: 2, slideMargin: 15 } }, { breakpoint: 480, settings: { item: 2, slideMargin: 15 } }] });
    $(".slide-tech .bg-prev").click(function () { tech.goToPrevSlide() }), $(".slide-tech .bg-next").click(function () { tech.goToNextSlide() });
    var leader = $(".slide-leader").lightSlider({ adaptiveHeight: !0, item: 4, slideMargin: 0, loop: !1, pager: !1, auto: !1, responsive: [{ breakpoint: 1026, settings: { item: 4, slideMargin: 0 } }, { breakpoint: 800, settings: { item: 3, dots: !1, slideMargin: 10 } }, { breakpoint: 600, settings: { item: 2, slideMargin: 15 } }, { breakpoint: 480, settings: { item: 2, slideMargin: 5 } }] });
    $(".leader-cnt .bg-prev").click(function () { leader.goToPrevSlide() }), $(".leader-cnt .bg-next").click(function () { leader.goToNextSlide() });
    $('.leader .slide-leader .it-leader').click(function () {
        var id = $(this).data('id');
        $('.leader .slide-leader .it-leader').removeClass("change");
        $(this).addClass("change");
        $(".leader .dt-it").removeClass("active");
        $(".leader .dt-it[data-id=" + id + "]").addClass("active");
    });

    $(".left-intro").lightSlider({ adaptiveHeight: !0, item: 1, slideMargin: 0, loop: !0, pager: !0, auto: !0, speed: 800, pause: 15000 });
    var sl_conts = $(".slide-conts").lightSlider({ adaptiveHeight: !0, item: 1, slideMargin: 0, loop: !1, pager: !0, auto: !0, speed: 800, responsive: [{ breakpoint: 1e3, settings: { item: 1 } }, { breakpoint: 800, settings: { item: 2, dots: !1, slideMargin: 15 } }, { breakpoint: 600, settings: { item: 2, slideMargin: 15 } }, { breakpoint: 480, settings: { item: 1, slideMargin: 0 } }] }); $(".sl-cnt .bg-prev").click(function () { sl_conts.goToPrevSlide() }), $(".sl-cnt .bg-next").click(function () { sl_conts.goToNextSlide() });
    var ls_conts = $(".construct.slide .ls-conts").lightSlider({ adaptiveHeight: !0, item: 3, slideMargin: 20, loop: !0, pager: !0, auto: !0, speed: 800, responsive: [{ breakpoint: 1e3, settings: { item: 3 } }, { breakpoint: 800, settings: { item: 2, dots: !1, slideMargin: 15 } }, { breakpoint: 600, settings: { item: 2, slideMargin: 15 } }, { breakpoint: 480, settings: { item: 1, slideMargin: 0 } }] }); $(".construc-lst .bg-prev").click(function () { ls_conts.goToPrevSlide() }), $(".construc-lst .bg-next").click(function () { ls_conts.goToNextSlide() });
    $(".news-dt .new-cnt.sc").lightSlider({ item: 3, loop: !1, slideMove: 1, easing: "cubic-bezier(0.25, 0, 0.25, 1)", speed: 800, adaptiveHeight: 1, pager: !1, slideMargin: 15, auto: !0, responsive: [{ breakpoint: 1025, settings: { item: 2 } }, { breakpoint: 800, settings: { item: 2, dots: !1, slideMargin: 15 } }, { breakpoint: 600, settings: { item: 2, slideMargin: 15 } }, { breakpoint: 480, settings: { item: 1, slideMargin: 0 } }] });
    var relatecontent = $(".relate-content .slider").lightSlider({ item: 3, loop: !1, slideMove: 1, easing: "cubic-bezier(0.25, 0, 0.25, 1)", speed: 800, adaptiveHeight: 1, pager: !1, slideMargin: 15, auto: !0, responsive: [{ breakpoint: 1025, settings: { item: 2 } }, { breakpoint: 800, settings: { item: 2, dots: !1, slideMargin: 15 } }, { breakpoint: 600, settings: { item: 2, slideMargin: 15 } }, { breakpoint: 480, settings: { item: 1, slideMargin: 0 } }] });
    $(".relate-content .bg-prev").click(function () { relatecontent.goToPrevSlide() }), $(".relate-content .bg-next").click(function () { relatecontent.goToNextSlide() });
    $('.banner').css("margin-top", $('.menu-hd').height());
    $(".tab-tit p").click(function () {
        var dttit = $(this).data("tab")
        $(".tab-tit p").removeClass("active")
        $(".txt-tab").removeClass("active")
        $(this).toggleClass("active")
        $(".txt-tab[id=" + dttit + "]").toggleClass("active")
    })
    $(".touch-menu").click(function () {
        $(this).toggleClass("active")
        $(".menu .menu-cnt ul").toggleClass("active")
        $('.menu-top .fa.fa-caret-up').toggleClass('active')
        $(".bg-black").toggleClass("active")
    })
    $(".bg-black").click(function () {
        $(this).removeClass("active")
        $(".menu").removeClass("active")
        $(".touch-menu").removeClass("active")
    })
    $(".menu .child-1").click(function () {
        $(this).toggleClass('open');
        var $target = $(this).next('.menu .sub-menu').slideToggle(400);
        $('.menu .sub-menu').not($target).hide();
    })
    $(".left-tech").click(function () {

        var src = $('#ifr-about').attr('src') + "?rel=0;&autoplay=1"
        $('#ifr-about').attr('src', src);
        $(".pop-up").addClass("active");
    })
    $(".close-btn").click(function () {
        var src = $(this).data("src");
        $(".pop-up").removeClass("active");
        $('iframe').attr('src', src);
    })
    $('.ic-zoom').click(function () {
        $(".lg-backdrop").addClass("in");
        $(".lg-outer").addClass("lg-visible");
    })
    $(".lg-backdrop").removeClass("in");
    $(".lg-outer").removeClass("lg-visible");
    if ($(window).width() < 1025 && $(window).width() > 767) {
        $('.introduce .right-intro').height($('.introduce .left-intro').height());
    }
    $('.bg-gray').height($('.menu-hd').height());
    $('.lst-number .it-num span:nth-of-type(1)').counterUp({ delay: 10, time: 1100 });
    fixintro = function () {
        var height = $('header').height() + 50;
        var scrollTop = $(window).scrollTop();
        if (scrollTop > height) {
            $('.menu-hd').addClass('fixed');
        } else {
            $('.menu-hd').removeClass('fixed');
        }
    };
    fixintro();
    $(window).on('scroll', function () { fixintro(); });
    const resizeImage = (div, ratio) => {
        let widthif = parseInt($(div).width())
        let heightif = (widthif) * ratio
        $(div).css({
            "height": heightif + "px"
        })
    }  
    resizeImage(".slide-partner .it-part", 140 / 230)
    resizeImage(".it-leader .img", 240 / 190)
    if ($(window).width < 768) {
        resizeImage(".news-dt .new-cnt.sc .it-news.fr .img", 9 / 16)
    }
    if ($(window).width() >= 768) {
        resizeImage(".left-intro span", 370 / 565)
        resizeImage(".slide-conts .img", 390 / 590)
        resizeImage(".lst-pro .img", 10 / 16)
        resizeImage(".img-pro", 378 / 600)
        resizeImage(".detail-leader .img", 457 / 364)
        resizeImage(".slide-lead .img", 160 / 277)
        resizeImage(".it-conts .img", 250 / 370)
        resizeImage(".news-cnt .it-news.fr .img", 260 / 570)
        resizeImage(".news-cnt .it-news:not(.it-news.fr) .img", 115 / 210)
        resizeImage(".news-cnt.sc .it-news .img", 200 / 370)
        resizeImage(".right-ns .img", 62 / 120)
        //resizeImage(".new .img", 130 / 245)
    }
    resizeImage(".video-about iframe", 9 / 16)
    var ck = Cookies.get('lang');
    if (ck == undefined)
        ck = 'vi';
    var current = $('html').attr('lang');
    if (ck != current) {
        window.location.reload();
    }
});
