package cursos;

/**
 * Curso nivelatorio. Dificultad base baja.
 */
public class CursoNivelatorio extends Curso {

    public CursoNivelatorio(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
    }

    @Override
    public double dificultadEsperada() {
        //AÑADIDO
        return 0.5 * getCreditos();
    }
}