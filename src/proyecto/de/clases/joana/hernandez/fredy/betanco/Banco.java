/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto.de.clases.joana.hernandez.fredy.betanco;

import java.util.Scanner;

/**
 *
 * @author joana
 */
public class Banco {
    private Cuenta[] cuentas = new Cuenta[100]; // Limite máximo de cuentas
    private int totalCuentas = 0; // Número actual de cuentas
    private Scanner scanner = new Scanner(System.in);

    // Método para mostrar menú principal
    public void mostrarMenu() {
        while (true) {
            System.out.println("Bienvenido/a al banco en linea oficial de UNITEC");
            System.out.println("Tiene cuenta existente? (s/n):");
            String respuesta = scanner.nextLine().toLowerCase();

            if (respuesta.equals("s")) {
                Cuenta cuenta = iniciarSesion();
                if (cuenta != null) {
                    mostrarMenuCuenta(cuenta);
                }
            } else if (respuesta.equals("n")) {
                crearCuenta();
            } else {
                System.out.println("Respuesta no valida.");
            }
            
            System.out.println();
            System.out.println("Desea realizar otra operacion? (s/n):");
            String continuar = scanner.nextLine().toLowerCase();
            if (continuar.equals("n")) {
                System.out.println("Gracias por usar nuestro sistema.");
                System.out.println();
                break;
            }
        }
    }

    // Método para el menú de la cuenta
    private void mostrarMenuCuenta(Cuenta cuenta) {
        while (true) {
            System.out.println("Que desea hacer?");
            System.out.println("1. Agregar dinero");
            System.out.println("2. Transferir dinero");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            
            System.out.println();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese la cantidad a depositar:");
                    double deposito = scanner.nextDouble();
                    scanner.nextLine(); // Consumir nueva línea
                    cuenta.depositar(deposito);
                    break;
                case 2:
                    System.out.println("Ingrese el PIN del destinatario:");
                    int pinDestino = scanner.nextInt();
                    scanner.nextLine(); // Consumir nueva línea
                    Cuenta destinatario = buscarCuentaPorPin(pinDestino);
                    if (destinatario != null) {
                        System.out.println("Ingrese la cantidad a transferir:");
                        double monto = scanner.nextDouble();
                        scanner.nextLine(); // Consumir nueva línea
                        cuenta.transferir(destinatario, monto);
                    } else {
                        System.out.println("Cuenta destinataria no encontrada.");
                    }
                    break;
                case 3:
                    System.out.println("Saldo actual: $" + cuenta.getSaldo());
                    break;
                case 4:
                    System.out.println("Saliendo del menú de la cuenta...");
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }

    // Método para buscar cuenta por PIN
    private Cuenta buscarCuentaPorPin(int pin) {
        for (int i = 0; i < totalCuentas; i++) {
            if (cuentas[i].getPin() == pin) {
                return cuentas[i];
            }
        }
        return null;
    }

}
