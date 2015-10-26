// hide other panels when a panel is clicked
$(function(){
	$('#studentSignUp').hide();
	$('#tutorSignUp').hide();
	$('#showLogin').hide();
	$('#forgotPasswordForm').hide();
	$("#panel").css("margin-top", (window.innerHeight*0.07));
	$("#panel").css("margin-bottom", (window.innerHeight*0.07));
	
	// student sign up button clicked
	$(document.body).on('click', '#showStudent', function(){
		$('#studentSignUp').show();
		$('#tutorSignUp').hide();
		$('#login').hide();
		$('#forgotPasswordForm').hide();
		$('#forgotPassword').hide();
		$('#showLogin').show();
		$('#showTutor').show();
		$('#showStudent').hide();
	})
	
	// tutor sign up button clicked
	$(document.body).on('click', '#showTutor', function(){
		$('#studentSignUp').hide();
		$('#tutorSignUp').show();
		$('#login').hide();
		$('#forgotPasswordForm').hide();
		$('#forgotPassword').hide();
		$('#showLogin').show();
		$('#showTutor').hide();
		$('#showStudent').show();
	})
	
	// login button clicked
	$(document.body).on('click', '#showLogin', function(){
		$('#studentSignUp').hide();
		$('#tutorSignUp').hide();
		$('#login').show();
		$('#forgotPasswordForm').hide();
		$('#forgotPassword').hide();
		$('#showLogin').hide();
		$('#showTutor').show();
		$('#showStudent').show();
		$('#forgotPassword').show();
	})
	
	// forgot password button clicked
	$(document.body).on('click', '#forgotPassword', function(){
		$('#studentSignUp').hide();
		$('#tutorSignUp').hide();
		$('#login').hide();
		$('#forgotPasswordForm').show();
		$('#forgotPassword').hide();
		$('#showLogin').show();
		$('#showTutor').show();
		$('#showStudent').show();
	})
	
	// form validation for student sign up
	$(document.body).on('click', '#studentSignUpSubmit', function(){
		if ($('#studentFirstName').val().length > 0 && $('#studentLastName').val().length > 0 && $('#studentEmail').val().length > 0) {
			if ($('#studentPassword1').val() == $('#studentPassword2').val()) {
				var temp = $('#studentPassword1').val();
				var hash = md5(temp);
				var word = hash.toString();
				$('#studentPassword1').val(word);
				$('#studentSignUp').submit();
			}
			else {
				$('#student-passwords-dont-match').append("Passwords do not match.");
				$('#studentPassword1').val("");
				$('#studentPassword1').val("");
			}
		}
	})
	
	// form validation for tutor sign up
	$(document.body).on('click', '#tutorSignUpSubmit', function(){
		if($('#tutorFirstName').val().length > 0 && $('#tutorLastName').val().length > 0 && $('#tutorEmail').val().length > 0 && $('#tutorRate').val().length > 0) {
			if ($('#tutorPassword1').val() == $('#tutorPassword2').val()) {
				var hash = md5($('#tutorPassword1').val());
				var word = hash.toString();
				$('#tutorPassword1').val(word);
				$('#tutorSignUp').submit();
			}
			else {
				$('#tutor-passwords-dont-match').append("Passwords do not match.");
				$('#tutorPassword1').val("");
				$('#tutorPassword1').val("");
			}
		}
	})
	
	$(document.body).on('click', '#loginSubmit', function(){
		var hash = md5($('#loginPassword').val())
		$('#loginPassword').val(hash.toString());
		$('#loginSubmit').submit();
	})
})