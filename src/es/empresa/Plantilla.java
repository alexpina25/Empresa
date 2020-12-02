package es.empresa;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase de utilidades para empleados con métodos estáticos
 *
 * @author Alejandro Pina
 */
public class Plantilla{
    public static void crearEmpleados() {
        EmpresaTest.e.add(new Empleado("Ana", 'M', new Fecha(14, 10, 2015), 1000));
        EmpresaTest.e.add(new Jefe("Alfonso", 'H', new Fecha(10, 2, 2000), 1200, "rrhh"));
        EmpresaTest.e.add(new Empleado("Benito", 'H', new Fecha(1, 6, 2014), 1250));
        EmpresaTest.e.add(new Jefe("Mónica", 'M', new Fecha(8, 4, 2012), 1300, "contabilidad"));
        EmpresaTest.e.add(new Empleado("Alfredo", 'H', new Fecha(1, 10, 2010), 995.20));
        EmpresaTest.e.add(new Empleado("Antonio", 'H', new Fecha(14, 5, 2010), 970.5));
        EmpresaTest.e.add(new Empleado("Montserrat", 'M', new Fecha(18, 1, 2010), 1095.21));
        EmpresaTest.e.add(new Empleado("Julián", 'H', new Fecha(8, 6, 2011), 1200.46));
    }

    /**
     * Suma y devuelve el total de sueldos de toda la plantilla de empleados
     *
     * @param e
     * @return La suma de sueldos
     */
    public static double totalizarSueldos(ArrayList<Empleado> e) {
        double sumaSueldos = 0;
        for (int i = 0; i < e.size(); i++) {
            sumaSueldos += e.get(i).getSueldo();
        }
        return sumaSueldos;
    }

    public static void descontarPorcentaje() {
        // 1.) Seleccionar un empleado de la lista (array)
        // 2.) Llamar al método descontarPorcentaje con el dado
        Empleado empleado = new Empleado("X", 'Z', new Fecha(10, 10, 10), 500);
        descontarPorcentaje(empleado); // Llama al método de abajo (sobrecargado)
    }

    /**
     * Descuenta un porcentaje al sueldo según sea empleado o jefe
     *
     * @param empleado Empleado a descontar el porcentaje
     */
    public static void descontarPorcentaje(final Empleado empleado) {
        if (empleado instanceof Jefe) {
            empleado.setSueldo(empleado.getSueldo() * 0.95);
        } else if (empleado instanceof Empleado) {
            empleado.setSueldo(empleado.getSueldo() * 0.90);
        }
    }

    /**
     * Añade un nuevo empleado
     */
    public static void altaEmpleado() {
        System.out.println("Escribe el tipo de empleado que quieres dar de alta (jefe o empleado)");
        Scanner sc = new Scanner(System.in);
        String opcion = sc.nextLine();

        switch (opcion.toLowerCase()) {
            case "jefe":
                System.out.print("Introduce el nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce el sexo: ");
                char sexo = sc.nextLine().charAt(0);
                System.out.print("Introduce la fecha de contratacion (dia, mes, año): ");
                Fecha fechaCon = new Fecha(sc.nextInt(), sc.nextInt(), sc.nextInt());
                System.out.print("Introduce el sueldo: ");
                double sueldo = (double)sc.nextInt();
                System.out.print("Introduce el departamento: ");
                String departamento = sc.nextLine();
                EmpresaTest.e.add(new Jefe(nombre, sexo, fechaCon, sueldo, departamento));
                break;
            case "empleado":

                break;
            default:
                throw new AssertionError("");
        }
    }

    public static void listarEmpleados() {
        EmpresaTest.e.forEach(empleado -> System.out.println(empleado));
    }

    public static void subirSueldo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void borrarEmpleado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
