import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ApplicationScope02")
public class ApplicationScope02 extends HttpServlet {

    public ApplicationScope02() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        ServletContext servletContext = getServletContext();

        try {
            int value = (int) servletContext.getAttribute("value");
            value++;
            servletContext.setAttribute("value", value);

            out.println("<h1>value: " + value + "</h1><br>");
        } catch (NullPointerException e) {
            out.print("value의 값이 설정되지 않았음<br>");
        }
    }
}
