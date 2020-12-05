package es.empresa;

/**
 * Clase abstracta con los datos de una persona
 * @author Alejandro Pina
 */
public abstract class Persona {
    private final String nombre;
    private final char sexo;
    private String dni;
    private Fecha fechaNac;
    
    /**
     * Crea una persona a partir de su nombre y sexo
     * @param nombre Nombre de la persona
     * @param sexo Sexo de la persona
     */
    public Persona(String nombre, char sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }
    
    /**
     * Crea una persona a partir de su nombre, sexo, dni y fecha de nacimiento
     * @param nombre Nombre de la persona
     * @param sexo Sexo de la persona
     * @param dni DNI de la persona
     * @param fechaNac Fecha de nacimiento de la persona
     */
    public Persona(String nombre, char sexo, String dni, Fecha fechaNac) {
        this(nombre, sexo);
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    /**
     * Obtiene el nombre
     * @return El nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Obtiene el sexo
     * @return El sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Obtiene el DNI
     * @return El DNI
     */
    public String getDni() {
        return dni;
    }

    /**
     * Obtiene la fecha de nacimiento
     * @return La fecha de nacimiento
     */
    public Fecha getFechaNac() {
        return fechaNac;
    }

    @Override
    public String toString() {
        return nombre + ", " + sexo + ", ";
    }
    
}
