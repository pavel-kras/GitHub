package by.bsuir.autoservice.command;

import by.bsuir.autoservice.manager.PropertiesManager;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToMainCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = PropertiesManager.getProperty("paths", "page.main");
        return page;
    }
    
}
