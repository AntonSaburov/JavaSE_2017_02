<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, edu.javacourse.third.domain.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Date</th>
                    <th>Husband SurName</th>
                    <th>URL</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sOrder" items="${ORDER_LIST}">
                    <c:url var="orderUrl" value="GoTo">
                        <c:param name="orderId" value="${sOrder.studentOrderId}"/>
                        <c:param name="orderDate" value="${sOrder.studentOrderDate}"/>
                    </c:url>
                    <tr>
                        <td>${sOrder.studentOrderId}</td>
                        <td>${sOrder.studentOrderDate}</td>
                        <td>${sOrder.husband.surName}</td>
                        <td><a href="${orderUrl}">URL</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
