<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Авторизация</title>
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
        <style type="text/css">
            body{padding-top:40px;padding-bottom:40px;background: url(pics/4444.jpg) no-repeat center top;}
            .form-signin{max-width:300px;padding:19px 29px 29px;margin:0 auto 20px;background-color:#fff;border:1px solid #e5e5e5;-webkit-border-radius:5px;-moz-border-radius:5px;border-radius:5px;-webkit-box-shadow:0 1px 2px rgba(0,0,0,.05);-moz-box-shadow:0 1px 2px rgba(0,0,0,.05);box-shadow:0 1px 2px rgba(0,0,0,.05);}
            .form-signin 
            .form-signin-heading,
            .form-signin 
            .checkbox{margin-bottom:10px; font-family: TrixiePro;}
            .form-signin input[type="text"],
            .form-signin input[type="password"]{font-size:16px;height:auto;margin-bottom:15px;padding:7px 9px;}
        </style>
    </head>
    <body>
        <br>
        <div class="container">
            <form class="form-signin" method="POST" action="servlet">
                <input type="hidden" name="command" value="login" />
                <center><h2 class="form-signin-heading">Авторизация</h2></center>
                <input type="text" class="input-block-level" required placeholder="Login" name="login" value="" autofocus>
                <input type="password" class="input-block-level" required placeholder="Password" name="password" value="">
                <button class="btn btn-large btn-primary" type="submit">Войти</button>
                <center><font color="red"><h1  class="form-signin-heading">${wrongdata}</h1></font></center>
            </form>
        </div>  
    </body>
</html>