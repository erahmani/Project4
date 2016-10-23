<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>خانه</title>
    <link rel="stylesheet" type="text/css" href="/css/form-style.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-style.css">
    <script>
        function invalidateSession() {
            <%session.invalidate();%>
        }
    </script>
</head>

<body onload="invalidateSession()" dir="rtl">
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
        <div class="menuPosition">
            <ul class="makeMenu">
                <li> تسهیلات
                    <ul>
                        <li><a href="/loanTypeJsp/create_loan_type.jsp">ایجاد نوع تسهیلات </a></li>
                        <li><a href="/LoanFilePageCreationServlet">ایجاد پرونده ی تسهیلاتی</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
</body>

</html>

