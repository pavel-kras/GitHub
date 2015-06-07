package by.bsuir.autoservice.dao;

import by.bsuir.autoservice.database.DataBaseConnectionPool;
import by.bsuir.autoservice.domain.Order;
import by.bsuir.autoservice.domain.Worker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkerDAO {

    public static final String SQL_SELECT_WORKER = "SELECT worker.id_worker, worker.name, worker.surname, worker.tel FROM worker";
    public static final String SQL_SELECT_WORKER_UPDATE = "SELECT worker.name, worker.surname, worker.tel FROM worker WHERE worker.id_worker=?";
    public static final String SQL_UPDATE_WORKER = "UPDATE worker SET name=?, surname=?, tel=? WHERE id_worker=?";
    public static final String SQL_ADD_WORKER = "INSERT INTO worker (name,surname,tel) VALUES (?,?,?)";
    public static final String SQL_DELETE_WORKER = "DELETE FROM worker WHERE id_worker=?";
    public static final String SQL_DELETE_WORKER_ORDER = "DELETE FROM order_1 WHERE id_worker_order=?";
    public static final String SQL_SELECT_WORKER_STAT = "SELECT order_1.id_order, worker.name, worker.surname, work.title, work.time, work.price "
            + "FROM order_1 INNER JOIN worker ON order_1.id_worker_order=worker.id_worker "
            + "INNER JOIN work ON order_1.id_work_order=work.id_work "
            + "WHERE order_1.id_worker_order=? ORDER BY order_1.id_order";

    public static Worker getWorkerListUpdate(int update) {
    Worker worker = new Worker();
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    System.out.println(update);
                    st = cn.prepareStatement(SQL_SELECT_WORKER_UPDATE);
                    st.setInt(1, update);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        while (rs.next()) {
                            worker.setIdWorker(update);
                            worker.setName(rs.getString(1));
                            worker.setSurname(rs.getString(2));
                            worker.setTel(rs.getString(3));
                        }
                        return worker;
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
    
    public static List<Worker> getWorkerList() {
        List<Worker> list = new ArrayList<>();
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_SELECT_WORKER);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        while (rs.next()) {
                            Worker worker = new Worker();
                            worker.setIdWorker(rs.getInt(1));
                            worker.setName(rs.getString(2));
                            worker.setSurname(rs.getString(3));
                            worker.setTel(rs.getString(4));
                            list.add(worker);
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

    public static void updateWorker(Worker worker) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_UPDATE_WORKER);
                    st.setString(1, worker.getName());
                    st.setString(2, worker.getSurname());
                    st.setString(3, worker.getTel());
                    st.setInt(4, worker.getIdWorker());
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

    public static void addWorker(Worker worker) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_ADD_WORKER);
                    st.setString(1, worker.getName());
                    st.setString(2, worker.getSurname());
                    st.setString(3, worker.getTel());
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

    public static void deleteWorker(Worker worker) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_DELETE_WORKER_ORDER);
                    st.setInt(1, worker.getIdWorker());
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
                try {
                    st = cn.prepareStatement(SQL_DELETE_WORKER);
                    st.setInt(1, worker.getIdWorker());
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

    public static List<Order> getStatWorkerList(Order order) {
        List<Order> list = new ArrayList<>();
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_SELECT_WORKER_STAT);
                    st.setInt(1, order.getIdWorker());
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        while (rs.next()) {
                            Order order1 = new Order();
                            order1.setIdWorker(rs.getInt(1));
                            order1.setName(rs.getString(2));
                            order1.setSurname(rs.getString(3));
                            order1.setTitle(rs.getString(4));
                            order1.setTime(rs.getInt(5));
                            order1.setPrice(rs.getInt(6));
                            list.add(order1);
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
            e.printStackTrace();
        }
        return null;
    }

    public static int getSumWorker(List<Order> list) {
        int sum=0;
        for (Order list1 : list) {
            sum += list1.getPrice();
        }
        return sum;
    }
    
    public static int getTimeWorker(List<Order> list) {
        int sum=0;
        for (Order list1 : list) {
            sum += list1.getTime();
        }
        return sum;
    }
}
