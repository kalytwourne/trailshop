
		
/*scroll to top*/

$(document).ready(function(){
	$(function () {
		$.scrollUp({
	        scrollName: 'scrollUp', // Element ID
	        scrollDistance: 300, // Distance from top/bottom before showing element (px)
	        scrollFrom: 'top', // 'top' or 'bottom'
	        scrollSpeed: 300, // Speed back to top (ms)
	        easingType: 'linear', // Scroll to top easing (see http://easings.net/)
	        animation: 'fade', // Fade, slide, none
	        animationSpeed: 200, // Animation in speed (ms)
	        scrollTrigger: false, // Set a custom triggering element. Can be an HTML string or jQuery object
					//scrollTarget: false, // Set a custom target element for scrolling to the top
	        scrollText: '<i class="fa fa-angle-up"></i>', // Text for element, can contain HTML
	        scrollTitle: false, // Set a custom <a> title if required.
	        scrollImg: false, // Set true to use image
	        activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
	        zIndex: 2147483647 // Z-Index for the overlay
		});
	});
	onLoadproducts();
	
	
	
});
$body = $("body");

$(document).on({
    ajaxStart: function() { 
    	$body.addClass("loading");    },
    ajaxStop: function() {
    	$body.removeClass("loading"); }    
});

		 
		 function onLoadproducts(){
			 var ajaxUrl="LoadProducts.action";
			 var callbackFunc="showProducts";
			 var callbackFailed="showProductsFail";
			 shopAjax(ajaxUrl,callbackFunc,callbackFailed);
		}
		 
		 function shopAjax(ajaxUrl){
			$.ajax({
                 type: "GET", 		
                 url: ajaxUrl, 		
                 data: "queryproducts", 		
                 dataType: "html", 
                 cache:false,
                 processdata: true, 	
                 success: function(data){
     			   $("#browse_products").html(data);
     			   $('.add-to-cart').each(function(i, obj) {
     				var productId = $(this).parent().children('#productId').val();
     				 $(this).bind( "click", function() {
     					addToCartAjax('AddtoCartJson.action',productId);
     				 });
     			   });
     			    
                	 
                 },
                 
                 error: function(data){
     			    $("#browse_products").html(data);
                	 
                 }	
             });
		 }
		 
		 
		 
		 
		 function addToCartAjax(ajaxUrl,productId){
				$.ajax({
	                 type: "POST", 		
	                 url: ajaxUrl, 		
	                 data: { 
	                     'productId': productId 
	                 },	
	                 dataType: "json", 
	                 cache:false,
	                 processdata: true, 	
	                 success: function(data){
	                	 setCookie("trailcart",data);
	                	 var cartHtml = '<a href="#"><i class="fa fa-shopping-cart"></i> Cart (' + data.cartQuantity + ') </a>';
	                	 $("#trailcart").html(cartHtml);
	                 },
	                 
	                 error: function(data){
		     			   console.log(data);
	                	 
	                 }	
	             });
			 }
		 
		 
		 function setCookie(cookieName,cookieData){
			 $.cookie.json = true;
        	 $.cookie("trailcart", cookieData);
		 }
		 