<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>signup Page</title>
<link rel="stylesheet" href="style/signup.css">

<script type="text/javascript" language="javascript">
	function ClearForm() {
		document.getElementById("email").innerHTML = "";
		document.getElementById("password").innerHTML = "";
	}
</script>


</head>



<body onload="ClearForm()">


	<div class="signup_container">
		<form class="signup_form clearfix" id="MyForm" method="post" action="<%= response.encodeUrl(request.getContextPath() + "/pageController?action=signup") %>" >
			<div class="signup_welcome_note">Hotel Website</div>

			<p>
				<span class="signup_input_label" style="padding-right: 40px;">Name</span><input
					type="text" id="name" name="name" placeholder="Name" required><br>
				<br>
				<span class="signup_input_label" style="padding-right: 40px;">Email</span><input
					type="text" id="email" name="email" placeholder="Email" required><br>
				<br> <span class="signup_input_label"
					style="padding-right: 13px;">Password</span><input type="password"
					name="password" id="password" placeholder="Password" required>
				<br> <br><span class="signup_input_label"
					style="padding-right: 13px;">Password</span><input type="password"
					name="repeatPassword" id="repeatPassword" placeholder="Repeat Password" required>
					<br> <br><span class="signup_input_label"
					style="padding-right: 13px;">CNIC No</span><input type="text"
					name="cnic" id="repeatPassword2" placeholder="CNIC" required>
					<br> <br>			</p>

			<button type="submit" class="signup_button_div" name="submit">
				<span>Sign up</span>
			</button>
			<a href="/HotelWebsite/login.jsp">Already have an account.</a>

		</form>
	</div>


</body>
</html>