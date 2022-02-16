package com.example.digitalDen.db.util;

import com.sun.rowset.internal.Row;
import org.hibernate.action.internal.EntityActionVetoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.StopWatch;


import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class JDBCAccess {

    private final Logger logger = LoggerFactory.getLogger(JDBCAccess.class);
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public <T> List<T> find(String sql, RowMapper<T> rowMapper, Object... params) {
        List<T> results = jdbcTemplate.query(sql, params, rowMapper);
        return results;
    }

    public <T> List<T> findUsingNamedParameter(String sql, Map<String, Object> mapOfParameter, RowMapper<T> rowMapper){
        List<T> results = namedParameterJdbcTemplate.query(sql, mapOfParameter, rowMapper);
        return results;
    }

    public <T> T findOne(String sql, RowMapper<T> rowMapper, Object... params){
        try{
            return jdbcTemplate.queryForObject(sql, params,rowMapper);
        } catch(EntityActionVetoException e){
            logger.debug("findOne did not find any Object", e);
            return null;
        }
    }

    public Integer findInteger(String sql, Object... params){
        StopWatch watch = new StopWatch();
        try{
            Number number = jdbcTemplate.queryForObject(sql, params, Integer.class);
            return number != null ? number.intValue() : 0;
        } catch(EmptyResultDataAccessException e) {
            logger.debug("findInteger did not find any result", e);
            return null;
        } finally {
            logger.debug("findInteger, sql={}, params={}, elapsedTime={}", sql, params);
        }
    }

    public int update(String sql, Object... params){
        int updateRows = 0;
        updateRows = jdbcTemplate.update(sql, params);
        return  updateRows;
    }

    public int[] batchUpdate(String sql, List<Object[]> batchArgs) throws DataAccessException {
        return jdbcTemplate.batchUpdate(sql, batchArgs, new int[0]);
    }

    public void setDataSource(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


}
