package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Work;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToWorkCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Work> list = WorkService.getWorkList();
        request.setAttribute("list", list);
        String page = PropertiesManager.getProperty("paths", "page.work");
        return page;
    }
    
}
