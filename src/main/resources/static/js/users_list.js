$(document).ready(function() {
	var table = $('table#users').DataTable({  
        'ajax' : '/users',
        'serverSide' : true,
        "language": {
            "lengthMenu": "Mostrando _MENU_ registros por página",
            "zeroRecords": "No se encontraron registros",
            "info": "Mostrando página _PAGE_ de _PAGES_",
            "infoEmpty": "No hay registros disponibles",
            "infoFiltered": "(filtrado de _MAX_ registros totales)",
            "search": "Buscar:",
            "paginate": {
                "first": "Primera",
                "last": "Última",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        },
        columns : [ {
            data : 'name'
        }, {
            data : 'lastName'
        }, {
            data : 'identification'
        }, {
            data : 'email',
            "fnCreatedCell" : function(nTd, sData, oData, iRow, iCol) {
        		$(nTd).html("<a href='/user/" + oData.id + "' >" + sData + "</a>");
        	}
        },  {
            data : 'cellphone'
        }]
    });
	
	$("#generate-users").click(function() {
		$.ajax({			
			type : 'POST',
			cache : false,
			url : '/users/generate',
			data : { length : 100 },
			success: function(response) {
				table.draw();
			}
		});
	});
});