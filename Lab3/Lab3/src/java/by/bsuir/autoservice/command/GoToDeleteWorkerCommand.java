package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Worker;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToDeleteWorkerCommand implements Command{
    
    private static final String PARAM_ID_WORKER = "idworker";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Worker worker = new Worker();
        worker.setIdWorker(Integer.parseInt(request.getParameter(PARAM_ID_WORKER)));
        WorkerService.deleteWorker(worker);

        List<Worker> list = WorkerService.getWorkerList();
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.worker");
        return page;
    }
}
