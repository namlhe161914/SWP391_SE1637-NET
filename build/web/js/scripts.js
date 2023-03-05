window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});

 // Lấy các phần tử cần thiết
            var select = document.getElementById("InforCateId"); // phần tử select để lọc
            var table = document.getElementById("adminAccountTable"); // bảng sản phẩm
            var rows = table.getElementsByTagName("tr"); // các hàng trong bảng

// Thêm sự kiện khi người dùng chọn một giá trị khác nhau
            select.addEventListener("change", function () {
                var filter = select.value; // lấy giá trị được chọn
                for (var i = 0; i < rows.length; i++) { // duyệt qua các hàng trong bảng
                    var category = rows[i].getElementsByTagName("td")[6]; // lấy phần tử thể loại trong mỗi hàng (ở cột đầu tiên)
                    if (category) { // nếu có phần tử thể loại
                        var textValue = category.textContent || category.innerText; // lấy giá trị văn bản của phần tử thể loại
                        if (textValue === filter || filter === "All") { // nếu giá trị văn bản bằng với giá trị được chọn hoặc giá trị được chọn là "All"
                            rows[i].style.display = ""; // hiển thị hàng đó
                        } else { // nếu không bằng với giá trị được chọn
                            rows[i].style.display = "none"; // ẩn hàng đó đi
                        }
                    }
                }
            });