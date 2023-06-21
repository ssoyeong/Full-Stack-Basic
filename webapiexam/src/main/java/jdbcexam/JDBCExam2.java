package jdbcexam;

import jdbcexam.dao.RoleDao;
import jdbcexam.dto.Role;

public class JDBCExam2 {

    public static void main(String[] args) {

        int roleId = 200;
        String description = "CTO";
        Role role = new Role(roleId, description);

        RoleDao dao = new RoleDao();
        int insertCount = dao.addRole(role);
        System.out.println(insertCount);
    }
}
