package src.main;

import src.main.java.dao.TodoDao;
import src.main.java.dto.Todo;

import java.io.IOException;
import java.util.List;

public class TestGetList {

    public static void main(String[] args) throws IOException {

        TodoDao dao = new TodoDao();

        List<Todo> list = dao.getTodos();
        System.out.println(list);
    }
}
