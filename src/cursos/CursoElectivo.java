package cursos;
/**
 * Curso electivo. Dificultad base media.
 */
public class CursoElectivo extends Curso {

    public CursoElectivo(String codigo, String nombre, int creditos) {
        super(codigo, nombre, creditos);
    }

    @Override
    public double dificultadEsperada() {
        //AÑADIDO
        return 1.0 * getCreditos();
    }
}