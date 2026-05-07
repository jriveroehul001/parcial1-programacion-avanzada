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
    public void mostrarDatos(){
        System.out.println("Tipo: Auto");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Patente: " + getPatente());
        System.out.println("Horas Estimadas: " + getHorasEstimadas());
        System.out.println("Costo Estimado: " + calcularCosto());
    }
}