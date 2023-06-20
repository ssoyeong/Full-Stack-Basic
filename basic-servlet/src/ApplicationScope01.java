import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ApplicationScope01")
public class ApplicationScope01 extends HttpServlet {

    public ApplicationScope01() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        ServletContext servletContext = getServletContext();
        int value = 1;
        servletContext.setAttribute("value", value);

        out.println("<h1>value: " + value + "</h1><br>");
    }
}
