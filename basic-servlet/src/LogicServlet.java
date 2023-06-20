import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logic")
public class LogicServlet extends HttpServlet {

    public LogicServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int v1 = (int)(Math.random() * 100) + 1;
        int v2 = (int)(Math.random() * 100) + 1;
        int result = v1 + v2;

        request.setAttribute("v1", v1);
        request.setAttribute("v2", v2);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/result.jsp");
        dispatcher.forward(request, response);
    }
}
