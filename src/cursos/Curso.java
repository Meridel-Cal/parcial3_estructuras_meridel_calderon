package cursos; //Agrupa las clases relacionadas con cursos en un solo paquete

/**
 * Clase abstracta que representa un curso del plan de estudios.
 * Cada subclase define su dificultad esperada.
 */
public abstract class Curso {

    private String codigo;
    private String nombre;
    private int creditos;

    //Constructor
    public Curso(String codigo, String nombre, int creditos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    /**
     * Cada subclase implementa cómo se calcula la dificultad esperada
     * del curso según su tipo (polimorfismo).
     */
    public abstract double dificultadEsperada();

    //Encapsulamientos
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
}