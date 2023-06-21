package src.main;

import src.main.java.dao.TodoDao;
import src.main.java.dto.Todo;

import java.io.IOException;

public class TestUpdate {

    public static void main(String[] args) throws IOException {

        Long id = 4L;
        String type = "TODO";
        Todo todo = new Todo(id, type);

        TodoDao dao = new TodoDao();
        int updateCount = dao.updateTodo(todo);

        System.out.println(updateCount);
    }
}
