package cursos;

/**
 * Curso obligatorio. Dificultad base alta.
 */
public class CursoObligatorio extends Curso {

    public CursoObligatorio(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
    }

    @Override
    public double dificultadEsperada() {
        //AÑADIDO
        return 1.5 * getCreditos();
    }
}