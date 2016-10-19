<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>جستجوی مشتری</title>
    <link rel="stylesheet" type="text/css" href="/css/form-style.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-style.css">
</head>
<body dir="auto">
<div class="block">
    <div class="bar">
        <div class="menuPosition">
            <ul class="makeMenu">
                <li><a href="/main.jsp"> خانه </a></li>
            </ul>
        </div>
        <div class="menuPosition">
            <ul class="makeMenu">
                <li> مشتری
                    <ul>
                        <li><a href="/customerJsp/register_customer.jsp">ثبت نام مشتری </a></li>
                        <li><a href="/customerJsp/search_customer.jsp">جستجوی مشتری</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="formBlock">
        <form action="/CustomerSearchServlet" method="GET">
            <div class="field">
                <div class="fieldLabel">
                    <label> نام :</label>
                </div>
                <div class="fieldInput">
                    <input type="text" name="firstName">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label> نام خانوادگی :</label>
                </div>
                <div class="fieldInput">
                    <input type="text" name="lastName">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label> شماره مشتری :</label>
                </div>
                <div class="fieldInput">
                    <input type="text" name="customerId">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label>کد ملی :</label>
                </div>
                <div class="fieldInput">
                    <input type="text" name="nationalId">
                </div>
            </div>

            <div class="button">
                <div class="formButton">
                    <input class="button" type="submit" value="جستجو">
                </div>
                <div class="formButton">
                    <input class="button" type="reset" value="بازنشانی">
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>

