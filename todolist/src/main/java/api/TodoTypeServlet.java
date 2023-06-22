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

@WebServlet("/type")
public class TodoTypeServlet extends HttpServlet {

    public TodoTypeServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Long id = Long.parseLong(request.getParameter("id"));
        String type = request.getParameter("type");
        Todo todo = new Todo(id, type);

        TodoDao dao = new TodoDao();
        int updateCount = dao.updateTodo(todo);

        System.out.println("업데이트됨 " + updateCount);

        // Main으로 리다이렉트
        response.sendRedirect("main");      /*TODO: 타입 변경 버튼 클릭 시 새로고침 안하면 화면에 적용 안됨 */
    }
}
