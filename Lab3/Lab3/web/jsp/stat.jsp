<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        body {
            background: #eedfcc url(pics/4444.jpg) no-repeat center top;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            background-size: cover;
        }
    </style>
    <body>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap1.css" />
        <div class="navbar navbar-inverse">
            <nav class="navbar-inner navbar-static-top">
                <a class="brand">Курсовая работа</a>
                <ul class="nav">
                    <li class="divider-vertical"></li>
                    <li><a href="?command=gotomain">Главная</a></li>
                    <li><a href="?command=gotoworker">Работники</a></li>
                    <li><a href="?command=gotowork">Заказы</a></li>
                    <li><a href="?command=gotoorder">Выполнение</a></li>
                    <li class="divider-vertical"></li>
                    <li><a href="?command=logout">Выйти</a></li>
                </ul>
            </nav>
        </div>
    <center><font size="4" color="#ffffff" face="TrixiePro"><h1>Сумма выполненных работ - ${sum} руб.</h1></font></center>>
    <center>
        <table  class="table table-hover" >
            <c:forEach var="elem" items="${list}" varStatus="status">
                <tr>
                    <td><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${status.count}"></c:out></font></td>
                    <td><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.name}"></c:out></font></td>
                    <td><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.surname}"></c:out></font></td>
                    <td><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.title}"></c:out></font></td>
                    <td><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.time}"></c:out></font></td>
                    <td><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.price}"></c:out></font></td>
                    </tr>
            </c:forEach>
        </table>
    </center>
    <center><font size="4" color="#ffffff" face="TrixiePro"><h1>Время затраченное на выполнение всех работ - ${time} часов</h1></font></center>>
</body>
</html>
