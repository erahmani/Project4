<%--
  Created by IntelliJ IDEA.
  User: dotinschool1
  Date: 10/4/2016
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fa" >
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
<%@ page import="java.util.Collection,
                 java.util.ArrayList,
                 dataAccess.entity.GrantCondition"%>
<jsp:useBean class="dataAccess.entity.LoanType" scope="session" id="loanType"/>
<jsp:useBean id="grantCondition" type="java.util.ArrayList<dataAccess.entity.GrantCondition>" scope="session"/>
<jsp:setProperty name="grantCondition" property="*"/>
<a href="SearchGrantConditionServlet" >next</a>
</body>
</html>