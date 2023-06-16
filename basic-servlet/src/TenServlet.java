import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ten")
public class TenServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public TenServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
         * HttpServletRequest: 서버가 요청을 받아내는 객체
         * HttpServletResponse: 서버가 응답을 하기 위한 객체
         */

        response.setContentType("text/html;charset=utf-8");     // setContentType: 응답할 콘텐츠의 타입을 알려주는 메소드

        PrintWriter out = response.getWriter();
        out.print("<h1>1부터 10까지 출력합니다.</h1>");
        for(int i = 1; i <= 10; i++) {
            out.print(i + "<br>");
        }
        out.close();
    }
}
