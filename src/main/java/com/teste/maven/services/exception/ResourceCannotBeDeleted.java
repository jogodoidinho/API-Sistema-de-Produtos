package com.teste.maven.services.exception;

public class ResourceCannotBeDeleted extends RuntimeException {
    public ResourceCannotBeDeleted(Object id) {
      super("This Id Can Not Be Deleted: " + id);

    }
}
