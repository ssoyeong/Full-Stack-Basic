package webapiexam.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jdbcexam.dao.RoleDao;
import jdbcexam.dto.Role;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/roles")
public class RolesServlet extends HttpServlet {

    public RolesServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        RoleDao dao = new RoleDao();

        List<Role> list = dao.getRoles();

        // JSON 사용하려고 추가했던 라이브러리, 그 라이브러리가 제공해주는 객체 ObjectMapper
        // JSON 문자열 <-> 객체
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);        // 해당 list가 JSON으로 바뀜

        PrintWriter out = response.getWriter();
        out.println(json);
        out.close();

    }
}