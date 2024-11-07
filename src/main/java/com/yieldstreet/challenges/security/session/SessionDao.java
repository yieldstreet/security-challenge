package com.yieldstreet.challenges.security.session;

import java.util.UUID;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SessionDao {
    private final JdbcTemplate jdbc;

    public SessionDao(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(String id, String userId) {
        jdbc.execute("insert into session (id, user_id) values ('" + id + "', '" + userId + "')");
    }

    public String findSessionUserId(String sessionId) {
        var userIds = jdbc.queryForList("select user_id from session where id = '" + sessionId + "'", String.class);
        return userIds.isEmpty() ? null : userIds.get(0);
    }
}
