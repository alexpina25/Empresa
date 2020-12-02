package es.empresa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase principal con el método main de la aplicación Empresa3A
 *
 * @version 3B 2.0
 * @since 17-11-2020
 * @author Alejandro Pina
 */
public class EmpresaTest{

    private static String linea;
    private static final Scanner SCAN = new java.util.Scanner(System.in);
    public static ArrayList<Empleado> e;

    public static void main(String[] args) {
        Plantilla.crearEmpleados();
        do {
            System.out.println("\t\tM E N Ú");
            System.out.println("\t1) Alta de empleado");
            System.out.println("\t2) Listar empleados");
            System.out.println("\t3) Subir sueldo");
            System.out.println("\t4) Totalizar sueldos");
            System.out.println("\t5) Descontar porcentaje");
            System.out.println("\t6) Borrar empleado");
            System.out.println("\t7) Modificar empleado");
            System.out.println("\t8) Finalizar programa");
            System.out.print("Introduce una opción: ");

            linea = SCAN.nextLine().toUpperCase();

            switch (linea) {
                case "1":
                    Plantilla.altaEmpleado();
                    break;
                case "2":
                    Plantilla.listarEmpleados();
                    break;
                case "3":
                    Plantilla.subirSueldo();
                    break;
                case "4":
                    Plantilla.totalizarSueldos(EmpresaTest.e);
                    break;
                case "5":
                    Plantilla.descontarPorcentaje();
                    break;
                case "6":
                    Plantilla.borrarEmpleado();
                    break;

                default:
                    if (!linea.equals("8")) {
                        System.out.println(">> Opción incorrecta. Repita, por favor...");
                    }
            }
        } while (!linea.equals("8"));
    }
}