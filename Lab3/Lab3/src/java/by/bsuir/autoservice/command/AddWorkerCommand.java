package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Worker;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddWorkerCommand implements Command {
    
    private static final String PARAM_NAME = "name";
    private static final String PARAM_SURNAME = "surname";
    private static final String PARAM_TEL = "tel";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Worker worker = new Worker();
        worker.setName(request.getParameter(PARAM_NAME));
        worker.setSurname(request.getParameter(PARAM_SURNAME));
        worker.setTel(request.getParameter(PARAM_TEL));
        WorkerService.addWorker(worker);

        List<Worker> list = WorkerService.getWorkerList();
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.worker");
        return page;
    }
    
}
