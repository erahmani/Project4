<!DOCTYPE html>
<html lang="fa" >
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>جستجوی مشتری</title>
    <style>
        html, body {
            height: 100%;
        }

        .dropdown-content text {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content text:hover {
            background-color: #f1f1f1
        }

        div.relative {
            position: relative;
            top: 25%;
            left: 35%;
            width: 30%;
            height: 50%;
            border: solid lightslategrey;
            background-color: whitesmoke
        }

        div.home-button {
            position: relative;
            top: 30%;
            left: 48%;
        }
    </style>
</head>
<body bgcolor="#20b2aa">
<div class="relative">
    <br>
    <center>
        <form action="SearchRealCustomerServlet" method="GET">
            <select name="searchOption">
                <option name="firstName" value="firstName">نام</option>
                <option name="lastName" value="lastName">نام خانوادگی</option>
                <option name="fatherName" value="fatherName">نام پدر</option>
                <option name="birthDay" value="birthDay">تاریخ تولد</option>
                <option name="nationalId" value="nationalId">کد ملی</option>
            </select>&nbsp;
            <input type="text" name="searchValue"><br>
            <br>
            <input type="submit" value="Search">
        </form>
    </center>
</div>
<div class="home-button">
    <a href="Main.jsp">
        <button>خانه</button>
    </a>
</div>

<div class="home-button">
    <a href="SearchCustomer.jsp">
        <button>قبلی</button>
    </a>
</div>
</body>
</html>