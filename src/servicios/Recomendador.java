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
     *   - Si el promedio es >= 4.0, recomendar cursos electivos.
     *   - Si el promedio es < 4.0, recomendar cursos nivelatorios.
     * La lista puede estar vacía si no hay cursos disponibles.
     */

    public List<Curso> recomendar(HistorialAcademico historial) {

        List<Curso> recomendaciones = new ArrayList<>();
        double promedio = historial.promedio();

        if (promedio >= 4.0) {
            recomendaciones.add(new CursoElectivo("ELEC001", "Electivo 1", 3));
            recomendaciones.add(new CursoElectivo("ELEC002", "Electivo 2", 3));
        }
        else {
            recomendaciones.add(new CursoNivelatorio("NIV001", "Nivelatorio 1", 2));
            recomendaciones.add(new CursoNivelatorio("NIV002", "Nivelatorio 2", 2));
        }


        return recomendaciones;

    }
}