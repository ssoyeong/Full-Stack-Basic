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

        RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
        request.setAttribute("todos", list);

        dispatcher.forward(request, response);
    }
}
