package by.bsuir.autoservice.dao;

import by.bsuir.autoservice.database.DataBaseConnectionPool;
import by.bsuir.autoservice.domain.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {

    public static final String SQL_SELECT_ORDER = "SELECT order_1.id_order, worker.id_worker, worker.name, worker.surname, work.id_work, work.title, work.time, work.price "
            + "FROM order_1 INNER JOIN worker ON order_1.id_worker_order=worker.id_worker "
            + "INNER JOIN work ON order_1.id_work_order=work.id_work ORDER BY order_1.id_order";
    public static final String SQL_UPDATE_ORDER = "UPDATE order_1 SET id_worker_order=?, id_work_order=? WHERE id_order=?";
    public static final String SQL_DELETE_ORDER = "DELETE FROM order_1 WHERE id_order=?";
    public static final String SQL_ADD_ORDER = "INSERT INTO order_1 (id_worker_order,id_work_order) VALUES (?,?)";

    public static List<Order> getOrderList() {
        List<Order> list = new ArrayList<>();
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_SELECT_ORDER);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        while (rs.next()) {
                            Order order = new Order();
                            order.setIdOrder(rs.getInt(1));
                            order.setIdWorker(rs.getInt(2));
                            order.setName(rs.getString(3));
                            order.setSurname(rs.getString(4));
                            order.setIdWork(rs.getInt(5));
                            order.setTitle(rs.getString(6));
                            order.setTime(rs.getInt(7));
                            order.setPrice(rs.getInt(8));
                            list.add(order);
                            System.out.println(order.getName());
                            System.out.println(order.getTitle());
                        }
                        return list;
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    connection.closeConnection(cn);
                }
            }
        } catch (SQLException e) {
            return null;
        }

    }

    public static void updateOrder(Order order) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_UPDATE_ORDER);
                    st.setInt(1, order.getIdWorker());
                    st.setInt(2, order.getIdWork());
                    st.setInt(3, order.getIdOrder());
                    ResultSet rs = null;
                    try {
                        st.executeUpdate();
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    connection.closeConnection(cn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteOrder(Order order) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_DELETE_ORDER);
                    st.setInt(1, order.getIdOrder());
                    ResultSet rs = null;
                    try {
                        st.executeUpdate();
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    connection.closeConnection(cn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addOrder(Order order) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_ADD_ORDER);
                    st.setInt(1, order.getIdWorker());
                    st.setInt(2, order.getIdWork());
                    ResultSet rs = null;
                    try {
                        st.executeUpdate();
                    } finally {
                        if (rs != null) {
                            rs.close();
                        }
                    }
                } finally {
                    if (st != null) {
                        st.close();
                    }
                }
            } finally {
                if (cn != null) {
                    connection.closeConnection(cn);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
