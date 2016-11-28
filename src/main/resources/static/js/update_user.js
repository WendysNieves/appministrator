$(document).ready(function() {

	var updateForm = '#update-form';
	
	$(updateForm).submit(function(event) {
		event.preventDefault();
		if ($(updateForm).isValid()) {
			save();
		}
		event.stopImmediatePropagation();
	});
	
	$("#delete-submit").click(function() {
		$.ajax({			
			type : 'DELETE',
			cache : false,			
			success: function(response) {
				window.location.href = "/";
			}
		});
	});
	
	function save() {	
		$.ajax({			
			type : 'PUT',
			cache : false,
			data : $(updateForm).serialize(),
			success: function(response) {
				window.location.href = "/";
			}
		});
	}
});