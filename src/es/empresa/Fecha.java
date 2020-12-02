package es.empresa;

/**
 * Clase inmutable que almacena la fecha de nacimiento o de contrato
 * @since 2020
 * @version 1.1
 * @author Alejandro Pina
 */
public final class Fecha {
    private final int DIA;
    private final int MES;
    private final int ANIO;

    /**
     * Crea una Fecha a partir de otra existente
     * @param fecha Objeto de la clase Fecha
     */
    public Fecha(Fecha fecha){
        this(fecha.DIA, fecha.MES, fecha.ANIO);
    }
    /**
     * Crea una fecha a partir de tres enteros: día, MES y año
     * @param DIA representa el día del MES
     * @param MES representa el MES del año
     * @param ANIO representa el ANIO de una fecha
     */
    public Fecha(final int DIA, final int MES, final int ANIO) {
        this.DIA = DIA;
        this.MES = MES;
        this.ANIO = ANIO;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.DIA;
        hash = 47 * hash + this.MES;
        hash = 47 * hash + this.ANIO;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fecha other = (Fecha) obj;
        if (this.DIA != other.DIA) {
            return false;
        }
        if (this.MES != other.MES) {
            return false;
        }
        if (this.ANIO != other.ANIO) {
            return false;
        }
        return true;
    }
    /**
     * Devuelve una fecha
     * @return la cadena de texto de una fecha
     */
    @Override
    public String toString() {
        return DIA + "-" + MES + "-" + ANIO;
    }
}
