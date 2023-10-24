<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>

<!-- SPRING FORM -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!-- JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Houji Photo</title>

    <jsp:include page="/WEB-INF/views/khachhang/layouts/css.jsp"></jsp:include>
</head>
<body>
<main class="container">
    <div class="free">Miễn phí vận chuyển với đơn hàng trên 1000k</div>

    <jsp:include page="/WEB-INF/views/khachhang/layouts/header.jsp"></jsp:include>

    <%--open content --%>
    <div class="content">
        <img src="${base }/img/bannerhouji.png" width="100%">

        <!--open new item-->

        <div class="products">
            <div class="products-name">
                <a href="#"> SẢN PHẨM </a>
            </div>

            <div class="list-product" style="flex-wrap: wrap;">

                <c:forEach items="${productsWithPaging.data }" var="product">
                    <div class="item">

                        <div class="item-images">
                            <a href="${base }/product/details/${product.seo}"> <img
                                    src="${base }/upload/${product.avatar}"
                                    width="100%">
                            </a>
                        </div>
                        <div class="item-content">
                            <a href="${base }/product/details/${product.seo}">
                                    ${product.title } </a>
                            <div class="price">
                                <fmt:setLocale value="vi_VN"/>
                                <fmt:formatNumber value="${product.price}" type="currency"/>

                            </div>

                        </div>
                    </div>

                    <!-- Paging -->

                </c:forEach>
            </div>

            <!--open product-->

<%--            <div class="logo-item">--%>
<%--                <div class="logo-item-list">--%>
<%--                    <a href="${base }/collection"> <img--%>
<%--                            src="${base }/img/tshirt.png" width="100%">--%>
<%--                    </a>--%>
<%--                    <h3 class="logo-name">T-SHIRT</h3>--%>
<%--                    <div class="add">--%>
<%--                        <a href="${base }/collection">MUA NGAY</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="logo-item-list">--%>
<%--                    <a href="${base }/collection"> <img--%>
<%--                            src="${base }/img/collection.png" width="100%">--%>
<%--                    </a>--%>
<%--                    <h3 class="logo-name-collection">COLLECTION</h3>--%>
<%--                    <div class="add-collection">--%>
<%--                        <a href="${base }/collection">XEM THÊM</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="logo-item-list">--%>
<%--                    <a href="${base }/collection"> <img--%>
<%--                            src="${base }/img/hoodie.png" width="100%">--%>
<%--                    </a>--%>
<%--                    <h3 class="logo-name">HOODIE</h3>--%>
<%--                    <div class="add">--%>
<%--                        <a href="${base }/collection">MUA NGAY</a>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
        <!--close products-->

        <!--open about us -->
        <div class="about">
            <div class="about-us">
                <a href="${base }/introduction"> <img
                        src="${base }/img/aboutus.png" width="80%">
                </a>
                <h3 class="about-title">ABOUT US</h3>
                <div class="about-button">
                    <a href="${base }/introduction"> XEM NGAY </a>
                </div>
            </div>
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
        <!--close about us-->

    </div>
    <!--close content-->

    <%--close content --%>
    <jsp:include page="/WEB-INF/views/khachhang/layouts/footer.jsp"></jsp:include>
    <div class="copyright">
        Copyright <i class="far fa-copyright"></i> <a href="#">houji. photo. </a> <a
            href="#">Powered by Haravan</a>
    </div>
</main>

</body>
<jsp:include page="/WEB-INF/views/khachhang/layouts/js.jsp"></jsp:include>
</html>