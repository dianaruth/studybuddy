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
	<script src="//use.edgefonts.net/just-another-hand;londrina-sketch.js"></script>
	<!-- <script src='script.js'></script>-->
	
	<script type='text/javascript'>
	
	// hide other panels when a panel is clicked
	$(function(){
		$('#studentSignUp').hide();
		$('#tutorSignUp').hide();
		$('#showLogin').hide();
		$("#panel").css("margin-top", (window.innerHeight*0.12));
		$("#panel").css("margin-bottom", (window.innerHeight*0.12));
		
		// student sign up button clicked
		$(document.body).on('click', '#showStudent', function(){
			$('#studentSignUp').show();
			$('#tutorSignUp').hide();
			$('#login').hide();
			$('#showLogin').show();
			$('#showTutor').show();
			$('#showStudent').hide();
			console.log("test");
		})
		
		// tutor sign up button clicked
		$(document.body).on('click', '#showTutor', function(){
			$('#studentSignUp').hide();
			$('#tutorSignUp').show();
			$('#login').hide();
			$('#showLogin').show();
			$('#showTutor').hide();
			$('#showStudent').show();
		})
		
		// login button clicked
		$(document.body).on('click', '#showLogin', function(){
			$('#studentSignUp').hide();
			$('#tutorSignUp').hide();
			$('#login').show();
			$('#showLogin').hide();
			$('#showTutor').show();
			$('#showStudent').show();
		})
		
		// form validation for student sign up
		$(document.body).on('click', '#studentSignUpSubmit', function(){
			if($('#studentFirstName').val().length > 0 && $('#studentLastName').val().length > 0 && $('#studentEmail').val().length > 0) {
				if ($('#studentPassword1').val().length > 0 && $('#studentPassword1').val() == $('#studentPassword2').val()) {
					$('#studentSignUp').submit();
				}
			}
		})
		
		// form validation for tutor sign up
		$(document.body).on('click', '#tutorSignUpSubmit', function(){
			if($('#tutorFirstName').val().length > 0 && $('#tutorLastName').val().length > 0 && $('#tutorEmail').val().length > 0 && $('#tutorRate').val().length > 0) {
				if ($('#tutorPassword1').val().length > 0 && $('#tutorPassword1').val() == $('#tutorPassword2').val()) {
					$('#tutorSignUp').submit();
				}
			}
		})
	})
	</script>
</head>

<body style="background: url(img/studybackground.jpeg); background-size: 100%;">
	<div id="panel" class="container col-sm-offset-3 col-sm-6 col-sm-offset-3" style="background: rgba(153, 153, 153, 0.9);">
		<div id="title">
			<h1 style="font-family: londrina-sketch, sans-serif; font-size: 100px; text-align: center;">Study Buddy</h1>
			<h1 style="font-family: just-another-hand, cursive; text-align: center;">Find your buddy.</h1>
		</div>
		<div id="forms">
			<form id='login' method='post' action=''>
				<div class="form-group">
					Username
					<input type="email" class='form-control'>
				</div>
				<div class="form=group">
					Password
					<input type="password" class='form-control'>
				</div>
				<br>
				<input type='submit' style="width: 30%" class='btn btn-block btn-primary' id='loginSubmit' value='Submit'>
			</form>
			<form id='studentSignUp' method='post' action='/studentSignUp'>
				<hr>
				<h3>Sign Up as a Student</h3>
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
				<br>
				<button type='button' style="width: 30%" class='btn btn-block btn-primary' id='studentSignUpSubmit'>Submit</button>
			</form>
			<form id='tutorSignUp' method='post' action='/tutorSignUp'>
				<hr>
				<h3>Sign Up as a Tutor</h3>
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
				<br>
				<button type='button' style="width: 30%" class='btn btn-block btn-primary' id='tutorSignUpSubmit'>Submit</button>
			</form>
		</div>
		<div id="signup-buttons"  style="margin-bottom: 30px; margin-top: 30px;">
			<button class= 'btn btn-default' id='showStudent'>Sign Up as Student</button>
			<button class= 'btn btn-default' id='showTutor'>Sign Up as Tutor</button>
			<button class= 'btn btn-default' id='showLogin'>Log In with Existing Account</button>
		</div>
	</div>
</body>
</html>