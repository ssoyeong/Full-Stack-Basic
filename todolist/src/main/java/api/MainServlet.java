package src.main.java.api;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import src.main.java.dao.TodoDao;
import src.main.java.dto.Todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    public MainServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        TodoDao dao = new TodoDao();
        List<Todo> list = dao.getTodos();

        // 힐 일을 타입별로 분류
        List<Todo> todoList = new ArrayList<>();
        List<Todo> doingList = new ArrayList<>();
        List<Todo> doneList = new ArrayList<>();
        for(Todo todo : list) {
            if(todo.getType().equals("TODO")) todoList.add(todo);
            else if(todo.getType().equals("DOING")) doingList.add(todo);
            else doneList.add(todo);
        }


        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        request.setAttribute("todoList", todoList);
        request.setAttribute("doingList", doingList);
        request.setAttribute("doneList", doneList);

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
