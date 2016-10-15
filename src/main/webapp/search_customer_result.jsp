<%@ page import="dataAccess.entity.Customer" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>نتایج جستجو</title>

</head>
<body bgcolor="#20b2aa">
<div class="relative">
    <center>
        <table>
            <caption>Result for search option: <%=request.getAttribute("searchOption")%>  search
                value: <%=request.getAttribute("searchValue")%>
            </caption>
            <th> شماره مشتری</th>
            <th> نام</th>
            <th> نام خانوادگی</th>
            <th> نام پدر</th>
            <th> تاریخ تولد</th>
            <th> شماره ملی</th>

            <% for (Customer customer : (ArrayList<Customer>) request.getAttribute("customerList")) { %>
            <tr>
                <form action="ChangeCustomerServlet" method="Get">
                    <td><input type="text" name="customerId" value="<%=customer.getCustomerId()%>" readonly></td>
                    <td><input type="text" name="firstName" value="<%=customer.getFirstName()%>" readonly></td>
                    <td><input type="text" name="lastName" value="<%=customer.getLastName()%>" readonly></td>
                    <td><input type="text" name="fatherName" value="<%=customer.getFatherName()%>" readonly></td>
                    <td><input type="text" name="birthDay" value="<%=customer.getBirthDay()%>" readonly></td>
                    <td><input type="text" name="nationalId" value="<%=customer.getNationalId()%>" readonly></td>
                    <input type="hidden" name="customerType" value="CustomerBusinessLogic" required> <br>
                    <td><input type="submit" name="Edit" value="Edit"></td>
                    <td><input type="submit" name="Delete" value="Delete"></td>
                </form>
            </tr>
            <%}%>
       </table>
    </center>
</div>
<div class="home-button">
    <a href="main.jsp">
        <button>خانه</button>
    </a>
</div>
<div class="home-button">
    <a href="search_customer.jsp">
        <button>قبلی</button>
    </a>
</div>
</body>
</html>