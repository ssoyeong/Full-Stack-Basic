import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/next")
public class NextServlet extends HttpServlet {

    public NextServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");

        int dice = (Integer)request.getAttribute("dice");       // Object 타입을 Integer로 형변환
        out.println("dice: " + dice + "<br>");

        for(int i = 0; i < dice; i++) {
            out.println("hello<br>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}
