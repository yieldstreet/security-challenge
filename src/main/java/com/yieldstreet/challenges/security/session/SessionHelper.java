package com.yieldstreet.challenges.security.session;

import java.util.UUID;

import com.yieldstreet.challenges.security.NotAuthenticatedException;
import org.springframework.stereotype.Component;

@Component
public class SessionHelper {
    private final SessionDao dao;

    public SessionHelper(SessionDao dao) {
        this.dao = dao;
    }

    public UUID authenticate(String sessionId) {
        var userId = dao.findSessionUserId(sessionId);

        if (userId == null) {
            throw new NotAuthenticatedException();
        }

        return UUID.fromString(userId);
    }
}
