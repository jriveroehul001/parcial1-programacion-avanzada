package org.example.clases;

import org.example.interfaces.Calculable;

public class Moto extends Vehiculo implements Calculable {
    public Moto(String marca, String modelo, String patente, int horasEstimadas) {
        super(marca, modelo, patente, horasEstimadas);
    }

    public double calcularCosto(){
        return getHorasEstimadas()*700;
    }


    public int getEspaciosOcupados(){
        return 1;
    }
}
