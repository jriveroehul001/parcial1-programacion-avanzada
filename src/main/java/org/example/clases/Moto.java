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

    public void mostrarDatos(){
        System.out.println("Tipo: Moto");
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Patente: " + getPatente());
        System.out.println("Horas Estimadas: " + getHorasEstimadas());
        System.out.println("Costo Estimado: " + calcularCosto());
    }
}
