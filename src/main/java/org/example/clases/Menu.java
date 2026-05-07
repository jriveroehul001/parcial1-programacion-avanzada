package org.example.clases;
import org.example.excepciones.DatoInvalidoException;
import org.example.excepciones.GarageLlenoException;
import org.example.excepciones.PatenteDuplicadaException;
import org.example.excepciones.VehiculoNoEncontradoException;

import java.util.Scanner;


public class Menu {
    private Garage garage;
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
        inicializarGarage();
    }

    private void inicializarGarage() {
        System.out.println("Iniciando el Garage................");
        System.out.println("-----------GARAGE PEPITO------------");
        System.out.println("Ingrese la capacidad máxima del garage:");
        int capacidad = 0;
        while (capacidad <= 0) {
            try {
                capacidad = Integer.parseInt(sc.nextLine());
                if (capacidad <= 0) {
                    System.out.println("La capacidad debe ser mayor a 0..........");
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Dato  inválido!!! Ingrese un número........");
            }

        }
        garage = new Garage(capacidad);
        System.out.println("Garage creado correctamente... con capacidad de: " + capacidad);

    }

    public void iniciar() {
        int opcion = 0;
        while (opcion != 6) {
            mostrarMenu();
            try {
                opcion = Integer.parseInt(sc.nextLine());
                switch (opcion) {
                    case 1:
                        registrarIngreso();
                        break;
                    case 2:
                        registrarSalida();
                        break;
                    case 3:
                        garage.listarVehiculos();
                        break;
                    case 4:
                        mostrarEstado();
                        break;
                    case 5:
                        garage.mostrarReporte();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema..............");
                        break;
                    default:
                        System.out.println("Ingrese una opción válida..........");
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Ingrese un número válido...........");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("\n=== SISTEMA DE GARAGE ===");
        System.out.println("1. Registrar ingreso");
        System.out.println("2. Registrar salida");
        System.out.println("3. Listar vehículos");
        System.out.println("4. Estado del garage");
        System.out.println("5. Reportes");
        System.out.println("6. Salir");
        System.out.print("Ingrese una opción: ");
    }

    private void registrarIngreso() {
        try {
            System.out.println("Tipo de vehículo (1.Moto / 2.Auto / 3.Camion): ");
            int tipo = Integer.parseInt(sc.nextLine());
            if (tipo < 1 || tipo > 3) {
                System.out.println("Tipo inválido.");
                return;
            }

            System.out.print("Patente: ");
            String patente = sc.nextLine();
            if (patente.isEmpty()) {
                System.out.println("La patente no puede estar vacía.");
                return;
            }

            System.out.print("Marca: ");
            String marca = sc.nextLine();
            if (marca.isEmpty()) {
                System.out.println("La marca no puede estar vacía.");
                return;
            }

            System.out.print("Modelo: ");
            String modelo = sc.nextLine();
            if (modelo.isEmpty()) {
                System.out.println("El modelo no puede estar vacío.");
                return;
            }

            System.out.print("Horas estimadas: ");
            int horas = Integer.parseInt(sc.nextLine());
            if (horas <= 0) {
                throw new DatoInvalidoException("Las horas deben ser mayores a 0.");
            }
//(String marca, String modelo, String patente, int horasEstimadas)
            Vehiculo v = null;
            if (tipo == 1) v = new Moto(marca, modelo, patente, horas);
            else if (tipo == 2) v = new Auto(marca, modelo, patente, horas);
            else v = new Camion(marca, modelo, patente, horas);
            // creo primero vehiculo para no repetir registrar ingreso
            garage.registrarIngreso(v);

        } catch (NumberFormatException e) {
            System.out.println("Dato inválido. Ingrese un número donde corresponde.");
        } catch (DatoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (GarageLlenoException e) {
            System.out.println(e.getMessage());
        } catch (PatenteDuplicadaException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registrarSalida() {
        try {
            System.out.print("Ingrese la patente del vehículo: ");
            String patente = sc.nextLine();
            if (patente.isEmpty()) {
                System.out.println("La patente no puede estar vacía.");
                return;
            }
            garage.registrarSalida(patente);
        } catch (VehiculoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

    }
    private void mostrarEstado() {
        System.out.println("=== ESTADO DEL GARAGE ===");
        System.out.println("Espacios libres: " + garage.getEspaciosLibres());
    }

}