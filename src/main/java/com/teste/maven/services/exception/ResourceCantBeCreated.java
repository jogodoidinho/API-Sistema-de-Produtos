package com.teste.maven.services.exception;

public class ResourceCantBeCreated extends RuntimeException {
    public ResourceCantBeCreated(String message) {
        super(message);
    }
}
