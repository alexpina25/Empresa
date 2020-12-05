package es.empresa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal con el método main de la aplicación Empresa3A
 *
 * @version 3B 3.0
 * @since 17-11-2020
 * @author Alejandro Pina
 */
public class EmpresaTest {
    
    static List<Empleado> e = new ArrayList();
    
    /**
     * Metodo main en el que se ejecuta el menu y todas sus opciones
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;
        Plantilla.crearEmpleados();
        do {
            System.out.println("\t\tM E N Ú");
            System.out.println("\t1) Alta de empleado");
            System.out.println("\t2) Mostrar empleados");
            System.out.println("\t3) Subir sueldo");
            System.out.println("\t4) Totalizar sueldos");
            System.out.println("\t5) Descontar porcentaje");
            System.out.println("\t6) Borrar empleado");
            System.out.println("\t7) Modificar empleado");
            System.out.println("\t8) Finalizar programa");
            System.out.print("Introduce una opción: ");
            
            opcion = sc.nextLine();
            
            switch (opcion) {
                case "1":
                    Plantilla.altaEmpleado();
                    break;
                case "2":
                    Plantilla.listarEmpleados();
                    break;
                case "3":
                    Plantilla.subirSueldo(Plantilla.buscarEmpleado());
                    break;
                case "4":
                    Plantilla.totalizarSueldos((ArrayList<Empleado>) e);
                    break;
                case "5":
                    Plantilla.descontarPorcentaje(Plantilla.buscarEmpleado());
                    break;
                case "6":
                    Plantilla.borrarEmpleado(Plantilla.buscarEmpleado());
                    break;
                case "7":
                    Plantilla.modificarEmpleado(Plantilla.buscarEmpleado());
                    break;
                case "8":
                    System.exit(0);
                
                default:
                    if (!opcion.equals("8")) {
                        System.out.println(">> Opción incorrecta. Repita, por favor...");
                    }
            }
        } while (!opcion.equals("8"));
    }
}
