package jdbcexam.dao;

import jdbcexam.dto.Role;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class RoleDao {

    private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
    private static String dbuser = "connectuser";
    private static String dbpasswd = "connectuser";

    public Role getRole(Integer roleId) {
        Role role = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);

            String query = "SELECT role_id, description FROM role WHERE role_id = ?";
            ps = conn.prepareStatement(query);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();

            if (rs.next()) {     // 결과값이 없을 수도 있기에 boolean 타입
                String description = rs.getString("description");
                int id = rs.getInt("role_id");

                role = new Role(id, description);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return role;
    }

    public int addRole(Role role) {
        int insertCount = 0;

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dburl, dbuser, dbpasswd);

            String query = "INSERT INTO role (role_id, description) VALUES (?, ?)";

            ps = conn.prepareStatement(query);
            ps.setInt(1, role.getRoleId());
            ps.setString(2, role.getDescription());

            insertCount = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception e) {
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }

        return insertCount;
    }

    public List<Role> getRoles() {
        List<Role> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "SELECT description, role_id FROM role order by role_id desc";

        // try-with-resources : try()에서 선언된 객체들에 대하여, try가 종료될 때 자동으로 리소스를 해제해주는 기능
        try(Connection coon = DriverManager.getConnection(dburl, dbuser, dbpasswd);
            PreparedStatement ps = coon.prepareStatement(query)) {

            try(ResultSet rs = ps.executeQuery()) {

                while(rs.next()) {
                    String description = rs.getString(1);
                    int id = rs.getInt("role_id");
                    Role role = new Role(id, description);
                    list.add(role);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
