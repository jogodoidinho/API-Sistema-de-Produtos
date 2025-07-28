package com.teste.maven.services.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource Not Found.ID " + id);
    }
}
