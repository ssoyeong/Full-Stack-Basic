package jdbcexam;

import jdbcexam.dao.RoleDao;
import jdbcexam.dto.Role;

import java.util.List;

public class JDBCExam3 {

    public static void main(String[] args) {

        RoleDao dao = new RoleDao();
        List<Role> list = dao.getRoles();

        for(Role role : list) {
            System.out.println(role);
        }
    }
}
