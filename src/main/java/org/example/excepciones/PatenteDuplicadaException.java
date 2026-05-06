package org.example.excepciones;

public class PatenteDuplicadaException extends Exception {
    public PatenteDuplicadaException(String mensaje) {
        super(mensaje);
    }
}
