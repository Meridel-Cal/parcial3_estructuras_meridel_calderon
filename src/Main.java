import cursos.*;
import facultad.Facultad;
import personas.Estudiante;
import plan.PlanEstudios;
import servicios.HistorialAcademico;
import servicios.Recomendador;

/**
 * Escenario demostrativo — TODO estudiante: completar para evidenciar
 * el funcionamiento integral del sistema.
 */
public class Main {

    public static void main(String[] args) {
        // Composición: el plan crea sus cursos internamente
        PlanEstudios plan = new PlanEstudios("Ing. Datos e IA");

        // Agregación: la facultad agrega planes
        Facultad facultad = new Facultad("Ingeniería");
        facultad.agregarPlan(plan);

        // Estudiante con arreglo de notas (int[])
        Estudiante est = new Estudiante("Ana", 5);
        est.registrarNota(4);
        est.registrarNota(5);
        est.registrarNota(3);

        // Asociación: el estudiante se inscribe en cursos del plan
        for (Curso c : plan.getCursos()) {
            est.inscribirCurso(c);
        }

        // Dependencia: el recomendador usa el historial
        HistorialAcademico hist = new HistorialAcademico(est);
        Recomendador rec = new Recomendador();

        System.out.println("Plan: " + plan.getNombre());
        System.out.println("Cursos del plan:");
        plan.getCursos().forEach(c ->
            System.out.println("  - " + c.getCodigo() + ": " + c.getNombre()));

        System.out.println("Promedio de " + est.getNombre() + ": " + est.promedio());
        System.out.println("Cursos inscritos por " + est.getNombre() + ": " + hist.cantidadCursos());
        System.out.println("Dificultad promedio del plan: " + plan.dificultadPromedio());
        System.out.println("Total de cursos de la facultad: " + facultad.totalCursos());

        System.out.println("Recomendaciones:");
        rec.recomendar(hist).forEach(c ->
            System.out.println("  * " + c.getNombre()));

        // Se demuestra también la recomendación para un promedio menor a 4.0
        Estudiante estBajoPromedio = new Estudiante("Luis", 5);
        estBajoPromedio.registrarNota(2);
        estBajoPromedio.registrarNota(3);
        for (Curso c : plan.getCursos()) {
            estBajoPromedio.inscribirCurso(c);
        }

        HistorialAcademico histBajoPromedio = new HistorialAcademico(estBajoPromedio);
        System.out.println("Promedio de " + estBajoPromedio.getNombre() + ": "
            + histBajoPromedio.promedio());
        System.out.println("Recomendaciones para " + estBajoPromedio.getNombre() + ":");
        rec.recomendar(histBajoPromedio).forEach(c ->
            System.out.println("  * " + c.getNombre()));
    }
}