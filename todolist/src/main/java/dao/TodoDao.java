package src.main.java.dao;

import src.main.java.dto.Todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDao {

    private static String dburl = "jdbc:mysql://localhost:3306/connectdb";
    private static String dbuser = "connectuser";
    private static String dbpasswd = "connectuser";

    public int addTodo(Todo todo) {

        int insertCount = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "INSERT INTO todo (title, name, sequence) VALUES (?, ?, ?)";

        try(Connection coon = DriverManager.getConnection(dburl, dbuser, dbpasswd);
            PreparedStatement ps = coon.prepareStatement(query)) {

            ps.setString(1, todo.getTitle());
            ps.setString(2, todo.getName());
            ps.setInt(3, todo.getSequence());

            insertCount = ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return insertCount;
    }

    public List<Todo> getTodos() {

        List<Todo> list = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        String query = "SELECT id, title, name, sequence, type, regdate FROM todo order by regdate";

        try(Connection coon = DriverManager.getConnection(dburl, dbuser, dbpasswd);
            PreparedStatement ps = coon.prepareStatement(query)) {

            try(ResultSet rs = ps.executeQuery()) {

                while(rs.next()) {
                    Long id = rs.getLong("id");
                    String title = rs.getString("title");
                    String name = rs.getString("name");
                    int sequence = rs.getInt("sequence");
                    String type = rs.getString("type");
                    String regdate = rs.getString("regdate");

                    Todo todo = new Todo(id, name, regdate, sequence, title, type);
                    list.add(todo);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int updateTodo(Todo todo) {

        int updateCount = 0;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(todo.getType().equals("DONE")) return updateCount;

        String newType = todo.getType().equals("TODO") ? "DOING" : "DONE";
        String query = "UPDATE todo SET type = ? where id = ?";

        try(Connection coon = DriverManager.getConnection(dburl, dbuser, dbpasswd);
            PreparedStatement ps = coon.prepareStatement(query)) {

            ps.setString(1, newType);
            ps.setLong(2, todo.getId());

            updateCount = ps.executeUpdate();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return updateCount;
    }

}
