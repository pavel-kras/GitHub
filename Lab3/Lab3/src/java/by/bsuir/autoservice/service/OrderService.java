package by.bsuir.autoservice.service;

import by.bsuir.autoservice.dao.OrderDAO;
import by.bsuir.autoservice.domain.Order;
import java.util.List;

public class OrderService {

    public static List<Order> getOrderList() {
        List<Order> list = OrderDAO.getOrderList();
        return list;
    }

    public static void updateOrder(Order order) {
        OrderDAO.updateOrder(order);
    }

    public static void deleteOrder(Order order) {
        OrderDAO.deleteOrder(order);
    }
    
    public static void addOrder(Order order) {
        OrderDAO.addOrder(order);
    }
}
