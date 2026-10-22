package servicios;

import cursos.Curso;
import cursos.CursoElectivo;
import cursos.CursoNivelatorio;
import java.util.ArrayList;
import java.util.List;

/**
 * Recomendador que DEPENDE de HistorialAcademico.
 * Se pasa el historial como parámetro (no se guarda como atributo).
 */
public class Recomendador {

    /**
     * Recibe un HistorialAcademico y retorna una lista de cursos recomendados.
     * Regla sugerida:
     *   - Si el promedio es >= 4.0, recomienda los cursos electivos inscritos.
     *   - Si el promedio es < 4.0, recomienda los cursos nivelatorios inscritos.
     * La lista queda vacía si no hay cursos inscritos del tipo correspondiente.
     */

    //Relacion de dependencia: Recomendador usa historial como parametro, pero no lo guarda como atributo. Lo usa cuando
    // lo necesita para recomendar cursos. Por eso es una relación de dependencia.
    public List<Curso> recomendar(HistorialAcademico historial) {

        //AÑADIDO
        List<Curso> recomendaciones = new ArrayList<>();
        double promedio = historial.promedio();

        //Instanceof: se usa verificar que curso es un cursoElectivo
        for (Curso curso : historial.getEstudiante().getInscritos()) {
            if (promedio >= 4.0 && curso instanceof CursoElectivo) {
                recomendaciones.add(curso);
            } else if (promedio < 4.0 && curso instanceof CursoNivelatorio) {
                recomendaciones.add(curso);
            }
        }

        return recomendaciones;
    }
}