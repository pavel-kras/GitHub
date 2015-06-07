package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Worker;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkerService;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToUpdateWorkerCommand implements Command {

    private static final String PARAM_ID_WORKER = "idworker";
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Worker list_worker = WorkerService.getWorkerListUpdate(parseInt(request.getParameter(PARAM_ID_WORKER)));
        request.setAttribute("idworker", request.getParameter(PARAM_ID_WORKER));
        request.setAttribute("list_worker", list_worker);
        String page = PropertiesManager.getProperty("paths", "page.updateworker");
        return page;
    }
    
}
