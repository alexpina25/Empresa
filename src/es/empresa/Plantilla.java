package es.empresa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase de utilidades para empleados con métodos estáticos
 *
 * @author Alejandro Pina
 */
public class Plantilla {

    /**
     * Metodo para añadir unos empleados por defecto al Array
     */
    public static void crearEmpleados() {
        EmpresaTest.e.add(new Empleado("Ana", 'M', new Fecha(14, 10, 2015), 1000));
        EmpresaTest.e.add(new Jefe("Alfonso", 'H', new Fecha(10, 2, 2000), 1200, "rrhh"));
        EmpresaTest.e.add(new Empleado("Benito", 'H', new Fecha(1, 6, 2014), 1250));
        EmpresaTest.e.add(new Jefe("Monica", 'M', new Fecha(8, 4, 2012), 1300, "contabilidad"));
        EmpresaTest.e.add(new Empleado("Alfredo", 'H', new Fecha(1, 10, 2010), 995.20));
        EmpresaTest.e.add(new Empleado("Antonio", 'H', new Fecha(14, 5, 2010), 970.5));
        EmpresaTest.e.add(new Empleado("Montserrat", 'M', new Fecha(18, 1, 2010), 1095.21));
        EmpresaTest.e.add(new Empleado("Julian", 'H', new Fecha(8, 6, 2011), 1200.46));
    }

    /**
     * Metodo para sumar los sueldos de todos los empleados
     * @param e ArrayList de empleados
     * @return La suma de todos los empleados
     */
    public static double totalizarSueldos(ArrayList<Empleado> e) {
        double sumaSueldos = 0;
        for (int i = 0; i < e.size(); i++) {
            sumaSueldos += e.get(i).getSueldo();
        }
        System.out.println("\tLa suma de todos los sueldos es: " + Math.round(sumaSueldos) + "€");
        return sumaSueldos;
    }

    /**
     * Metodo para descontar un porcentaje del sueldo según el empleado sea jefe o empleado
     * @param empleado Empleado a descontar un porcentaje del sueldo
     */
    public static void descontarPorcentaje(Empleado empleado) {
        double descuentoJ = 0.05;
        double descuentoE = 0.10;
        if (empleado instanceof Jefe) {
            empleado.setSueldo(empleado.getSueldo() - (empleado.getSueldo() * descuentoJ));
        } else if (empleado instanceof Empleado) {
            empleado.setSueldo(empleado.getSueldo() - (empleado.getSueldo() * descuentoE));
        }
        System.out.println("\tEl nuevo sueldo de " + empleado.getNombre() + " es " + empleado.getSueldo());
    }

    /**
     * Metodo para añadir al ArrayList un empleado
     */
    public static void altaEmpleado() {
        Scanner sc = new Scanner(System.in);
        String opcion = "";
        while (!opcion.equals("jefe") && !opcion.equals("empleado")) {
            System.out.println("\tIntroduce \"jefe\" para dar de alta un jefe o \"empleado\" para dar de alta un empleado.");
            opcion = sc.nextLine();

            if (opcion.equals("jefe")) {
                System.out.print("\tIntroduce el nombre: ");
                String nombreJ = sc.nextLine();
                System.out.print("\tIntroduce el sexo: ");
                char sexoJ = sc.nextLine().charAt(0);
                System.out.print("\tIntroduce la fecha de contratacion (dia, mes, año): ");
                Fecha fechaConJ = new Fecha(sc.nextInt(), sc.nextInt(), sc.nextInt());
                System.out.print("\tIntroduce el sueldo: ");
                double sueldoJ = (double) sc.nextInt();
                System.out.print("\tIntroduce el departamento: ");
                String departamentoJ = sc.nextLine();
                EmpresaTest.e.add(new Jefe(nombreJ, sexoJ, fechaConJ, sueldoJ, departamentoJ));

            }

            if (opcion.equals("empleado")) {
                System.out.print("\tIntroduce el nombre: ");
                String nombre = sc.nextLine();
                System.out.print("\tIntroduce el sexo: ");
                char sexo = sc.nextLine().charAt(0);
                System.out.print("\tIntroduce la fecha de contratacion (dia, mes, año): ");
                Fecha fechaCon = new Fecha(sc.nextInt(), sc.nextInt(), sc.nextInt());
                System.out.print("\tIntroduce el sueldo: ");
                double sueldo = (double) sc.nextInt();
                EmpresaTest.e.add(new Empleado(nombre, sexo, fechaCon, sueldo));
            }
        }
    }

    /**
     * Metodo para mostrar en pantalla todos los empleados del ArrayList
     */
    public static void listarEmpleados() {
        System.out.println("\tHay un total de " + EmpresaTest.e.size() + " empleados.");
        EmpresaTest.e.forEach(empleado -> System.out.println(empleado));
    }

    /**
     * Metodo para eliminar un empleado del ArrayList
     * @param empleado Empleado a eliminar del ArrayList
     */
    public static void borrarEmpleado(Empleado empleado) {
        System.out.println("\tEl empleado " + empleado.getNombre() + "se ha borrado.");
        EmpresaTest.e.remove(empleado);
    }
    
    /**
     * Metodo para modificar los datos de un empleado
     * @param empleado Empleado a modificar sus datos
     */
    static void modificarEmpleado(Empleado empleado) {
        System.out.println("\tIntroduce los datos del empleado.");
        Scanner sc = new Scanner(System.in);
        System.out.print("\tIntroduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("\tIntroduce el sexo: ");
        char sexo = sc.nextLine().charAt(0);
        System.out.print("\tIntroduce la fecha de contratacion (dia, mes, año): ");
        Fecha fechaCon = new Fecha(sc.nextInt(), sc.nextInt(), sc.nextInt());
        System.out.print("\tIntroduce el sueldo: ");
        double sueldo = (double) sc.nextInt();
        int i = EmpresaTest.e.indexOf(empleado);
        EmpresaTest.e.set(i, new Empleado(nombre, sexo, fechaCon, sueldo));
    }
    /**
     * Metodo para aumentar el sueldo de un empleado 
     * @param empleado Empleado a aumentarle el sueldo
     */
    static void subirSueldo(Empleado empleado) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\tIntroduce la cantidad a sumar al sueldo.");
        int aumento = sc.nextInt();
        if (empleado instanceof Jefe) {
            System.out.println("\tNo se puede subir el sueldo a un jefe.");
        } else {
            empleado.setSueldo(empleado.getSueldo() + aumento);
            System.out.println("\tEl nuevo sueldo de " + empleado.getNombre() + " es " + empleado.getSueldo() + "€");
        }
    }

    /**
     * Metodo para buscar un empleado dentro del ArrayList
     * @return
     */
    public static Empleado buscarEmpleado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\tIntroduce el nombre del empleado a realizar la operación.");
        String nombre = sc.nextLine();
        Empleado empleado = null;
        while (empleado == null) {
            for (Empleado e : EmpresaTest.e) {
                if (e.getNombre().equals(nombre)) {
                    empleado = e;
                }
            }
            if (empleado == null) {
                System.out.println("Empleado no encontrado, por favor introduce otro nombre.");
                nombre = sc.nextLine();
            }
        }
        return empleado;
    }
}
