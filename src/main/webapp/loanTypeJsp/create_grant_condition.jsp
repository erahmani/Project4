<!DOCTYPE html>
<html lang="fa">
<head>
    <jsp:useBean class="dataAccess.entity.LoanType" scope="session" id="loanType"/>
    <jsp:setProperty name="loanType" property="*"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>ایجاد شرایط اعطا</title>
    <link rel="stylesheet" type="text/css" href="/css/form-style.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-style.css">
    <link rel="stylesheet" type="text/css" href="/css/loan-style.css">

    <script>

        function addGrantCondition() {
            if (document.getElementById("submit").disabled) {
                document.getElementById('submit').disabled = false;
            }

            var table = document.getElementById("grantConditionsTable");
            var row = table.insertRow(table.length);

            var cel1 = row.insertCell(0);
            cel1.appendChild(getElement(document.getElementById("name").value, "name", "text"));
            var cel2 = row.insertCell(1);
            cel2.appendChild(getElement(document.getElementById("minDuration").value, "minDuration", "number"));
            var cel3 = row.insertCell(2);
            cel3.appendChild(getElement(document.getElementById("maxDuration").value, "maxDuration", "number"));
            var cel4 = row.insertCell(3);
            cel4.appendChild(getElement(document.getElementById("minCost").value, "minCost", "number"));
            var cel5 = row.insertCell(4);
            cel5.appendChild(getElement(document.getElementById("maxCost").value, "maxCost", "number"));
        }

        function getElement(value, name, type) {
            var element = document.createElement("input");
            element.value = value;
            element.name = name;
            element.type = type;
            element.readOnly = true;
            element.className = "tableCol";
            return element;
        }

        function initLoanType() {
            document.getElementById("loanName").value = <%="\""+loanType.getName()+"\""%>;
            document.getElementById("interestRate").value =
            <%="\""+loanType.getInterestRate()+"\""%>
        }
    </script>
</head>
<body onload="initLoanType()" dir="rtl">
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
        <form action="/loanTypeJsp/create_grant_condition.jsp">
            <div class="field">
                <div class="fieldLabel">
                    <label> نام نوع تسهیلات:</label>
                </div>
                <div class="fieldInput">
                    <input type="text" id="loanName" readonly>
                </div>
            </div>
            <div class="field">
                <div class="fieldLabel">
                    <label> نرخ سود:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" id="interestRate" readonly>
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label>نام شرط اعطا:</label>
                </div>
                <div class="fieldInput">
                    <input type="text" id="name">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label>حداقل مدت قرارداد:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" id="minDuration">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label>حداکثر مدت قرارداد:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" id="maxDuration">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label>حداقل مبلغ قرارداد:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" id="minCost">
                </div>
            </div>

            <div class="field">
                <div class="fieldLabel">
                    <label>حداکثر مبلغ قرارداد:</label>
                </div>
                <div class="fieldInput">
                    <input type="number" id="maxCost">
                </div>
            </div>

            <center>
                <div class="button">
                    <div class="formButton">
                        <input type="button" value="تعریف" onclick="return addGrantCondition()">
                    </div>
                </div>
            </center>
        </form>
    </div>
    <div class="tableBlock">
        <form action="/LoanTypeCreationServlet" method="post">
            <table id="grantConditionsTable">
                <tr>
                    <th>نام</th>
                    <th>حداقل مدت قرارداد</th>
                    <th>حداکثر مدت قرارداد</th>
                    <th>حداقل مبلغ قرارداد</th>
                    <th>حداکثر مبلغ قرارداد</th>
                </tr>
            </table>
            <input type="submit" id="submit" value="ثبت">
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
</body>
</html>