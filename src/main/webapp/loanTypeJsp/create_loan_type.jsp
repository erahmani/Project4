<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>ایجاد نوع تسهیلات</title>
    <link rel="stylesheet" type="text/css" href="/css/form-style.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-style.css">
    <link rel="stylesheet" type="text/css" href="/css/loan-style.css">
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
                <li> تسهیلات
                    <ul>
                        <li><a href="/loanTypeJsp/create_loan_type.jsp">ایجاد نوع تسهیلات </a></li>
                        <li><a href="/loanFileJsp/create_loan_file.jsp">ایجاد پرونده تسهیلاتی</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="formBlock">
        <form action="/loanTypeJsp/create_grant_condition.jsp">
            <div class="field">
                <div class="fieldLabel">
                    <label> نام نوع تسهیلات:</label>
                </div>
                <div class="fieldInput">
                    <input name="name" type="text">
                </div>
            </div>
            <div class="field">
                <div class="fieldLabel">
                    <label> نرخ سود:</label>
                </div>
                <div class="fieldInput">
                    <input name="interestRate" type="number" max="100">
                </div>
            </div>
            <center>
                <div class="button">
                    <div class="formButton">
                        <input class="button" type="submit" value="بعدی">
                    </div>
                </div>
            </center>
        </form>
    </div>
</div>
<div class="errorBlock">
    <%
        Object errorMessage = request.getAttribute("errorMessage");
        if (errorMessage != null) { %>
    <pre>
        <h2><%=errorMessage.toString()%>
    </h2></pre>
    <%}%>
</div>
</body>
</html>