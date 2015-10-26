$(function(){
	
	$(document.body).on('click', '#passwordResetSubmit', function(){
		if ($('#studentPassword1').val() == $('#studentPassword2').val()) {
			var temp = $('#studentPassword1').val();
			var hash = md5(temp);
			var word = hash.toString();
			$('#studentPassword1').val(word);
			$('#passwordReset').submit();
		}
		else {
			$('#student-passwords-dont-match').append("Passwords do not match.");
			$('#studentPassword1').val("");
			$('#studentPassword1').val("");
		}
	})
})