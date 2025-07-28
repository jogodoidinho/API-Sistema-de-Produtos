package com.teste.maven.resources.exception;

import java.io.Serializable;
import java.time.Instant;

public class StandardError implements Serializable {
    private Instant instant;
    private Integer status;
    private String path,message,error;

    public StandardError(){
    }

    public StandardError(Instant instant, Integer status, String path, String message, String error) {
        this.instant = instant;
        this.status = status;
        this.path = path;
        this.message = message;
        this.error = error;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
