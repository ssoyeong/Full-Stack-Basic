package com.example.guestbook.dao;

import com.example.guestbook.dto.Guestbook;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.guestbook.dao.GuestbookDaoSqls.*;

@Repository
public class GuestbookDao {

    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Guestbook> rowMapper = BeanPropertyRowMapper.newInstance(Guestbook.class);

    public GuestbookDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("guestbook").usingGeneratedKeyColumns("id");
    }

    public List<Guestbook> selectAll(Integer start, Integer limit) {
        Map<String, Integer> params = new HashMap<>();
        params.put("start", start);
        params.put("limit", limit);

        return jdbc.query(SELECT_PARCING, params, rowMapper);
    }

    public Long insert(Guestbook guestbook) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public int deleteById(Long id) {
        Map<String, ?> params = Collections.singletonMap("id", id);
        return jdbc.update(DELETE_BY_ID, params);
    }

    public int selectCount() {
        return jdbc.queryForObject(SELECT_COUNT, Collections.emptyMap(), Integer.class);
    }
}
