package src.main;

import src.main.java.dao.TodoDao;
import src.main.java.dto.Todo;

import java.io.IOException;

public class TestAdd {

    public static void main(String[] args) throws IOException {

        String name = "전소영";
        String title = "황뽀또 마카롱 먹기";
        int sequence = 2;
        Todo todo = new Todo(name, title, sequence);

        TodoDao dao = new TodoDao();
        int insertCount = dao.addTodo(todo);
        System.out.println(insertCount);

    }
}
