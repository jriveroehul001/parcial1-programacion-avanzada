package org.example.excepciones;

public class DatoInvalidoException extends RuntimeException    {
    public DatoInvalidoException(String message) {
        super(message);
    }
}
