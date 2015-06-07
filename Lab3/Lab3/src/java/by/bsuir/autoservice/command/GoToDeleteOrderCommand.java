package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Order;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.OrderService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToDeleteOrderCommand implements Command{

    private static final String PARAM_ID_ORDER = "idorder";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Order order = new Order();
        order.setIdOrder(Integer.parseInt(request.getParameter(PARAM_ID_ORDER)));
        OrderService.deleteOrder(order);

        List<Order> list = OrderService.getOrderList();
        request.setAttribute("list", list);
        page = PropertiesManager.getProperty("paths", "page.order");
        return page;
    }
    
}
