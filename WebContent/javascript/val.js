
$(document).ready(function() {
	
	$("#usr").click(function () {
		refresh();
	});
	$("#pwd").click(function () {
	refresh();
	});
	
	
	
	
$("#regduser").click(function () {
	validUser=true;
	validPwd=true;
	refresh();
	var usr = $("#usr");
	var pwd = $("#pwd");
	if (usr.val() == '' ) {
		usr.addClass("errorbord");
		$(usr).before($('<div />', {
	        class: 'errormsg',
	        text: "Specify a user name for account",
	        click: function(e){
	            e.preventDefault();
	        }}));
		validUser=false;
		
	}
	if ( pwd.val() == '') {
		pwd.addClass("errorbord");
		$(pwd).before($('<div />', {
	        class: 'errormsg',
	        text: "Specify passowrd ",
	        click: function(e){
	            e.preventDefault();
	        }}));
		validPwd=false;
	}
	if (usr.val().length >0 && usr.val().length < 5){
		usr.addClass("errorbord");
		$(usr).before($('<div />', {
	        class: 'errormsg',
	        text: "user name should be more than 5 characters",
	        click: function(e){
	            e.preventDefault();
	        }}));
		validUser=false;
	}
	
	if (usr.val().length >5){
		var regex = /^[a-zA-Z0-9]+$/;
		
		if(!regex.test(usr.val())){
			$(usr).before($('<div />', {
		        class: 'errormsg',
		        text: "user name should be alphanumeric",
		        click: function(e){
		            e.preventDefault();
		        }}));
			validUser=false;
		}
		
	}
	var pwdReg =  /^[a-zA-Z0-9]+$/;
	var pwdSpl = /^[^a-zA-Z0-9]+$/;
	if ( pwd.val() !='' && pwd.val().length < 8 ) {
		pwd.addClass("errorbord");
		$(pwd).before($('<div />', {
	        class: 'errormsg',
	        text: "minimum 8 characters & least 1 number, 1 uppercase, and 1 lowercase character",
	        click: function(e){
	            e.preventDefault();
	        }}));
		validPwd=false;
	} else if ( pwd.val().length >= 8){
		
	    if ( pwdReg.test(pwd.val()) && !pwdSpl.test(pwd.val()) ) {
			validPwd=true;
		}else {
			
			pwd.addClass("errorbord");
			$(pwd).before($('<div />', {
		        class: 'errormsg',
		        text: "minimum 8 characters with at least 1 number, 1 uppercase, and 1 lowercase character",
		        click: function(e){
		            e.preventDefault();
		        }}));
			validPwd=false;

		}
	}
	
	 if(validUser && validPwd){

		 $("#userregistration").submit();
	 }
});  
}); 

function refresh(){
	$('.errormsg').remove();
	$("#usr").removeClass("errorbord");
	$("#pwd").removeClass("errorbord");

	
}


