package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Order;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.OrderService;
import by.bsuir.autoservice.service.WorkService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddOrderCommand implements Command{
    private static final String PARAM_ID_WORKER = "idworker";
    private static final String PARAM_ID_WORK = "idwork";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Order order = new Order();
        order.setIdWorker(Integer.parseInt(request.getParameter(PARAM_ID_WORKER)));
        order.setIdWork(Integer.parseInt(request.getParameter(PARAM_ID_WORK)));
        OrderService.addOrder(order);
        WorkService.updateWorkSelect(Integer.parseInt(request.getParameter(PARAM_ID_WORK)));
        
        List<Order> list = OrderService.getOrderList();
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.order");
        return page;
    }   
}
