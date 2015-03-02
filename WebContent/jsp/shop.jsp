<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Kalyan">
    <title> Trial Shop</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/main.css" rel="stylesheet">
	<link href="css/responsive.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="/trailshop/javascript/html5shiv.js"></script>
    <script src="/trailshop/javascript/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
   
</head><!--/head-->

<body>
	<header id="header"><!--header-->
		<div class="header_top"><!--header_top-->
			<div class="container">
				
			</div>
		</div><!--/header_top-->
		
		<div class="header-middle"><!--header-middle-->
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<div class="logo pull-left">
							<a href="index.html"><img src="images/logo.png" alt="" /></a>
						</div>
						
					</div>
					<div class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="checkout.html"><i class="fa fa-crosshairs"></i> Checkout</a></li>
								<li id="trailcart"><a href="#"><i class="fa fa-shopping-cart"></i> Cart Empty</a></li>							</ul>
						</div>
					</div>
				</div>
			</div>
		</div><!--/header-middle-->
	
		</div>
	</header>
	
	
	
	<section>
		<div class="container">
			<div class="col-sm-12 padding-right">
					<div id="browse_products" class="browse_products">
						<h2 class="title text-left">Browse Products</h2>
						    <div class="product-image-wrapper">
								Retreiving products...
							</div>
                    </div><!--features_items-->
				</div>
			</div>
		</div>
	</section>
	
	<footer id="footer"><!--Footer-->
		
		
		
		<div class="footer-bottom">
			<div class="container">
				<div class="row">
					<p class="pull-left">Copyright © 2015 TrailShop. All rights reserved.</p>
					<p class="pull-right">Designed by <span><a target="_blank" href="http://www.kalyansundar.com">Kalyan</a></span></p>
				</div>
			</div>
		</div>
		
	</footer><!--/Footer-->
    <div class="modal"></div>
  
    <script src="/trailshop/javascript/jquery-1.11.1.js"></script>
    <script src="/trailshop/javascript/jquery.scrollUp.min.js"></script>
	<script src="/trailshop/javascript/bootstrap.min.js"></script>
    <script src="/trailshop/javascript/main.js"></script>
        <script src="/trailshop/javascript/jquery.cookie.js"></script>

</body>
</html>