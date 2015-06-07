package by.bsuir.autoservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.bsuir.autoservice.database.DataBaseConnectionPool;

public class LoginDAO {
	public static String checkLogin(String login, String password) {
        try {
            Connection cn = null;
            DataBaseConnectionPool connection = new DataBaseConnectionPool();
            try {
                cn = connection.getConnection();
                PreparedStatement st = null;
                try {
                    st = cn.prepareStatement("SELECT type FROM login WHERE login = ? AND password = ?");
                    st.setString(1, login);
                    st.setString(2, password);
                    ResultSet rs = null;
                    try {
                        rs = st.executeQuery();
                        rs.next();
                        String type = rs.getString(1);
                        return type;
                    } finally {
                        if (rs != null)
                            rs.close();
                    }
                } finally {
                    if (st != null)
                        st.close();
                }
            } finally {
                if (cn != null)
                    connection.closeConnection(cn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
