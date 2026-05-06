package org.example.clases;

import org.example.interfaces.Calculable;

public class Auto extends Vehiculo implements Calculable {
    public Auto(String marca, String modelo, String patente, int horasEstimadas) {
        super(marca, modelo, patente, horasEstimadas);
    }

    public double calcularCosto(){
        return getHorasEstimadas()*1000;
    }


    public int getEspaciosOcupados(){
        return 2;
    }
}