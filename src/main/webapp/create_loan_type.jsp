<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>ایجاد نوع تسهیلات</title>
</head>
<body>
<form action="create_grant_condition.jsp">
    نام نوع تسهیلات:
    <input name="name" type="String">
    <br>
    نرخ سود:
    <input name="interestRate" type="number" max="100">
    <br>
    <input type="submit" value="Next">
</form>
</body>
</html>