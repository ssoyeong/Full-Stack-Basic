import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/front")
public class FrontServlet extends HttpServlet {

    public FrontServlet() {
        super();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int diceValue = (int)(Math.random() * 6) + 1;
        request.setAttribute("dice", diceValue);        // dice라는 이름으로 요청에 추가해서 넘겨줄 거임

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/next");        // 이 Servlet으로 넘겨줄 거임
        requestDispatcher.forward(request, response);       // 처음에 생성된 요청, 응답 객체를 포워드 해줌
    }
}
