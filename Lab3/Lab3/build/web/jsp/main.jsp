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

        .text{
            line-height: 1.5;
            padding: 10px; /* Поля вокруг текста */
            margin-top: 0.1%; /* Отступ сверху */
            margin-left: 20px;
            border-top-left-radius: 80px;
            border-top-right-radius: 80px;
            border-bottom-right-radius: 80px;
            border-bottom-left-radius: 80px;
        }
        
        .block{
            font-family: TrixiePro;
            font-size: 16px;
            margin-left: 20px;
        }
    </style>
    <body>
        <link rel="stylesheet" type="text/css" href="css/1111.css" />
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
        <div class="text">
            <font color="#cacaca" face="TrixiePro" size="6">
            <p class="text" align="center"><img align="right" vspace="0" hspace="50" height="500" width="500" src="pics/Jaguar-Logo-psd56494.png"/>Привет, мир!!!</p>

            <p>
                Вас приветствует курсовая работа <font color="#ff0000"><p>"Система учёта автосервиса"</p></font> студента группы <font color="#ff0000">#272301 <p>Красовского П.Р.</p></font>
        </p>
        </font>

    </div>
        <br><br><br><br><br><br><br><br><br>
    <div class="block">
        <blockquote>
            <p>
                Failure is simply the opportunity to begin again, this time more intelligently. <p>There is no disgrace in honest failure; there is disgrace in fearing to fail.</p>
            </p>
            <small>«My Life and Work» — автобиография Генри Форда</small>
        </blockquote>
    </div>
</body>
</html>
