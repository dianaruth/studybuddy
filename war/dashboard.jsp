<%
Cookie[] cookies = request.getCookies();

if (cookies.length == 0) {
	response.sendRedirect("/dashboard.jsp");
}

String email = null;

for(Cookie cookie : cookies){
    if("email".equals(cookie.getName())){
        email = cookie.getValue();
    }
}
%>

<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<b>Dashboard. This is where all of the awesome stuff happens... Whenever we get around to building the awesome stuff.</b>
</body>
</html>