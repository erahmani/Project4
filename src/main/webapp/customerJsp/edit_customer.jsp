<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ویرایش مشتری</title>
    <link rel="stylesheet" type="text/css" href="/css/form-style.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-style.css">

    <script>
        function IsIRNationalCode(nationalId) {
            if ((nationalId).length != 10) {
                return false;
            }
            else {
                var check = 0;
                for (var i = 0; i < (nationalId).length - 1; i++) {
                    var num = (nationalId).substr(i, 1);
                    check += num * (10 - i)
                }
                if (check % 11 == (nationalId).substr((nationalId).length - 1, 1) ||
                        check % 11 == 11 - (nationalId).substr((nationalId).length - 1, 1)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }

        function validateForm() {
            var nationalId = document.forms["registrationForm"]["nationalId"].value;
            if (IsIRNationalCode(nationalId)) {
                return true;
            } else {
                alert("Invalid National Id!");
                return false;
            }
        }
    </script>
</head>

<body dir="rtl">
<%
    String customerId = "";
    if (request.getParameter("customerId") != null) {
        customerId = request.getParameter("customerId").toString();
    }
    String firstName = "";
    if (request.getParameter("firstName") != null) {
        firstName = request.getParameter("firstName").toString();
    }
    String lastName = "";
    if (request.getParameter("lastName") != null) {
        lastName = request.getParameter("lastName").toString();
    }
    String fatherName = "";
    if (request.getParameter("fatherName") != null) {
        fatherName = request.getParameter("fatherName").toString();
    }
    String birthDay = "";
    if (request.getParameter("birthDay") != null) {
        birthDay = request.getParameter("birthDay").toString();
    }
    String nationalId = "";
    if (request.getParameter("nationalId") != null) {
        nationalId = request.getParameter("nationalId").toString();
    }
%>
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
        <form name="registrationForm" action="/CustomerEditionServlet" method="POST">
            <div>
                <div class="field">
                    <div class="fieldLabel">
                        <label> شماره مشتری :</label>
                    </div>
                    <div class="fieldInput">
                        <input type="number" name="customerId" value="<%=customerId%>" readonly>
                    </div>
                </div>

                <div class="field">
                    <div class="fieldLabel">
                        <label> نام :</label>
                    </div>
                    <div class="fieldInput">
                        <input type="text" name="firstName" value="<%=firstName%>" required>
                    </div>
                </div>

                <div class="field">
                    <div class="fieldLabel">
                        <label> نام خانوادگی:</label>
                    </div>
                    <div class="fieldInput">
                        <input type="text" name="lastName" value="<%=lastName%>" required>
                    </div>
                </div>

                <div class="field">
                    <div class="fieldLabel">
                        <label>نام پدر:</label>
                    </div>
                    <div class="fieldInput">
                        <input type="text" name="fatherName" value="<%=fatherName%>" required>
                    </div>
                </div>

                <div class="field">
                    <div class="fieldLabel">
                        <label>تاریخ تولد:</label>
                    </div>
                    <div class="fieldInput">
                        <input type="date" name="birthDay" value="<%=birthDay%>" required>
                    </div>
                </div>

                <div class="field">
                    <div class="fieldLabel">
                        <label>کد ملی:</label>
                    </div>
                    <div class="fieldInput">
                        <input type="number" name="nationalId" value="<%=nationalId%>" required>
                    </div>
                </div>
            </div>
            <div class="button">
                <div class="formButton">
                    <input class="button" type="submit" value="ثبت">
                </div>
                <div class="formButton">
                    <input class="button" type="reset" value="بازنشانی">
                </div>
            </div>
        </form>
    </div>
</div>
<div class="errorBlock">
    <%
        Object
                errorMessage
                =
                request
                        .
                                getAttribute
                                        (
                                                "errorMessage"
                                        );
        if
                (
                errorMessage
                        !=
                        null
                ) { %>
    <pre>
        <h2><%=errorMessage
                .
                        toString
                                (
                                )%>
    </h2></pre>
    <%}%>
</div>
</body>
</html>