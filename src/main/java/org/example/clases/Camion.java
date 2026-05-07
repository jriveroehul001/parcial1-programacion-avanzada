package org.example.clases;

import org.example.interfaces.Calculable;

public class Camion extends Vehiculo implements Calculable {
    public Camion(String marca, String modelo, String patente, int horasEstimadas) {
        super(marca, modelo, patente, horasEstimadas);
    }

    public double calcularCosto(){
        return getHorasEstimadas()*1500;
    }


    public int getEspaciosOcupados(){
        return 4;
    }
}