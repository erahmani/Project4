<!DOCTYPE html>
<html lang="fa">
<head>

    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page import="dataAccess.entity.GrantCondition,java.util.ArrayList" %>
    <title>ایجاد شرایط اعطا</title>

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
            //document.getElementById("record").disabled = false;
            //  showFields();
            addGrantConditionsList();
            addRow("grantConditionsTable");
            return false;
        }

        function addGrantConditionsList(name) {
            <%
            GrantCondition grantCondition = new GrantCondition();
            grantCondition.setName(request.getParameter("name"));
            grantCondition.setMinDuration(request.getParameter("minDuration"));
            grantCondition.setMaxDuration(request.getParameter("maxDuration"));
            grantCondition.setMinCost(request.getParameter("minCost"));
            grantCondition.setMaxCost(request.getParameter("maxCost"));
          //  grantConditionList.add(grantCondition);
            System.out.println("in jsp");
            System.out.println(grantCondition);
         //   session.setAttribute("grantCondition",grantConditionList);
            %>
        }

        function getInput(value, name, type, readOnly) {
            var element = document.createElement("input");
            element.value = value;
            element.name = name;
            element.type = type;
            element.readOnly = readOnly;
            return element;
        }
        function addRow(tableID) {
            var table = document.getElementById(tableID);

            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);

            var cell = row.insertCell(0);
            var form = document.createElement("form");
            form.action = "GrantCondition2.jsp";

            var name = getInput(document.getElementById("name").value, "name", "text", "true");
            form.appendChild(name);
            var minDuration = getInput(document.getElementById("minDuration").value, "minDuration", "number", "true");
            form.appendChild(minDuration);
            var maxDuration = getInput(document.getElementById("maxDuration").value, "maxDuration", "number", "true");
            form.appendChild(maxDuration);
            var minCost = getInput(document.getElementById("minCost").value, "minCost", "number", "true");
            form.appendChild(minCost);
            var maxCost = getInput(document.getElementById("maxCost").value, "maxCost", "number", "true");
            form.appendChild(maxCost);

            var submit = document.createElement("input");
            submit.value = "ثبت";
            submit.id = "record";
            submit.type = "submit";
            // submit.disabled = true;
            form.appendChild(submit);

            cell.appendChild(form);

        }

    </script>
</head>
<body>
<jsp:useBean class="dataAccess.entity.LoanType" scope="session" id="loanType"/>
<jsp:setProperty name="loanType" property="*"/>

<%--<jsp:useBean id="loanTypeList" type="java.util.List<dataAccess.entity.LoanType>"
             scope="session"></jsp:useBean>--%>

Grant Name:
<br>
<input type="String" name="name" id="name">
<br>

Contract Minimum Duration:
<br>
<input type="number" name="minDuration" id="minDuration">
<br>

Contract Maximum Duration:
<br>
<input type="number" name="maxDuration" id="maxDuration">
<br>

Contract Minimum Cost:
<br>
<input type="number" name="minCost" id="minCost">
<br>

Contract Maximum Cost:
<br>
<input type="number" name="maxCost" id="maxCost">
<br>

<input type="button" value="تعریف" onclick="return enableRecord()">

<div id="Show_update">
    gsdghsfghsfghdfgh
</div>

<table id="grantConditionsTable">
    <tr>
        <td>fghdfgh</td>
    </tr>
</table>

</body>
</html>