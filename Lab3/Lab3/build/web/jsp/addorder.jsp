<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
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
    <center><form class="form-style"><font size="4" color="#ffffff" face="TrixiePro"><h1>Список работников</h1></font></form></center>
    <div class="progress progress-striped active">
        <div class="bar" style="width: 50%;"></div>
    </div>
    <center>
        <table class="table table-hover">
            <c:forEach var="elem" items="${list_worker}" varStatus="status">
                <tr>
                    <td align="center"><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${status.count}"></c:out></font></td>
                    <td align="center"><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.name}"></c:out></font></td>
                    <td align="center"><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.surname}"></c:out></font></td>
                    <td align="center"><font size="4" color="#ff0000" face="TrixiePro"><c:out value="${elem.tel}"></c:out></font></td>
                        <td align="center">
                            <form name="update" method="post" action="servlet">
                                <input type="hidden" name="command" value="gotonextstepaddorder" /> <input 
                                    type="hidden" name="idworker" value="${elem.idWorker}"/>
                            <button class="btn btn-warning" type="submit">Выбрать</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </center>
</body>
</html>
