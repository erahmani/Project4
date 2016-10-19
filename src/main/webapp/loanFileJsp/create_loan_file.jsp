<%@ page import="dataAccess.entity.LoanType" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>تشکیل پرونده ی تسهیلاتی</title>
    <link rel="stylesheet" type="text/css" href="/css/form-style.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-style.css">
    <link rel="stylesheet" type="text/css" href="/css/loan-style.css">
    <script>
        function showCustomerInfo() {
            var request;
            if (window.XMLHttpRequest) {
                request = new XMLHttpRequest();
            } else {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            }
            request.onreadystatechange = function () {
                if ((request.readyState == 4) && (request.status == 200)) {
                    var info = JSON.parse(request.response);
                    if (info.address != null) {
                        window.location = info.address;
                    } else {
                        document.getElementById("firstName").value = info.firstName;
                        document.getElementById("lastName").value = info.lastName;
                        document.getElementById("customerId_hidden").value = document.getElementById("customerId").value;
                    }
                }
            }

            request.open("Post", "/CustomerRetrieveServlet?customerId=" + document.getElementById("customerId").value, true);
            request.send();
        }
    </script>
    <script>
        function setSelectOptions() {
            <%
             if (request.getAttribute("loanTypeList") != null) {
            List<LoanType> loanTypeList = (List<LoanType>) request.getAttribute("loanTypeList");
           for (LoanType loanType: loanTypeList) {%>
            var loanTypeList = document.getElementById("loanTypeList");
            var opt = document.createElement("option");
            opt.value =<%="\""+loanType.getId()+"\""%>;
            opt.innerHTML = <%="\""+loanType.getName()+"\""%>;
            loanTypeList.appendChild(opt);
            <%}}%>
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
    <div class="loanBlock">

        <div class="field">
            <div class="fieldLabel">
                <label> شماره مشتری:</label>
            </div>
            <div class="fieldInput">
                <input type="number" id="customerId" required>
            </div>
        </div>

        <div class="field">
            <div class="fieldLabel">
                <label> نام:</label>
            </div>
            <div class="fieldInput">
                <input type="text" id="firstName" readonly>
            </div>
        </div>

        <div class="field">
            <div class="fieldLabel">
                <label> نام خانوادگی:</label>
            </div>
            <div class="fieldInput">
                <input type="text" id="lastName" readonly>
            </div>
        </div>
        <center>
            <div class="formButton">
                <input class="button" onclick="showCustomerInfo()" type="submit" value="بازیابی">
            </div>
        </center>


        <form action="/LoanFileCreationServlet" Method="Post">
            <div class="field">
                <div class="fieldLabel">
                    <label> شماره مشتری:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" id="customerId_hidden" name="customerId">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label> مدت قرارداد:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" name="duration">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label> مبلغ قرارداد:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" name="cost">
                </div>
            </div>
            <div class="field">
                <div class="fieldLabel">
                    <label> نوع تسهیلات:</label>
                </div>
                <div class="fieldInput">
                    <select name="loanTypeList" id="loanTypeList">
                    </select>
                </div>
            </div>
            <center>
                <div class="button">
                    <div class="formButton">
                        <input class="button" type="submit" value="ثبت">
                    </div>
                    <div class="formButton">
                        <input class="button" type="reset" value="بازنشانی">
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