package by.bsuir.autoservice.command;

import by.bsuir.autoservice.domain.Order;
import by.bsuir.autoservice.manager.PropertiesManager;
import by.bsuir.autoservice.service.OrderService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> list = OrderService.getOrderList();
        request.setAttribute("list", list);
        String page = PropertiesManager.getProperty("paths", "page.order");
        return page;
    }
    
}
