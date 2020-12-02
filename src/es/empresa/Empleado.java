package es.empresa;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * Representa un empleado de la empresa
 *
 * @author Alejandro Pina
 */
public class Empleado extends Persona {

    private String nss;
    private Fecha fechaCon;
    private double sueldo;
    private Estado estado;
    private String nombreEmpresa;
    private static int contadorEmple = 0;

    /**
     * Crea un empleado a partir de su nombre, sexo, fecha de contrato y sueldo
     *
     * @param nombre El nombre del empleado
     * @param sexo El sexo de empleado en tipo char
     * @param fechaCon Fecha del contrato
     * @param sueldo el sueldo bruto
     */
    public Empleado(String nombre, char sexo, Fecha fechaCon, double sueldo) {
        super(nombre, sexo);
        this.fechaCon = fechaCon;
        this.sueldo = sueldo;
        contadorEmple++;
    }

    /**
     * Obtiene el número de seguridad social
     *
     * @return el número de la Seguridad Social
     */
    public String getNss() {
        return nss;
    }

    /**
     * Obtiene la fecha de contratación
     *
     * @return la fecha de contratación
     */
    public Fecha getFechaCon() {
        return fechaCon;
    }

    /**
     * Obtiene el sueldo del empleado
     *
     * @return el sueldo del empleado
     */
    public double getSueldo() {
        return sueldo;
    }

    /**
     * Establece la fecha de contratación
     *
     * @param fechaCon La fecha de contratación
     */
    public void setFechaCon(Fecha fechaCon) {
        this.fechaCon = fechaCon;
    }

    /**
     * Establece el sueldo
     *
     * @param sueldo El sueldo del empleado
     */
    public void setSueldo(double sueldo) {
        if (sueldo > 5000 || sueldo < 500) {
            System.out.println("El sueldo no puede ser mayor de 5.000 o menor de 500");
            this.sueldo = 501;
        } else {
            this.sueldo = sueldo;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + Objects.hashCode(this.fechaCon);
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.sueldo) ^ (Double.doubleToLongBits(this.sueldo) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;

        if (!this.getNombre().equals(other.getNombre())) {
            return false;
        }
        if (this.sueldo != other.sueldo) {
            return false;
        }
        if (!this.fechaCon.equals(other.fechaCon)) {
            return false;
        }
        return true;
    }

    /**
     * Para obtener la representación del empleado
     *
     * @return un String descriptivo de este empleado
     */
    @Override
    public String toString() {
        return super.toString() + this.fechaCon + ", "
                + NumberFormat.getCurrencyInstance().format((double) sueldo);
    }
}
