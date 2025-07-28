package com.teste.maven.services.exception;

public class ResourceCantBeModifier extends RuntimeException {
    public ResourceCantBeModifier(String message) {
        super("This Attribute Cant Be Modified Because :" + message);
    }
}
