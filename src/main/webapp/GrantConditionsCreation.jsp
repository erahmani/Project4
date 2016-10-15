<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>

    <jsp:useBean class="dataAccess.entity.LoanType" scope="session" id="loanType"/>
    <jsp:setProperty name="loanType" property="*"/>

    <title>ایجاد شرایط اعطا</title>

    <script>

        function addGrantCondition() {
           // if (document.getElementById("submit").disabled == true) {
                document.getElementById('grantConditionForm').disabled == false;
        //    }

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
            return element;
        }
    </script>
</head>
<body>

Grant Name:
<br><input type="text" id="name"><br>

Contract Minimum Duration:
<br><input type="number" id="minDuration"><br>

Contract Maximum Duration:
<br><input type="number" id="maxDuration"><br>

Contract Minimum Cost:
<br><input type="number" id="minCost"><br>

Contract Maximum Cost:
<br><input type="number" id="maxCost"><br>

<input type="button" value="تعریف" onclick="return addGrantCondition()">

<form id="grantConditionForm" action="CreateGrantConditionServlet">
    <table id="grantConditionsTable">
        <tr>
            <th>نام</th>
            <th>حداقل مدت قرارداد</th>
            <th>حداکثر مدت قرارداد</th>
            <th>حداقل مبلغ قرارداد</th>
            <th>حداکثر مبلغ قرارداد</th>
        </tr>
    </table>
    <input type="submit" id="submit" value="ثبت" disabled="true">
</form>
</body>
</html>