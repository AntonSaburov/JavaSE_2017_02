<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, edu.javacourse.third.domain.*"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test Page</title>
    </head>
    <body>
        <h1>Test data</h1>

        <%
           List<StudentOrder> s = (List)request.getAttribute("ORDER_LIST");

           for(StudentOrder so : s) {
              out.println(so.getStudentOrderId() + "<br/>");
           }
        %>

        <%=request.getAttribute("ORDER_LIST") %><br/>
        ${ORDER_LIST}

    </body>
</html>