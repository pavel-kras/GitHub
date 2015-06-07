package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Worker;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToWorkerCommand implements Command {

    @Override
    public String execute(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<Worker> list = WorkerService.getWorkerList();
        request.setAttribute("list", list);
        String page = PropertiesManager.getProperty("paths", "page.worker");
        return page;
    }
}
