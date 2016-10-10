<!DOCTYPE html>

<html lang="fa" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Loan Type Creation</title>
</head>
<body>

<form action="GrantCondition.jsp">
    Loan Name:
    <input name="name" type="String">
    <br>
    Interest Rate:
    <input name="interestRate" type="number" max="100">
    <br>
    <input type="submit" value="Next">
</form>
</body>
</html>