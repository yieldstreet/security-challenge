package com.yieldstreet.challenges.security.document;

import java.util.List;
import java.util.UUID;

import com.yieldstreet.challenges.security.session.SessionHelper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);
    private SessionHelper sessionHelper;
    private DocumentDao documentDao;

    public DocumentController(SessionHelper sessionHelper, DocumentDao documentDao) {
        this.sessionHelper = sessionHelper;
        this.documentDao = documentDao;
    }

    @PostMapping("/document/upload")
    public UUID upload(@CookieValue("session_id") String sessionId, @RequestHeader("x-file-name") String name,
            @RequestBody byte[] contents) {
        var userId = sessionHelper.authenticate(sessionId);

        var document = new Document(UUID.randomUUID(), userId, name, contents);
        documentDao.insert(document);

        return document.id();
    }

    @GetMapping("/document/{id}")
    public ResponseEntity<byte[]> download(@CookieValue("session_id") String sessionId,
            @PathVariable("id") String documentId) {
        sessionHelper.authenticate(sessionId);
        logger.info("downloading document {}", documentId);

        var document = documentDao.findById(documentId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + document.name())
                .body(document.contents());
    }

    @GetMapping("/documents")
    public List<DocumentSummary> find() {
        throw new UnsupportedOperationException("need implemented yet");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    private static class DocumentNotFoundException extends RuntimeException {
    }
}
