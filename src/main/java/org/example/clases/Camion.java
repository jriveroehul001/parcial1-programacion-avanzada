package org.example.clases;

import org.example.interfaces.Calculable;
import org.example.interfaces.MostrarDatos;

public class Camion extends Vehiculo implements Calculable, MostrarDatos {
    public Camion(String marca, String modelo, String patente, int horasEstimadas) {
        super(marca, modelo, patente, horasEstimadas);
    }

    public double calcularCosto(){
        return getHorasEstimadas()*1500;
    }


    public int getEspaciosOcupados(){
        return 4;
    }

    public void mostrarDatos(){
        System.out.println("Tipo: Camion");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Patente: " + getPatente());
        System.out.println("Horas Estimadas: " + getHorasEstimadas());
        System.out.println("Costo Estimado: " + calcularCosto());
    }
}