package com.example.daoexam.dao;

import com.example.daoexam.dto.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

import static com.example.daoexam.dao.RoleDaoSqls.*;

@Repository     // Bean으로 등록하기. Dao는 repository 애노테이션을 붙여줌.
public class RoleDao {

    private NamedParameterJdbcTemplate jdbc;        // ?를 사용해서 바인딩하거나 결과값을 가져옴
    private SimpleJdbcInsert insertAction;
    private RowMapper<Role> rowMapper = BeanPropertyRowMapper.newInstance(Role.class);      // DBMS와 JAVA의 이름 규칙을 맞춰줌

    // 생성자에서 jdbc, insertAction이 만들어지도록 함
    public RoleDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("role");     // 어떤 테이블에 insert할 지 알려줌
    }

    public List<Role> selectAll() {
        return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);       // sql문의 바인딩할 값을 전달하기 위해 Collections.emptyMap();
    }

    public int insert(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);
        return insertAction.execute(params);
    }

    public int update(Role role) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(role);       // Map으로 바꿔줌. 이름 값 매칭
        return jdbc.update(UPDATE, params);
    }
}
