<%@ page import="dataAccess.entity.Customer" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <title>نتایج جستجو</title>
    <link rel="stylesheet" type="text/css" href="/css/search-style.css">
    <link rel="stylesheet" type="text/css" href="/css/menu-style.css">
</head>

<body dir="auto">
<div class="block">
    <div class="bar">
        <div class="menuPosition">
            <ul class="makeMenu">
                <li><a href="/main.jsp"> خانه </a></li>
            </ul>
        </div>
        <div class="menuPosition">
            <ul class="makeMenu">
                <li> مشتری
                    <ul>
                        <li><a href="/customerJsp/search_customer.jsp">جستجوی مشتری</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="searchBlock">
        <center>
            <table>

                <caption>نتایج جستجو برای: <%=request.getAttribute("searchOption")%>
                </caption>
                <tr>
                    <th> شماره مشتری</th>
                    <th> نام</th>
                    <th> نام خانوادگی</th>
                    <th> نام پدر</th>
                    <th> تاریخ تولد</th>
                    <th> شماره ملی</th>
                </tr>
                <% if (request.getAttribute("customerList") != null) {%>

                <% for (Customer customer : (List<Customer>) request.getAttribute("customerList")) { %>
                <tr>
                    <form action="/CustomerChangeServlet" method="Get">
                        <td><input type="text" name="customerId" class="tableCol" value="<%=customer.getCustomerId()%>" readonly></td>
                        <td><input type="text" name="firstName" class="tableCol" value="<%=customer.getFirstName()%>" readonly></td>
                        <td><input type="text" name="lastName" class="tableCol" value="<%=customer.getLastName()%>" readonly></td>
                        <td><input type="text" name="fatherName" class="tableCol" value="<%=customer.getFatherName()%>" readonly></td>
                        <td><input type="text" name="birthDay" class="tableCol" value="<%=customer.getBirthDay()%>" readonly></td>
                        <td><input type="text" name="nationalId" class="tableCol" value="<%=customer.getNationalId()%>" readonly></td>
                        <td><input type="submit" name="Edit" value="ویرایش"></td>
                        <td><input type="submit" name="Delete" value="حذف"></td>
                    </form>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </center>
    </div>
</div>
</body>

</html>