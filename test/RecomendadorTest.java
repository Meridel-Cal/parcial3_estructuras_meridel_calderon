import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import cursos.*;
import java.util.List;
import personas.Estudiante;
import servicios.HistorialAcademico;
import servicios.Recomendador;

public class RecomendadorTest {

    @Test
    void historialReflejaDatosDelEstudiante() {
        Estudiante e = new Estudiante("Ana", 5);
        e.registrarNota(4);
        e.registrarNota(5);
        e.inscribirCurso(new CursoObligatorio("OBL", "X", 4));
        HistorialAcademico h = new HistorialAcademico(e);
        assertEquals(4.5, h.promedio(), 0.01);
        assertEquals(1, h.cantidadCursos());
    }

    @Test
    void recomendarConBuenPromedioSugiereElectivos() {
        Estudiante e = new Estudiante("Ana", 5);
        e.registrarNota(5);
        e.registrarNota(5);
        Curso electivo = new CursoElectivo("ELE1", "IA", 4);
        e.inscribirCurso(electivo);
        e.inscribirCurso(new CursoNivelatorio("NIV1", "Intro", 2));

        HistorialAcademico h = new HistorialAcademico(e);
        Recomendador r = new Recomendador();
        List<Curso> sugerencias = r.recomendar(h);

        assertEquals(List.of(electivo), sugerencias);
    }

    @Test
    void recomendarConBajoPromedioSugiereNivelatorios() {
        Estudiante e = new Estudiante("Ana", 5);
        e.registrarNota(2);
        e.registrarNota(3);
        Curso nivelatorio = new CursoNivelatorio("NIV1", "Intro", 2);
        e.inscribirCurso(nivelatorio);
        e.inscribirCurso(new CursoElectivo("ELE1", "IA", 4));

        HistorialAcademico h = new HistorialAcademico(e);
        Recomendador r = new Recomendador();
        List<Curso> sugerencias = r.recomendar(h);

        assertEquals(List.of(nivelatorio), sugerencias);
    }

    @Test
    void recomendarRetornaListaVaciaSiNoHayCursosDelTipoCorrespondiente() {
        Estudiante buenPromedio = new Estudiante("Ana", 5);
        buenPromedio.registrarNota(5);
        buenPromedio.inscribirCurso(new CursoNivelatorio("NIV1", "Intro", 2));

        Estudiante bajoPromedio = new Estudiante("Luis", 5);
        bajoPromedio.registrarNota(2);
        bajoPromedio.inscribirCurso(new CursoElectivo("ELE1", "IA", 4));

        Recomendador recomendador = new Recomendador();
        List<Curso> sugerenciasBuenPromedio =
            recomendador.recomendar(new HistorialAcademico(buenPromedio));
        List<Curso> sugerenciasBajoPromedio =
            recomendador.recomendar(new HistorialAcademico(bajoPromedio));

        assertNotNull(sugerenciasBuenPromedio);
        assertTrue(sugerenciasBuenPromedio.isEmpty());
        assertNotNull(sugerenciasBajoPromedio);
        assertTrue(sugerenciasBajoPromedio.isEmpty());
    }
}