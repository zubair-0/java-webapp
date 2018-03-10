<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style/login.css">
</head>
<body>

<div class="login_container">
		 <form class="login_form clearfix" id="MyForm" method="post" action="<%= response.encodeUrl(request.getContextPath() + "/pageController?action=login") %>">
			<div class="login_welcome_note">Hotel Website</div>

			<p>
				<span class="login_input_label" style="padding-right: 40px;">Email</span><input
					type="text" id="email" name="email" placeholder="Email" required><br>
				<br> <span class="login_input_label"
					style="padding-right: 13px;">Password</span><input type="password"
					name="password" id="password" placeholder="Password" required>
			</p>

			<button type="submit" class="login_button_div" name="submit">
				<span>Login</span>
			</button>
			<a href="/HotelWebsite/signup.jsp">Create an account.</a>

		</form>
	</div>


</body>
</html>