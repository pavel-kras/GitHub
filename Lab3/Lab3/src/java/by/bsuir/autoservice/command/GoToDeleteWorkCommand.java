package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Work;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToDeleteWorkCommand implements Command{
    
    private static final String PARAM_ID_WORK = "idwork";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Work work = new Work();
        work.setIdWork(Integer.parseInt(request.getParameter(PARAM_ID_WORK)));
        WorkService.deleteWork(work);

        List<Work> list = WorkService.getWorkList();
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.work");
        return page;
    }
    
}
