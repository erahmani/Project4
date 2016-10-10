<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>ویرایش مشتری</title>
    <link rel="stylesheet" type="text/css" href="style.css">

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
                if (check % 11 == (nationalId).substr((nationalId).length - 1, 1) || check % 11 == 11 - (nationalId).substr((nationalId).length - 1, 1)) {
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
<body bgcolor="#20b2aa">
<%
    Object errorMessage = request.getAttribute("errorMessage");
    if (errorMessage != null) { %>

<p><font color="red"><h2><%=errorMessage.toString()%>
</h2></font></p>

<%
    }
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

<div class="relative">
    <center>
        <br>
        <form name="registrationForm" action="CustomerEditionServlet" onsubmit="return validateForm()"
              method="POST">
            شماره مشتری:<br>
            <input type="text" name="customerId" value="<%=customerId%>" required><br>
            نام:<br>
            <input type="text" name="firstName" value="<%=firstName%>" required><br>
            نام خانوادگی:<br>
            <input type="text" name="lastName" value="<%=lastName%>" required><br>
            نام پدر:<br>
            <input type="text" name="fatherName" value="<%=fatherName%>" required><br>
            تاریخ تولد:<br>
            <input type="date" name="birthDay" value="<%=birthDay%>" required/><br>
            کد ملی:<br>
            <input type="number" name="nationalId" value="<%=nationalId%>" required><br><br>
            <input type="submit" value="ثبت">
            <input type="reset" value="بازنشانی">
        </form>
    </center>
</div>
<div class="home-button">
    <a href="Main.jsp">
        <button>خانه</button>
    </a>
</div>

</body>
</html>