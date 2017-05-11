package edu.javacourse.third.db;

import edu.javacourse.third.domain.StudentOrder;

import java.sql.*;
import java.util.List;

/**
 * Created by antonsaburov on 11.05.17.
 */
public class DbDataSource implements StudentOrderDataSource
{
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        String login = "postgres";
        String pswd = "postgres";
        String url = "jdbc:postgresql://127.0.0.1:5432/java-course";
        return DriverManager.getConnection(url, login, pswd);
    }

    @Override
    public Long addStudentOrder(StudentOrder so) {
        try (Connection con = getConnection();) {
            PreparedStatement stmt = null;
            try {
                stmt = con.prepareStatement(
                        "INSERT INTO st_group (groupName, curator, speciality) VALUES (?, ?, ?)");
                stmt.setString(1, "Четвертая группа");
                stmt.setString(2, "Куратор");
                stmt.setString(3, "Специальность '1'2'3'4");
                stmt.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (stmt != null) stmt.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<StudentOrder> getStudentOrders() {
        try (Connection con = getConnection();) {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            try {
                stmt = con.prepareStatement("SELECT * FROM st_group");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    long groupId = rs.getLong("group_id");
                    String groupName = rs.getString("groupName");
                    System.out.println(groupId + ":" + groupName);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
