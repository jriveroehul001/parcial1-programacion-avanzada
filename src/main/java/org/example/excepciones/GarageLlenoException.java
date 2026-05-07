package org.example.excepciones;

public class GarageLlenoException extends Exception {
    public GarageLlenoException(String mensaje) {
        super(mensaje);
    }
}
