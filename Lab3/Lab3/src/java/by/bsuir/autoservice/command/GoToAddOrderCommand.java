package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Work;
import by.bsuir.autoservice.domain.Worker;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkService;
import by.bsuir.autoservice.service.WorkerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToAddOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Worker> list_worker = WorkerService.getWorkerList();
        request.setAttribute("list_worker", list_worker);
        List<Work> list_work = WorkService.getWorkList();
        request.setAttribute("list_work", list_work);
        String page = PropertiesManager.getProperty("paths", "page.addorder");
        return page;
    }
    
}
