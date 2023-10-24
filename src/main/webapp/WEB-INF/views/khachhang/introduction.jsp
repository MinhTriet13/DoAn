<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!--import JSTL-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- import SPRING-FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Giới thiệu</title>
    <link rel="stylesheet"
          href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
          integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
          crossorigin="anonymous"/>
    <jsp:include page="/WEB-INF/views/khachhang/layouts/css.jsp"></jsp:include>
    <link rel="stylesheet" type="text/css" href="${base}/css/introduction.css">

</head>
<body>
<main class="container">

    <div class="free">Miễn phí vận chuyển với đơn hàng trên 1000k</div>
    <!--open header-->
    <jsp:include page="/WEB-INF/views/khachhang/layouts/header.jsp"></jsp:include>
    <!--close header-->

    <div class="navigation">
        <ul>
            <li><a href="${base }/home">Trang chủ </a></li>

            <li>/</li>

            <li>Giới thiệu</li>


        </ul>
    </div>
    <!-- open content -->
    <div class="content">
        <div class="content-title">
            <h4>Danh mục trang</h4>
            <div class="layer">
                <ul>
                    <li><a href="#">Tìm kiếm</a></li>
                    <li><a href="${base }/introduction">Giới thiệu</a></li>
                    <li><a href="#">Chính sách đổi trả</a></li>
                    <li><a href="#">Chính sách bảo mật</a></li>
                    <li><a href="#">Điều khoản dịch vụ</a></li>
                </ul>
            </div>
        </div>
        <div class="content-intro">
            <h3>Lời giới thiệu</h3>
            <div class="about-us">
                <p>HOUJI là một cửa hàng chuyên về máy ảnh cũ tại trung tâm thành phố, nơi bạn có thể tìm thấy những bức
                    ảnh đẹp và lưu giữ những kỷ niệm đáng nhớ bằng những chiếc máy ảnh độc đáo.</p>

                <p>Với nhiều năm kinh nghiệm trong lĩnh vực này, chúng tôi tự hào cung cấp một loạt các sản phẩm máy ảnh
                    chất lượng, từ máy ảnh phim retro đến máy ảnh kỹ thuật số hiện đại.</p>

                <p>Chúng tôi có một bộ sưu tập đa dạng các máy ảnh cổ điển và vintage từ các thương hiệu nổi tiếng như
                    Nikon, Sony , Panasonic và Fujifilm, Casio.</p>

                <p>Tất cả các sản phẩm của chúng tôi đều đã được kiểm tra và bảo trì để đảm bảo hoạt động tốt nhất, mang
                    lại trải nghiệm tuyệt vời nhất cho khách hàng.</p>

                <p>Hiện tại Houji đang hoạt động trên các trang bán hàng như Facebook, Instagram, Website. Quý khách
                    hàng có thể liên hệ đặt hàng quá các kênh sau:</p>

                <p>Instagram: Houji Photo</p>

                <p>Facebook: Houji Photo</p>

                <p>Số điện thoại liên lạc: 0928475944</p>

                <p>Địa chỉ: 66/30 Phổ Quang, Phường 2, Quận Tân Binh, Thành phố Hồ Chí Minh</p>
            </div>
        </div>
    </div>
    <!--close content-->

    <!--open footer -->
    <jsp:include page="/WEB-INF/views/khachhang/layouts/footer.jsp"></jsp:include>
    <!--close footer-->
    <div class="copyright">
        Copyright <i class="far fa-copyright"></i> <a href="#">houji. photo. </a> <a
            href="#">Powered by Haravan</a>
    </div>
</main>
</body>

<jsp:include page="/WEB-INF/views/khachhang/layouts/js.jsp"></jsp:include>
<script type="text/javascript">

</script>
</html>