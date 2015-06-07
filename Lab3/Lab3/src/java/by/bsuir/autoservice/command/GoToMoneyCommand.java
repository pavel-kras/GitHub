package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Order;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.WorkerService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToMoneyCommand implements Command {

    private static final String PARAM_ID_WORKER = "idworker";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Order order = new Order();
        order.setIdWorker(Integer.parseInt(request.getParameter(PARAM_ID_WORKER)));
        List<Order> list = WorkerService.getStatWorkerList(order);
        int sum = WorkerService.getSumWorker(list);
        int time = WorkerService.getTimeWorker(list);

        request.setAttribute("sum", sum);
        request.setAttribute("time", time);
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.money");
        return page;
    }

}
