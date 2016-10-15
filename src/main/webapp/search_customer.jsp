<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>جستجوی مشتری</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcolor="#20b2aa">
<div class="relative">
    <br>
    <center>
        <form action="CustomerSearchServlet" method="GET">
            <select name="searchOption">
                <option name="firstName" value="firstName">نام</option>
                <option name="lastName" value="lastName">نام خانوادگی</option>
                <option name="customerId" value="customerId">شماره مشتری</option>
                <option name="nationalId" value="nationalId">کد ملی</option>
            </select>&nbsp;
            <input type="text" name="searchValue"><br>
            <br>
            <input type="submit" value="جستجو">
        </form>
    </center>
</div>
<div class="home-button">
    <a href="main.jsp">
        <button>خانه</button>
    </a>
</div>

</body>
</html>