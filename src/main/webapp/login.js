jQuery(document).ready(function ($) {
	$('#loginform').submit(function (event) {
		event.preventDefault();
		var cookie = JSON.parse($.cookie('homecookie'));
		var data = 'username=' + $('#username').val() + '&password=' + $('#password').val();
		$.ajax({
			data: data,
			headers: {'X-CSRF-TOKEN': cookie.csrf},
			timeout: 1000,
			type: 'POST',
			url: '/login'
		}).done(function(data, textStatus, jqXHR) {
			window.location = cookie.url;
		}).fail(function(jqXHR, textStatus, errorThrown) {
			console.error('Wrong credentials, try again!');
		});
	});
});
