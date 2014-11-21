<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码</title>
<script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
	<p>
		<img src="Kaptcha.jpg" width="200" id="kaptchaImage" /> <br /> <small>Can't
			read the image? Click it to get a new one.</small>
</body>
</html>
<script type="text/javascript">
	$(function() {
		$('#kaptchaImage').click(
				function() {
					$(this).attr('src',
							'Kaptcha.jpg?' + Math.floor(Math.random() * 100));
				})
	});
</script>