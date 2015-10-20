<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>



<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<script src='https://code.jquery.com/jquery-1.11.3.min.js'></script>
	<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
	<!-- <script src='script.js'></script>-->
	<script type='text/javascript'>
	$(function(){
		$('#studentSignUp').hide();
		$('#tutorSignUp').hide();
		$('#showLogIn').hide();
		
		$(document.body).on('click', '#showStudent', function(){
			$('#studentSignUp').show();
			$('#tutorSignUp').hide();
			$('#login').hide();
			$('#showLogIn').show();
			$('#showTutor').show();
			$('#showStudent').hide();
			console.log("test");
		})
		
		$(document.body).on('click', '#showTutor', function(){
			$('#studentSignUp').hide();
			$('#tutorSignUp').show();
			$('#login').hide();
			$('#showLogIn').show();
			$('#showTutor').hide();
			$('#showStudent').show();
		})
		
		$(document.body).on('click', '#showLogIn', function(){
			$('#studentSignUp').hide();
			$('#tutorSignUp').hide();
			$('#login').show();
			$('#showLogIn').hide();
			$('#showTutor').show();
			$('#showStudent').show();
		})
		
		$(document.body).on('click', '#studentSignUpSubmit', function(){
			console.log("clicked student sign up");
			var valid = true;
			if($('#studentFirstName').val().length >  0 && $('#studentLastName').val().length >  0 && $('#studentEmail').val().length >  0 && $('#studentPassword1').val().length >  0 && $('#studentPassword1').val() == $('#studentPassword2').val()){
				$('#studentSignUp').submit();
			}
		})
		$(document.body).on('click', '#tutorSignUpSubmit', function(){
			console.log("clicked tutor sign up");
			if($('#tutorFirstName').val().length >  0 && $('#tutorLastName').val().length >  0 && $('#tutorEmail').val().length >  0 && $('#tutorPassword1').val().length >  0 && $('#tutorPassword1').val() == $('#tutorPassword2').val() && $('#tutorRate').val() > 0){
				$('#studentSignUp').submit();
			}
		})
	})
	</script>
</head>

<body>
	<div class="container">
		<form id='login' method='post' action=''>
			<div class="form-group">
				Username
				<input type="email" class='form-control'>
			</div>
			<div class="form=group">
				Password
				<input type="password" class='form-control'>
			</div>
			<input type='submit' class='btn btn-block btn-primary' id='loginSubmit' value='Submit'>
		</form>
		<form id='studentSignUp' method='post'>
			<div class='form-group'>
				First Name 
				<input type='text' id='studentFirstName' name='firstName' class='form-control'>
			</div>
			<div class='form-group'>
				Last Name 
				<input type='text' id='studentLastName' name='lastName' class='form-control'>
			</div>
			<div class='form-group'>
				Email 
				<input type='email' id='studentEmail' name='email' class='form-control'>
			</div>
			<div class='form-group'>
				Password
				<input type='password' id='studentPassword1' name='password' class='form-control'>
			</div>
			<div class='form-group'>
				Repeat Password
				<input type='password' id='studentPassword2' name='password2' class='form-control'>
			</div>
			<button type='button' class='btn btn-block btn-primary' id='studentSignUpSubmit'>Submit</button>
		</form>
		<form id='tutorSignUp' method='post'>
			<div class='form-group'>
				First Name 
				<input type='text' id='tutorFirstName' name='firstName' class='form-control'>
			</div>
			<div class='form-group'>
				Last Name 
				<input type='text' id='tutorLastName' name='lastName' class='form-control'>
			</div>
			<div class='form-group'>
				Email 
				<input type='email' id='tutorEmail' name='email' class='form-control'>
			</div>
			<div class='form-group'>
				Hourly Rate
				<input type='number' min='0' id='tutorRate' name='price' class='form-control'>
			</div>
			<div class='form-group'>
				Password
				<input type='password' id='tutorPassword1' name='password' class='form-control'>
			</div>
			<div class='form-group'>
				Repeat Password
				<input type='password' id='tutorPassword2' name='password2' class='form-control'>
			</div>
			<button type='button' class='btn btn-block btn-primary' id='tutorSignUpSubmit'>Submit</button>
		</form>
		<button class= 'btn btn-default' id='showStudent'>Sign Up as Student</button>
		<button class= 'btn btn-default' id='showTutor'>Sign Up as Tutor</button>
		<button class= 'btn btn-default' id='showLogIn'>Log In with Existing Account</button>
	</div>
</body>
</html>