import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/today")
public class TodayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>현재 시간 보기</title>");
        out.println("<style>");
        out.println("h1 { margin: 10% 0% 0% 10%; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        // 메인 화면 네비게이션
        out.println("<a href=\"index.html\">메인 화면</a>");

        // 현재 시간 출력
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/M/d HH:mm");
        out.println("<h1>현재 시간: " + now.format(dateTimeFormatter) + "</h1><br>");

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}
