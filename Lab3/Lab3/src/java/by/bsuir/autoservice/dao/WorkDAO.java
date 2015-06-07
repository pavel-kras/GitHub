package by.bsuir.autoservice.dao;

import by.bsuir.autoservice.database.DataBaseConnectionPool;
import by.bsuir.autoservice.domain.Work;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WorkDAO {

    public static final String SQL_SELECT_WORK = "SELECT work.id_work, work.title, work.time, work.price "
            + "FROM work";
    public static final String SQL_SELECT_WORK_SELECT = "SELECT work.id_work, work.title, work.time, work.price "
            + "FROM work WHERE work.selects=0";
    public static final String SQL_UPDATE_WORK = "UPDATE work SET title=?, time=?, price=? WHERE id_work=?";
    public static final String SQL_UPDATE_WORK_SELECT = "UPDATE work SET work.selects=1 WHERE id_work=?";
    public static final String SQL_UPDATE_WORK_SELECT_NEW = "UPDATE work SET work.selects=1 WHERE id_work=?";
    public static final String SQL_UPDATE_WORK_SELECT_OLD = "UPDATE work SET work.selects=0 WHERE id_work=?";
    public static final String SQL_ADD_WORK = "INSERT INTO work (title,time,price) VALUES (?,?,?)";
    public static final String SQL_DELETE_WORK = "DELETE FROM work WHERE id_work=?";

    public static List<Work> getWorkList() {
        List<Work> list = new ArrayList<>();
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_SELECT_WORK);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        while (rs.next()) {
                            Work work = new Work();
                            work.setIdWork(rs.getInt(1));
                            work.setTitle(rs.getString(2));
                            work.setTime(rs.getInt(3));
                            work.setPrice(rs.getInt(4));
                            list.add(work);
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
    
    public static List<Work> getWorkListSelect() {
        List<Work> list = new ArrayList<>();
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_SELECT_WORK_SELECT);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        while (rs.next()) {
                            Work work = new Work();
                            work.setIdWork(rs.getInt(1));
                            work.setTitle(rs.getString(2));
                            work.setTime(rs.getInt(3));
                            work.setPrice(rs.getInt(4));
                            list.add(work);
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

    public static void updateWork(Work work) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_UPDATE_WORK);
                    st.setString(1, work.getTitle());
                    st.setInt(2, work.getTime());
                    st.setInt(3, work.getPrice());
                    st.setInt(4, work.getIdWork());
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

    public static void updateWorkSelect(int number) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_UPDATE_WORK_SELECT);
                    st.setInt(1, number);
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
    
    public static void updateWorkSelectDouble(int news, int old) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_UPDATE_WORK_SELECT_OLD);
                    st.setInt(1, old);
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
                    st = cn.prepareStatement(SQL_UPDATE_WORK_SELECT_NEW);
                    st.setInt(1, news);
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
    
    public static void addWork(Work work) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_ADD_WORK);
                    st.setString(1, work.getTitle());
                    st.setInt(2, work.getTime());
                    st.setInt(3, work.getPrice());
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

    public static void deleteWork(Work work) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement(SQL_DELETE_WORK);
                    st.setInt(1, work.getIdWork());
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
