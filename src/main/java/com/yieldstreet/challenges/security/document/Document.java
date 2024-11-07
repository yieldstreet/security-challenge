package com.yieldstreet.challenges.security.document;

import java.util.UUID;

public record Document(
    UUID id,
    UUID userId,
    String name,
    byte[] contents
) {
}
