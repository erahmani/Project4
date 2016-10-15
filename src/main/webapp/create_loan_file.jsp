<%@ page import="dataAccess.entity.LoanType" %>
<%@ page import="java.util.List" %>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>تشکیل پرونده تسهیلاتی</title>
    <script>
        function showCustomerInfo() {
            var request;
            if (window.XMLHttpRequest) {
                request = new XMLHttpRequest();
            } else {
                request = new ActiveXObject("Microsoft.XMLHTTP");
            }
            //request.setAttribute("customerId","10");
            // request.setParameter("customerId", 10);
            request.onreadystatechange = function () {
                if ((request.readyState == 4) && (request.status == 200)) {
                    var customerInfo = JSON.parse(request.response);
                    document.getElementById("firstName").value = customerInfo.firstName;
                    document.getElementById("lastName").value = customerInfo.lastName;
                    document.getElementsByTagName("customerId").value = document.getElementById("customerId").value;
                }
            }
            request.open("GET", "/CustomerRetrieveServlet?customerId=" + document.getElementById("customerId").value, true);
            request.send();
        }
    </script>
    <script>
        var loanTypeList = document.getElementById("loanTypeList");
        var option = document.createElement("option");
        <%  List<LoanType> loanTypeList = (List<LoanType>) request.getAttribute("loanTypeList");
            for (LoanType loanType: loanTypeList) {%>
                option.text = <%=loanType.getName()%>;
                loanTypeList.add(option);
            <%}%>
    </script>

</head>
<body>
شماره مشتری:<br><input type="number" id="customerId" required><br>
نام:<br><input type="text" id="firstName" readonly><br>
نام خانوادگی:<br><input type="text" id="lastName" readonly><br>
<div class="home-button">
    <button onclick="showCustomerInfo()">بازیابی</button>
</div>

<div>
    <form>
        شماره مشتری:<br><input type="number" name="customerId"><br>
        مدت قرارداد:<br><input type="number" name="duration"><br>
        مبلغ قرارداد:<br><input type="number" name="cost"><br>
        <select name="loanTypeList" id="loanTypeList">

        </select>
        <input type="submit" name="submit" value="ثبت">
    </form>
</div>

</body>
</html>
