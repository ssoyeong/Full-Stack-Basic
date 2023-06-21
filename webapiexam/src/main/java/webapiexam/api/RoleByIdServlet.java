package webapiexam.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jdbcexam.dao.RoleDao;
import jdbcexam.dto.Role;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/roles/*")
public class RoleByIdServlet extends HttpServlet {

    public RoleByIdServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");

        String pathInfo = request.getPathInfo();        // 읽어온 패스 정보 /roles/{roleId}
        String[] pathParts = pathInfo.split("/");
        String idStr = pathParts[1];
        int id = Integer.parseInt(idStr);

        RoleDao dao = new RoleDao();
        Role role = dao.getRole(id);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(role);

        PrintWriter out = response.getWriter();
        out.println(json);
        out.close();
    }
}
