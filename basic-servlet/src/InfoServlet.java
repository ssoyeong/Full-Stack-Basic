import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    public InfoServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>form</title></head>");
        out.println("<body>");

        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        String contentPath = request.getContextPath();      // WAS에는 여러 웹 애플리케이션이 돌아갈 수 있음. 특정 애플리케이션을 찾아가는 이름
        String remoteAddr = request.getRemoteAddr();

        out.println("uri: " + uri + "<br>");
        out.println("url: " + url + "<br>");
        out.println("contentPath: " + contentPath + "<br>");
        out.println("remoteAddr: " + remoteAddr + "<br>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
