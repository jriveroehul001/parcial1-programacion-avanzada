package org.example.clases;
import org.example.excepciones.GarageLlenoException;
import org.example.excepciones.PatenteDuplicadaException;
import org.example.excepciones.VehiculoNoEncontradoException;

import java.util.ArrayList;

public class Garage {

    private int capacidadMaxima;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = new ArrayList<>();

    }
// es private porque solo la uso en esta clase no hace falta que sea public, voy recorriendo el array y voy agregando segun
    // vehiculo ya que depende el vehiculo va a agregar distinta cantidad
    private int getEspaciosOcupados() {
        int total = 0;
        for (Vehiculo vehiculo : vehiculos) {
            total += vehiculo.getEspaciosOcupados();
        }
        return total;
    }


    public int getEspaciosLibres(){
        return capacidadMaxima - getEspaciosOcupados();
    }

    public void registrarIngreso(Vehiculo vehiculo)
            throws GarageLlenoException, PatenteDuplicadaException {

        if (getEspaciosLibres() < vehiculo.getEspaciosOcupados()) {
            throw new GarageLlenoException("No hay espacio suficiente en el garage.");
        }

        for (Vehiculo existente : vehiculos) {
            if (existente.getPatente().equalsIgnoreCase(vehiculo.getPatente())) {
                throw new PatenteDuplicadaException("Ya existe un vehículo con la patente: " + vehiculo.getPatente());
            }
        }

        vehiculos.add(vehiculo);
        System.out.println("Vehículo ingresado correctamente.");
    }

    public Vehiculo buscarPorPatente(String patente)
            throws VehiculoNoEncontradoException {

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equalsIgnoreCase(patente)) {
                return vehiculo;
            }
        }
        throw new VehiculoNoEncontradoException("No se encontró vehículo con patente: " + patente);
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en el garage.");
            return;
        }
        for (Vehiculo v : vehiculos) {
            System.out.println("----------");
            v.mostrarDatos();
        }
    }

}
