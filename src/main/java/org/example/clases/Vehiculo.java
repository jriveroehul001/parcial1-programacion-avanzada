package org.example.clases;

import org.example.interfaces.Calculable;

public abstract class Vehiculo implements Calculable {

    private String marca;
    private String modelo;
    private String patente;
    private int horasEstimadas;

    public Vehiculo(String marca, String modelo,String patente, int horasEstimadas) {
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
        this.horasEstimadas = horasEstimadas;

    }

    //getters

    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getPatente() { return patente; }
    public int getHorasEstimadas() { return horasEstimadas; }

    //

    public abstract double calcularCosto();
    public abstract int getEspaciosOcupados();
    //

    public void mostrarDatos() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Patente: " + patente);
        System.out.println("Horas Estimadas: " + horasEstimadas);
        System.out.println("Costo Estimado: " + calcularCosto());
    }





}
