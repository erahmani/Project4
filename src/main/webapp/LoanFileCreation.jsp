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
            document.getElementById("test").innerHTML
                    =  document.getElementById("customerId").value;
            request.setAttribute("customerId", document.getElementById("customerId").value)
            request.onreadystatechange = function () {
                document.getElementById("test").innerHTML
                        = request.responseText;
                if ((request.readyState == 4) && (request.status == 200)) {
                    document.getElementById("firstName").innerHTML
                            = request.response.getAttribute("firstName");
                    document.getElementById("lastName").innerHTML
                            = request.response.getAttribute("lastName");

                    document.getElementById("test").innerHTML
                            = "333333333333333";
                }
            }
            request.open("GET", "/CustomerRetrieveServlet", true);
            request.send();
        }
    </script>
</head>
<body>
شماره مشتری:<br>
<input type="number" id="customerId" required><br>
نام:<br>
<input type="text" id="firstName" readonly><br>
نام خانوادگی:<br>
<input type="text" id="lastName" readonly><br>
<div id="test">
</div>
<div class="home-button">
    <button onclick="showCustomerInfo()">بازیابی</button>
</div>
</body>
</html>
