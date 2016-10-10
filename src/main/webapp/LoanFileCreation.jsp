
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>Title</title>
    <script>
        function showCustomerInfo() {
            var xRequest1;
            if (window.XMLHttpRequest) {
                xRequest1 = new XMLHttpRequest();
            } else {
                xRequest1 = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xRequest1.onreadystatechange = function () {
                if ((xRequest1.readyState == 4) && (xRequest1.status == 200)) {
                    document.getElementById("CustomerInfo").innerHTML
                            = xRequest1.response;
                }
            }
            xRequest1.open("get", "/RetrieveCustomerInfoServlet", true);
            xRequest1.send();
        }
    </script>
</head>
<body>


</body>
</html>
