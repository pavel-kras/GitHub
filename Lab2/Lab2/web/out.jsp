<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Имя:${login}</p>
        <p>Браузер:${browser}</p>
        <p>Комментарий:${comment}</p>
        <p>contextpath:${contextpath}</p>
        <p>cookie{cook}</p>
        <p>authType:${authType}</p>
        <p>headerNames:${headerNames}</p>
        <p>getMethod:${getMethod}</p>
        <p>pathInfo:${pathInfo}</p>
        <p>PathTranslated:${PathTranslated}</p>
        <p>QueryString:${QueryString}</p>
        <p>RemoteUser:${RemoteUser}</p>
        <p>RequestedSessionId:${RequestedSessionId}</p>
        <p>RequestURI:${RequestURI}</p>
        <p>ServletPath:${ServletPath}</p>
        <p>Session:${Session}</p>
    </body>
</html>
