package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Worker;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.LoginService;
import by.bsuir.autoservice.service.WorkerService;

public class LoginCommand implements Command {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if ("root".equals(LoginService.checkLogin(login, password))) {
            List<Worker> list = WorkerService.getWorkerList();
            request.setAttribute("list", list);
            page = PropertiesManager.getProperty("paths", "page.main");
        } else {
            request.setAttribute("wrongdata", "Введены неверные данные");
            page = PropertiesManager.getProperty("paths", "page.login");
        }
        return page;
    }
}
