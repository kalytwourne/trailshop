<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Trail Shop</title>
<meta name="description" content="The Trail Shop; Shopping Network">
<meta name="author" content="Kalyan">
<link href="css/admin.css" rel="stylesheet" type="text/css">
<link href="css/base.css" rel="stylesheet" type="text/css">

<script src="/Simpleuser/javascript/jquery-1.11.1.js" type="text/javascript"></script>
<script src="/Simpleuser/javascript/val.js" type="text/javascript"></script>

</head>
<body>

<div class="container">
<header>

<nav>

</nav>

<div class="head">

</div>


</header>

<div id="main">
	<section id="content">
		<div id="center">
			<h3> Products on sale</h3>

			<form action="CreateProduct.action" method="post"  name="listProducts" id="listProducts">
			
			<ul class="listproducts">
			
			  <s:iterator value="products">
					<li class="product">
		                    <div class="img"><a href="#"><img alt="" src="images/<s:property value="productUrl" />"></a></div>
		                    <div class="info">
		                        <a class="title" href="#"><s:property value="name" /></a>
		                        <p class="description"><s:property value="description" /></p>
		                        <div class="price">
		                            <span class="st">Our price:</span><strong><s:property value="unitPrice" /></strong>
		                        </div>
		                        <div class="actions">
		                            <a href="#">Details</a>
		                            <a href="#">Add to cart</a>
		                        </div>
		                    </div>
		                </li>
			
				  </s:iterator>
				
			
            </ul>
			</form>
	
		</div>
	</section>

</div>


<footer><!-- Defining the footer section of the page -->
        <div id="privacy">

        </div>

    </footer>


</div>


</body>
</html>
