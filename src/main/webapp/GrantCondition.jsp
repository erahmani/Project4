<!DOCTYPE html>
<html lang="fa">
<head>

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Grant Condition</title>

    <script>
        function showFields() {
            var xRequest1;
            if (window.XMLHttpRequest) {
                xRequest1 = new XMLHttpRequest();
            } else {
                xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xRequest1.onreadystatechange = function () {
                if ((xRequest1.readyState == 4) && (xRequest1.status == 200)) {
                    document.getElementById("Show_update").innerHTML
                            = xRequest1.responseText;
                }
            }
            xRequest1.open("Post", "/SearchGrantConditionServlet", true);
            xRequest1.send();
        }
        function enableRecord() {
            document.getElementById("record").disabled = false;
            //  showFields();
            addRow("grantConditionsTable");
            return false;
        }

        function addRow(tableID) {



            var table = document.getElementById(tableID);

            var rowCount = table.rows.length;
            document.getElementById("Show_update").innerHTML
                    = rowCount;
            var row = table.insertRow(rowCount);

            var cell1 = row.insertCell(0);
            var name = document.createElement("input");
            name.value = document.getElementById("name").nodeValue;
            cell1.appendChild(name);

            var cell2 = row.insertCell(1);
            var minDuration = document.createElement("input");
            minDuration.value = document.getElementById("minDuration").nodeValue;
            cell1.appendChild(minDuration);

            /*var cell2 = row.insertCell(1);
             cell2.innerHTML = rowCount + 1;

             var cell3 = row.insertCell(2);
             var element2 = document.createElement("input");
             element2.type = "text";
             element2.name = "txtbox[]";
             cell3.appendChild(element2);*/
        }

    </script>
</head>
<body>
<jsp:useBean class="dataAccess.entity.LoanType" scope="session" id="loanType"/>
<jsp:setProperty name="loanType" property="*"/>

<%--<jsp:useBean id="loanTypeList" type="java.util.List<dataAccess.entity.LoanType>"
             scope="session"></jsp:useBean>--%>

<form action="GrantCondition2.jsp">
    Grant Name:
    <br>
    <input type="String" name="name" Id="name">
    <br>

    Contract Minimum Duration:
    <br>
    <input type="number" name="minDuration" id="number">
    <br>

    Contract Maximum Duration:
    <br>
    <input type="number" name="maxDuration">
    <br>

    Contract Minimum Cost:
    <br>
    <input type="number" name="minCost">
    <br>

    Contract Maximum Cost:
    <br>
    <input type="number" name="maxCost">
    <br>

    <input type="button" value="تعریف" onclick="return enableRecord()">
    <input type="submit" value="ثبت" id="record" disabled>
</form>

<div id="Show_update">
    gsdghsfghsfghdfgh
</div>

<table id="grantConditionsTable">
    <tr>
        <td>fghdfgh</td>
        <td>dfgsdfg</td>
        <td>sdfgsdg</td>
        <td>asdf</td>
        <td>fasdf</td>
        <td>fasdf</td>
    </tr>
</table>

</body>
</html>