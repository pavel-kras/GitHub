package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Work;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddWorkCommand implements Command {

    private static final String PARAM_TITLE = "title";
    private static final String PARAM_TIME = "time";
    private static final String PARAM_PRICE = "price";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Work work = new Work();
        work.setTitle(request.getParameter(PARAM_TITLE));
        work.setTime(Integer.parseInt(request.getParameter(PARAM_TIME)));
        work.setPrice(Integer.parseInt(request.getParameter(PARAM_PRICE)));
        WorkService.addWork(work);

        List<Work> list = WorkService.getWorkList();
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.work");
        return page;
    }

}
