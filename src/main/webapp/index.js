jQuery(document).ready(function($) {
	var divProd = "d";
	$.ajax({
		type : 'GET',
		url : '/rest/productlist'
	}).done(function(data, textStatus, jqXHR) {
		var csrfToken = jqXHR.getResponseHeader('X-CSRF-TOKEN');
		if (csrfToken) {
			var cookie = JSON.parse($.cookie('homecookie'));
			cookie.csrf = csrfToken;
			$.cookie('homecookie', JSON.stringify(cookie));
		}
		if(data != undefined){
			$.divProd = "";
			 
				
				$.each(data, function(idx, obj) {
					 
				
				$.divProd += "<div style='border:1px solid;line-height: 27px; margin-left: 40px;margin-top: 16px; padding: 7px 10px 10px;' " +
						"id='"+obj.itemid + "'>  description :" + obj.description
						+"</br>category :" + obj.category +
						"</br>price : Rs " + obj.price +
						 " (included service tax : Rs " + obj.servicetaxprice + " in Percent " + obj.sTaxinPercent+ " %)  </div>";
				});
			$('#productlist').html($.divProd );
		}
	}).fail(function(jqXHR, textStatus, errorThrown) {
		if (jqXHR.status === 401) {
			// HTTP Status 401: Unauthorized
			var cookie = JSON.stringify({
				method : 'GET',
				url : '/',
				csrf : jqXHR.getResponseHeader('X-CSRF-TOKEN')
			});
			$.cookie('homecookie', cookie);
			window.location = '/login.html';
		} else {
			console.error('we have a problem...');
		}
	});

	$('#postButton').on('click', function(event) {
		event.preventDefault();
		var cookie = JSON.parse($.cookie('homecookie'));
		$.ajax({
			data : {},
			headers : {
				'X-CSRF-TOKEN' : cookie.csrf
			},
			timeout : 1000,
			type : 'POST',
			url : '/rest/hellopost'
		}).done(function(data, textStatus, jqXHR) {
			$('#Message').html(data.message);
			console.info("POST succeeded!!!");
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.error('Problems when posting...');
		});
	});

	$('#logoutButton').on('click', function(event) {
		event.preventDefault();
		var cookie = JSON.parse($.cookie('homecookie'));
		$.ajax({
			data : {},
			headers : {
				'X-CSRF-TOKEN' : cookie.csrf
			},
			timeout : 1000,
			type : 'POST',
			url : '/logout'
		}).done(function(data, textStatus, jqXHR) {
			console.info('congratulations, you have logged out!');
			window.location = '/';
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.error('Help! I cannot get out of here!');
		});
	});
});
