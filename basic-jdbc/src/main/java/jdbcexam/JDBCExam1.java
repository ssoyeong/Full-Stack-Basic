package jdbcexam;

import jdbcexam.dao.RoleDao;
import jdbcexam.dto.Role;

public class JDBCExam1 {

    public static void main(String[] args) {

        RoleDao dao = new RoleDao();
        Role role = dao.getRole(100);
        System.out.println(role);
    }
}
