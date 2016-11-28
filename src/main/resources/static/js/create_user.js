$(document).ready(function() {

	var registerForm = '#register-form';
	
	$(registerForm).submit(function(event) {
		event.preventDefault();
		if ($(registerForm).isValid()) {
			save();
		}
		event.stopImmediatePropagation();
	});
	
	function save() {	
		$.ajax({			
			type : 'POST',
			cache : false,
			data : $(registerForm).serialize(),			
			success: function(response) {
				window.location.href = "/";
			}
		});
	}
});