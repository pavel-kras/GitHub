package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Worker;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateWorkerCommand implements Command {

    private static final String PARAM_ID_WORKER = "idworker";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_SURNAME = "surname";
    private static final String PARAM_TEL = "tel";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Worker worker = new Worker();
        worker.setIdWorker(Integer.parseInt(request.getParameter(PARAM_ID_WORKER)));
        worker.setName(request.getParameter(PARAM_NAME));
        worker.setSurname(request.getParameter(PARAM_SURNAME));
        worker.setTel(request.getParameter(PARAM_TEL));
        WorkerService.updateWorker(worker);
        System.out.println(worker.getIdWorker());
        System.out.println(worker.getName());
        System.out.println(worker.getSurname());
        System.out.println(worker.getTel());

        List<Worker> list = WorkerService.getWorkerList();
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.worker");
        return page;
    }
}
