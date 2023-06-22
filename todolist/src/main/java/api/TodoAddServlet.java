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

@WebServlet("/add")
public class TodoAddServlet extends HttpServlet {
    public TodoAddServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String name = request.getParameter("name");
        int sequence = Integer.parseInt(request.getParameter("sequence"));
        Todo todo = new Todo(title, name, sequence);

        TodoDao dao = new TodoDao();
        int insertCount = dao.addTodo(todo);

        // Main으로 리다이렉트
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/main");
        requestDispatcher.forward(request, response);
    }
}
