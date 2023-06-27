package com.example.guestbook.dao;

import com.example.guestbook.dto.Log;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class LogDao {

    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Log> rowMapper = BeanPropertyRowMapper.newInstance(Log.class);

    public LogDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("log")
                .usingGeneratedKeyColumns("id");        // id가 자동으로 입력되도록
    }

    public Long insert(Log log) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(log);
        return insertAction.executeAndReturnKey(params).longValue();        // 자동으로 생성된 id 값을 리턴하도록
    }


}
