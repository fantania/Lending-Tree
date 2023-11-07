<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>
<html class="no-js" lang="">

<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Lending Tree</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="/resources/image/png"
	href="<c:url value="/resources/images/favicon.png" /> ">
<!-- Place favicon.ico in the root directory -->
<!-- all css here -->
<!-- bootstrap v3.3.7 css -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- animate css -->
<link href="<c:url value="/resources/css/animate.css" />"
	rel="stylesheet">
<!-- owl.carousel.2.0.0-beta.2.4 css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/owl.carousel.min.css" /> ">
<!-- swiper.min.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/swiper.min.css" />">
<!-- font-awesome v4.6.3 css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/font-awesome.min.css" />">
<!-- flaticon.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/flaticon.css" />">
<!-- magnific-popup.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/magnific-popup.css" />">
<!-- metisMenu.min.css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/metisMenu.min.css" />">
<!-- style css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/styles.css" />">
<!-- responsive css -->
<link rel="stylesheet"
	href="<c:url value="/resources/css/responsive.css" />">
<!-- modernizr css -->
<script
	src="<c:url value="/resources/js/vendor/modernizr-2.8.3.min.js" />"></script>
</head>

<body>
	<!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please 
<a href="http://browsehappy.com/">upgrade your browser</a> to improve your 
experience.</p>
        <![endif]-->

	<!-- header-area start -->
	<header class="header-area header-area2">
		<div class="header-top">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 col-md-8 col-12">
						<ul class="contact-info d-flex">
							<li><span><i class="fa fa-phone"></i> +02 0120 2651
									021</span> <span><i class="fa fa-fax"></i> +00 425 356 4518</span></li>
							<li><span><i class="fa fa-envelope"></i>
									info@youremail.com</span> <span><i class="fa fa-paper-plane-o"></i>
									www.yourwebsite.com</span></li>
						</ul>
					</div>
					<div class="col-xl-7 col-lg-6 col-sm-4 col-12 d-none d-md-block">
						<ul class="social-icon d-flex justify-content-end">
							<li class="facebook"><a href="#"><i
									class="fa 
fa-facebook"></i></a></li>
							<li class="twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
							<li class="google-plus"><a href="#"><i
									class="fa 
fa-google-plus"></i></a></li>
							<li class="linkedin"><a href="#"><i
									class="fa 
fa-linkedin"></i></a></li>
							<li class="youtube"><a href="#"><i class="fa fa-youtube"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="header-bottom bg-2">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 col-sm-7">
						<div class="logo">
							<a href="http://localhost:8181/LedingTree1/"> <img
								src="<c:url value="/resources/images/logo3.png"/>" alt="">
							</a>
						</div>
					</div>
					<div class="col-lg-7 col-sm-9 d-none d-lg-block">
						<ul class="mainmenu d-flex justify-content-end">
							<li class="active"><a href="javascript:void(0);">Home <i
									class="fa 
fa-angle-down"></i></a>
								<ul>
									<li><a href="index.html">Home Main</a></li>
									<li><a href="index2.html">Home Two</a></li>
									<li><a href="index3.html">Home Three</a></li>
								</ul></li>
							<li><a href="about.html">about us</a></li>
							<li><a href="javascript:void(0);">pages</a>
								<ul>
									<li><a href="service.html">Service Page</a></li>
									<li><a href="service-details.html">Service Details</a></li>
									<li><a href="shop.html">Shop page</a></li>
								</ul></li>
							<li><a href="blog.html">blog</a>
								<ul>
									<li><a href="blog.html">Blog page</a></li>
									<li><a href="blog-left.html">Blog Left</a></li>
									<li><a href="blog-right.html">Blog right</a></li>
									<li><a href="blog-details.html">Blog Details</a></li>
								</ul></li>
							<li><a href="contact.html">contact</a></li>
						</ul>
					</div>
					<div class="col-lg-2 col-sm-3 col-8">
						<div class="geta_quote">
							<a href="#">GET A QUOTE?</a>
						</div>
					</div>
					<div class="d-block d-lg-none col-4 pull-right col-sm-2">
						<ul class="menu">
							<li class="first"></li>
							<li class="second"></li>
							<li class="third"></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- responsive-menu area start -->
			<div class="responsive-menu-area d-block d-sm-none">
				<div class="container">
					<div class="row">
						<div class="col-12">
							<ul class="metismenu">
								<li class="sidemenu-items"><a class="has-arrow"
									aria-expanded="false" href="javascript:void(0);">Home</a>
									<ul aria-expanded="false">
										<li><a href="index.html">Home Main</a></li>
										<li><a href="index2.html">Home Two</a></li>
										<li><a href="index3.html">Home Three</a></li>
									</ul></li>
								<li><a href="about.html">about us</a></li>
								<li class="sidemenu-items"><a class="has-arrow"
									aria-expanded="false" href="javascript:void(0);">pages</a>
									<ul aria-expanded="false">
										<li><a href="service.html">Service Page</a></li>
										<li><a href="service-details.html">Service Details</a></li>
										<li><a href="shop.html">Shop page</a></li>
									</ul></li>
								<li class="sidemenu-items"><a class="has-arrow"
									aria-expanded="false" href="javascript:void(0);">blog</a>
									<ul aria-expanded="false">
										<li><a href="blog.html">Blog page</a></li>
										<li><a href="blog-left.html">Blog Left</a></li>
										<li><a href="blog-right.html">Blog right</a></li>
										<li><a href="blog-details.html">Blog Details</a></li>
									</ul></li>
								<li><a href="contact">contact</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- responsive-menu area start -->
		</div>

	</header>
	<!-- header-area end -->

	<!-- slider-area start -->
	<div class="slider-area slider-area2">
		<div class="slider-active owl-carousel">
			<div class="slider-items">
				<img src="<c:url value="/resources/images/slider/1.jpg"/>" alt=""
					class="slider">
				<div class="slider-content flex-style text-center">
					<div class="container">
						<div class="row">
							<div class="col-12">
								<h2>
									<span>We Are here</span> To help Everyone
								</h2>
								<p>Getting the best deal possible on your loans, period. By
									giving consumers multiple offers from several lenders in a
									matter of minutes, we make comparison shopping easy. And we all
									know-when lenders compete for your business, you win!.</p>
								<ul>
									<!--<li><a href="#">Read more</a></li>-->
									<li><a href="http://localhost:8181/LedingTree1/loanRequest/">APPLY FOR A LOAN</a></li>
									<li><a href="http://localhost:8181/LedingTree1/login">LOGIN</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="slider-items">
				<img src="<c:url value="/resources/images/slider/1.jpg"/>" alt=""
					class="slider">
				<div class="slider-content flex-style">
					<div class="container">
						<div class="row">
							<div class="text-center col-12">
								<h2>
									<span>We Are here</span> To help Everyone
								</h2>
								<p>Getting the best deal possible on your loans, period. By
									giving consumers multiple offers from several lenders in a
									matter of minutes, we make comparison shopping easy. And we all
									know-when lenders compete for your business, you win!.</p>
								<ul>
									<!--  <li><a href="#">Read more</a></li>-->
									<li><a href="#contact-form">APPLY FOR A LOAN</a></li>
									<li><a href="http://localhost:8181/LedingTree1/login">LOGIN</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider-area end -->

	<!-- featured-area start -->
	<div class="featured-area featured-area2">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="featured-wrapper">
						<div class="row">
							<div class="col-lg-4 col-sm-6 col-12">
								<div class="featured-wrap">
									<div class="featured-img">
										<img src="<c:url value="/resources/images/featured/1.jpg"/>"
											alt="">
									</div>
									<h2>
										<a href="#">Personal Loan</a>
									</h2>
									<p>Take Care of Your Needs with a Personal Loan Fund a
										major purchase. Pay off unexpected expenses. Consolidate debt.
										Take charge of your finances today.</p>
								</div>
							</div>
							<div class="col-lg-4 col-sm-6 col-12">
								<div class="featured-wrap">
									<div class="featured-img">
										<img src="<c:url value="/resources/images/featured/2.jpg"/>"
											alt="">
									</div>
									<h2>
										<a href="#">Home Loan</a>
									</h2>
									<p>Buying a home is one of the biggest purchase decisions
										you’ll ever make. But getting a mortgage loan doesn’t have to
										be difficult. That’s why LendingTree helps you find the right
										home financing with the right mortgage lender.</p>
								</div>
							</div>
							<div class="col-lg-4 col-sm-6 col-12">
								<div class="featured-wrap mb-0">
									<div class="featured-img">
										<img src="<c:url value="/resources/images/featured/3.jpg"/>"
											alt="">
									</div>
									<h2>
										<a href="#">Student Loan</a>
									</h2>
									<p>Whether you’ve just graduated high school and are
										working toward your Bachelor’s degree or you’re pursuing
										higher education, LendingTree’s student loan center can help
										you find the right loan – at the right price – for your
										desired degree.</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>
	<!-- featured-area end -->

	<!-- about-area start -->

	<div
		class="featured-content-area position-relative featured-content-area2"
		id="loan">
		<div class="row">
			<div class="col-12">
				<div class="section-title text-center">
					<h2>Apply for a loan</h2>
					<img src="<c:url value="/resources/images/line.png" /> " alt="">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-6 d-none d-lg-block">
					<div class="featured-content-images">
						<img src="<c:url value="/resources/images/mobail.jpg"/>" alt="">
					</div>
					<div class="featured-content-images" style="border-radius: 30px;">
						<img src="<c:url value="/resources/images/blog/4.jpg"/>" alt="">
					</div>
				</div>
				<div class="col-lg-6">
					<div class="featured-content-wrap flex-style">

						<spring:url value="/loanRequest/saveLoan" var="saveURL" />



						<!-- ********************************************************************BEGINING OF FORM********************************************************* -->

						<div class="contact-form" id="contact-form">
							<form method="POST" action="${saveURL}">
								<input type="text" placeholder="Name" name="name" /> <input
									type="text" placeholder="Email" name="email" /> <input
									type="number" placeholder="Phone" name="phone"> <input
									type="text" placeholder="Address" name="address" /> <input
									type="number" placeholder="SSN" name="ssn" /> <select
									class="form-control" name="loanType">

									<option>- - - - LOAN TYPE - - - -</option>
									<option value="Personal Loan">PERSONAL LOAN</option>
									<option value="Student Loan">STUDENT LOAN</option>
									<option value="Auto Loan">AUTO LOAN</option>
									<option value="Home Loan">HOME LOAN</option>

								</select><br /> DOCUMENTS:
								<table
									style="margin: 0 auto; border-collapse: separate; border-spacing: 3em;">
									<tr>
										<td><div class="checkbox">
												<label><input type="checkbox" value="National Id"
													name="documents">National ID</label>
											</div></td>
										<td><div class="checkbox">
												<label><input type="checkbox" value="Address Proof"
													name="documents">Address Proof</label>
											</div></td>
										<td><div class="checkbox">
												<label><input type="checkbox"
													value="Electricity Bills" name="documents">Electricity
													Bills</label>
											</div></td>
									</tr>
									<tr>
										<td><div class="checkbox">
												<label><input type="checkbox" value="Salary Slips"
													name="documents">Salary slips</label>
											</div></td>
										<td><div class="checkbox">
												<label><input type="checkbox" value="Employee Card"
													name="documents">Employee Card</label>
											</div></td>
										<td><div class="checkbox">
												<label><input type="checkbox" value="Water Bills"
													name="documents">Water Bills</label>
											</div></td>
									</tr>

								</table>
								<select class="form-control" name="bank">
									<!--  <option></option>-->
									<c:forEach items="${bnkNames}" var="bankName">
										<option value="${bankName}">${bankName}</option>
									</c:forEach>
								</select><br />
								<button type="submit">SUBMIT</button>
							</form>
						</div>
						<!-- ********************************************************************ENDING OF FORM********************************************************* -->

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- about-area end -->

	<!-- about-area start -->
	<div class="about-area position-relative">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-title text-center">
						<h2>About Bitcoin</h2>
						<img src="<c:url value="/resources/images/line.png" /> " alt="">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 d-none d-lg-block">
					<div class="about-img">
						<img src="<c:url value="/resources/images/about/1.jpg" /> " alt="">
					</div>
				</div>
				<div class="col-lg-6 col-12">
					<div class="about-content">
						<h3>Minimum purchase is 50 Coins tokens. Get a bonus from 5%
							to 25% on every token purchase</h3>
						<p>There are many variations of passages of Lorem Ipsum
							available, but the majority have suffered alteration in some
							form, by injected humour, or randomised words which don't look
							even slightly believable.</p>
					</div>
					<div class="row">
						<div class="col-sm-3 col-6">
							<div class="about-items">
								<img src="<c:url value="/resources/images/about/icon/1.png" /> "
									alt=""> <span class="counter">1454</span>
								<p>Support Countrie</p>
							</div>
						</div>
						<div class="col-sm-3 col-6">
							<div class="about-items">
								<img src="<c:url value="/resources/images/about/icon/2.png" /> "
									alt=""> <span class="counter">759</span>
								<p>Bank Support</p>
							</div>
						</div>
						<div class="col-sm-3 col-6">
							<div class="about-items mb-0">
								<img src="<c:url value="/resources/images/about/icon/3.png" /> "
									alt=""> <span class="counter">1250</span>
								<p>BitCoin ATMs</p>
							</div>
						</div>
						<div class="col-sm-3 col-6">
							<div class="about-items mb-0">
								<img src="<c:url value="/resources/images/about/icon/4.png" /> "
									alt=""> <span class="counter">2391</span>
								<p>Producers Ready</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- about-area end -->
	<!-- service-area start -->
	<div class="service-area">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="section-title text-center">
						<h2>Why Choose Bitcoin</h2>
						<img src="<c:url value="/resources/images/line.png"/>">
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6 col-12">
					<div class="service-wrap">
						<h3>What We Offer</h3>
						<p>There are many variations of passages of an Lorem Ipsum
							available but the about majority have suffered alteration in man
							some form a by injected humour or that randomised the a words
							which</p>
						<p>There are many variations of passages of an Lorem Ipsum
							available but the about majority have suffered.</p>
						<a href="#">Free Consultation</a>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 col-12">
					<div class="service-items">
						<span class="flaticon-bitcoin-9"></span>
						<h3>Safe And Secure</h3>
						<p>There are many variations of Lorem Ipsum available but the
							about some majority have form randomised words which believable.</p>
					</div>
					<div class="service-items">
						<span class="flaticon-profits"></span>
						<h3>Instant Exchange</h3>
						<p>There are many variations of Lorem Ipsum available but the
							about some majority have form randomised words which believable.</p>
					</div>
				</div>
				<div class="col-lg-4 col-12">
					<div class="row">
						<div class="col-lg-12 col-md-6 col-12">
							<div class="service-items">
								<span class="flaticon-exchange-1"></span>
								<h3>Secure Wallet</h3>
								<p>There are many variations of Lorem Ipsum available but
									the about some majority have form randomised words which
									believable.</p>
							</div>
						</div>
						<div class="col-lg-12 col-md-6 col-12">
							<div class="service-items">
								<span class="flaticon-bitcoin-7"></span>
								<h3>Experts Support</h3>
								<p>There are many variations of Lorem Ipsum available but
									the about some majority have form randomised words which
									believable.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- service-area end -->






	<!-- footer-area start -->
	<footer class="footer-area">
		<div class="footer-top">
			<div class="container">
				<div class="row">
					<div class="col-lg-3  col-sm-6 col-12">
						<div class="footer-widget footer-logo">
							<img src="<c:url value="/resources/images/logo2.png"/>" alt="">
							<p>There are many variations of passages of Lorem Ipsum
								available, but the dum majority have suffered alteration in the
								some form by injected.</p>
							<form action="#">
								<input type="text" placeholder="Enter your email">
								<button>subscribe</button>
							</form>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-12">
						<div class="footer-widget footer-menu">
							<h3>Our Services</h3>
							<ul>
								<li><a href="#"><i class="fa fa-angle-double-right"></i>
										Crypto Investments</a></li>
								<li><a href="#"><i class="fa fa-angle-double-right"></i>
										Customer Insights</a></li>
								<li><a href="#"><i class="fa fa-angle-double-right"></i>
										Bitcoin Analytics</a></li>
								<li><a href="#"><i class="fa fa-angle-double-right"></i>
										Bitcoin Exchange</a></li>
								<li><a href="#"><i class="fa fa-angle-double-right"></i>
										Bitcoin Exchange</a></li>
								<li><a href="#"><i class="fa fa-angle-double-right"></i>
										Business Consulting</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-12">
						<div class="footer-widget footer-twitter">
							<h3>Twitter Feeds</h3>
							<ul>
								<li><a href="#"><i class="fa fa-twitter"></i>
										https://twitter.com /envatO/ status/944202192013144064
										https://twitter.com/envato/status/ 944202192013144064</a></li>
								<li class="mb-0"><a href="#"><i class="fa fa-twitter"></i>
										https://twitter.com /envatO/ status/944202192013144064
										https://twitter.com/envato/status/ 944202192013144064</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-3 col-sm-6 col-12">
						<div class="footer-widget footer-contact">
							<h3>Contact Information</h3>
							<ul class="footer-contact-info">
								<li><span>Location: </span> W Jackson Blvd, Chicago United
									States</li>
								<li><span>Email: </span> exampleemail.com</li>
								<li><span>Phone: </span> (123) 45678910</li>
							</ul>
							<h5>We are Social</h5>
							<ul class="social-icon d-flex">
								<li class="facebook"><a href="#"><i
										class="fa 
fa-facebook"></i></a></li>
								<li class="twitter"><a href="#"><i
										class="fa 
fa-twitter"></i></a></li>
								<li class="google-plus"><a href="#"><i
										class="fa 
fa-google-plus"></i></a></li>
								<li class="linkedin"><a href="#"><i
										class="fa 
fa-linkedin"></i></a></li>
								<li class="youtube"><a href="#"><i
										class="fa 
fa-youtube"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<div class="col-12 copyright">
						<p>
							<!-- Link back to Colorlib can't be removed. Template is licensed 
under CC BY 3.0. -->
							Copyright &copy;
							<script>document.write(new Date().getFullYear());</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart-o" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank" class="text-primary">Colorlib</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- footer-area end -->

	<!-- jquery latest version -->
	<script
		src="<c:url value="/resources/js/vendor/jquery-2.2.4.min.js" />"></script>
	<!-- popper.min.js -->

	<script src="<c:url value="/resources/js/vendor/popper.min.js" />"></script>
	<!-- bootstrap js -->

	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
	<!-- owl.carousel.2.0.0-beta.2.4 css -->

	<script src="<c:url value="/resources/js/owl.carousel.min.js" />"></script>
	<!-- swiper.min.js -->

	<script src="<c:url value="/resources/js/swiper.min.js" />"></script>
	<!-- mailchimp.js -->

	<script src="<c:url value="/resources/js/mailchimp.js" />"></script>
	<!-- plugins js -->

	<script src="<c:url value="/resources/js/jquery.canvasjs.min.js" />"></script>
	<!-- metisMenu.min.js -->

	<script src="<c:url value="/resources/js/metisMenu.min.js" />"></script>
	<!-- plugins js -->

	<script src="<c:url value="/resources/js/plugins.js " />"></script>

	<script>
            // chart
    window.onload = function () {
    var limit = 10000;    //increase number of dataPoints by increasing the limit
    var y = 100;    
    var data = [];
    var dataSeries = { type: "line" };
    var dataPoints = [];
    for (var i = 0; i < limit; i += 1) {
        y += Math.round(Math.random() * 10 - 5);
        dataPoints.push({
            x: i,
            y: y
        });
    }
    dataSeries.dataPoints = dataPoints;
    data.push(dataSeries);

    //Better to construct options first and then pass it as a parameter
    var options = {
        zoomEnabled: true,
        animationEnabled: true,
        axisY: {
            includeZero: false
        },
        data: data  // random data
    };

        $("#chartContainer").CanvasJSChart(options);
    }
    </script>
	<!-- main js -->

	<script src="<c:url value="/resources/js/scripts.js " />"></script>
</body>

</html>