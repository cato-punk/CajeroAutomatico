package org.example;
import java.util.InputMismatchException; // indicar un error en la entrada de datos.
import java.util.Scanner;

public class Cajero {

    private static int saldo = 100000;
    private static Scanner scanner = new Scanner(System.in);

    public static void menu() {
        int opcion;
        do {
            mostrarOpciones();
            System.out.print("Ingrese una opción: ");
            try {
                opcion = scanner.nextInt();
                ejecutarOpcion(opcion);
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.next(); // limpiar el scanner
                opcion = -1; // para que el bucle continúe
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println(); // linea en blanco
        } while (opcion != 4); // opcion 4 para salir
        System.out.println("Procesos del cajero terminados, hasta pronto");
    }

    private static void mostrarOpciones() {
        System.out.println("--- Cajero Automático ---");
        System.out.println("___1. Consultar Saldo____");
        System.out.println("___2. Retirar Dinero_____");
        System.out.println("___3. Depositar Dinero___");
        System.out.println("___4. Salir______________");
    }

    private static void ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("Saldo actual: " + obtenerSaldo()); //falta desarrollar obtener saldo
                break;
            case 2:
                System.out.print("Ingrese el monto a retirar: ");
                try {
                    int montoRetiro = scanner.nextInt();
                    retirar(montoRetiro);//falta retirar
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un monto válido.");
                    scanner.next(); // limpiar el buffer despues de la respeusta invalida
                }
                break;
            case 3:
                System.out.print("Ingrese el monto a depositar: ");
                try {
                    int montoDeposito = scanner.nextInt();
                    depositar(montoDeposito);
                } catch (InputMismatchException e) {
                    System.out.println("Error: Ingrese un monto válido.");
                    scanner.next();
                }
                break;
            case 4:
                System.out.println("Hasta pronto");
                break;
            default:
                System.out.println("Opción no válida. Por favor, intente de nuevo.");
        }
    }
