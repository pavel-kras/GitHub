/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.kras.lab2;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Asus
 */
public class servlet extends HttpServlet{
    public void Method(HttpServletRequest request, HttpServletResponse response)
    {
        String name = request.getParameter("Name");
        request.setAttribute("login", name);
        String brouser=request.getParameter("browser");
        request.setAttribute("browser",brouser);
        String comment=request.getParameter("comment");
        request.setAttribute("comment",comment);
        String path=request.getContextPath();
        request.setAttribute("contextpath",path);
        request.setAttribute("cook",request.getCookies());
        request.setAttribute("authType", request.getAuthType());
        request.setAttribute("headerNames",request.getHeaderNames());
        request.setAttribute("getMethod",request.getMethod());
        request.setAttribute("pathInfo",request.getPathInfo());
        request.setAttribute("PathTranslated",request.getPathTranslated());
        request.setAttribute("QueryString",request.getQueryString());
        request.setAttribute("RemoteUser",request.getRemoteUser());
        request.setAttribute("RequestedSessionId",request.getRequestedSessionId());
        request.setAttribute("RequestURI",request.getRequestURI());
        request.setAttribute("ServletPath",request.getServletPath());
        request.setAttribute("Session",request.getSession().toString());
        forward("out.jsp", request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Method(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Method(request,response);


    }

    public void forward(String to, HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(to);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
