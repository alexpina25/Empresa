package es.empresa;

/**
 * Extiende de Empleado y añade más atributos
 * @author Alejandro Pina
 */
public class Jefe extends Empleado {
    private String departamento;
    private int numSubordinados;
    
    /**
     * Crea un jefe a partir de su nombre, sexo, fecha de contratación, sueldo y departamento
     * @param nombre Nombre del jefe
     * @param sexo Sexo del jefe
     * @param fechaCon Fecha de contratación del jefe
     * @param sueldo Sueldo del jefe
     * @param departamento Departamento del jefe
     */
    public Jefe(String nombre, char sexo, Fecha fechaCon, double sueldo, String departamento) {
        super(nombre, sexo, fechaCon, sueldo);
        this.departamento = departamento;
    }

    /**
     * Obtiene el departamento
     * @return El nombre del departamento
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Establece el departamento
     * @param departamento Nombre del departamento
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Obtiene el numero de subordinados
     * @return El numero de subordinados
     */
    public int getNumSubordinados() {
        return numSubordinados;
    }

    /**
     * Establece el numero de subordinados
     * @param numSubordinados El numero de subordinados
     */
    public void setNumSubordinados(int numSubordinados) {
        this.numSubordinados = numSubordinados;
    }
    
    /**
     * Metodo para subir el sueldo a un empleado
     * @param empleado Empleado a subir el sueldo
     * @param incremento Numero a sumar al sueldo
     */
    public void subirSueldo(final Empleado empleado, double incremento){
        empleado.setSueldo(empleado.getSueldo() + incremento);
    }

    /**
     * Para obtener la representación del jefe
     * @return un String descriptivo de este jefe
     */
    @Override
    public String toString() {
        return super.toString() + ", " + departamento ;
    }
}
