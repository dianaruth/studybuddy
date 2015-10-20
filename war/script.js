$(function(){
	$('#studentSignUp').hide();
	$('#tutorSignUp').hide();
	$('#showLogIn').hide();
	
	$(document.body).on('click', '#showStudent', function(){
			$('#studentSignUp').show();
			$('#tutorSignUp').hide();
			$('#logIn').hide();
			$('#showLogIn').show();
			$('#showTutor').show();
			$('#showStudent').hide();
			console.log("test");
	})
})