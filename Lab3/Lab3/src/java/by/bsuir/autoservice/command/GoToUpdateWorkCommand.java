package by.bsuir.autoservice.command;

import by.bsuir.autoservice.manager.PropertiesManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToUpdateWorkCommand implements Command {
    
    private static final String PARAM_ID_WORK = "idwork";
    private static final String PARAM_TITLE = "title";
    private static final String PARAM_TIME = "time";
    private static final String PARAM_PRICE = "price";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("idwork", request.getParameter(PARAM_ID_WORK));
        request.setAttribute("title", request.getParameter(PARAM_TITLE));
        request.setAttribute("time", request.getParameter(PARAM_TIME));
        request.setAttribute("price", request.getParameter(PARAM_PRICE));
        String page = PropertiesManager.getProperty("paths", "page.updatework");
        return page;
    }
    
}
