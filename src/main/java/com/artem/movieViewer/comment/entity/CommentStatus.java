package com.artem.movieViewer.comment.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CommentStatus {
    ACTIVE("active"),
    BLOCKED("blocked");

    private final String value;

    CommentStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}
