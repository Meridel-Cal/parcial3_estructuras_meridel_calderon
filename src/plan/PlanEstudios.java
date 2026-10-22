package plan;

import cursos.*;
import java.util.ArrayList;

/**
 * Plan de estudios que COMPONE cursos.
 * Los cursos se crean dentro del constructor (composición real).
 */
public class PlanEstudios {

    private String nombre;
    private ArrayList<Curso> cursos;

    public PlanEstudios(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();

        //AÑADIDO
        //Relacion de composicion: el plan crea sus cursos y los agrega a su lista interna
        agregarCurso(new CursoObligatorio("MAT101", "Matemáticas I", 4));
        agregarCurso(new CursoElectivo("ART201", "Historia del Arte", 3));
        agregarCurso(new CursoNivelatorio("ING001", "Inglés Básico", 2));

    }

    /**
     * Método privado para agregar cursos desde el propio constructor.
     * Solo el plan puede crear sus cursos (composición).
     */
    private void agregarCurso(Curso curso) {
        //AÑADIDO
        //Relacion de composicion: se añade esos objetos a la lista interna
        cursos.add(curso);
    }

    /**
     * Promedio de dificultad de todos los cursos del plan.
     * Retorna 0 si el plan no tiene cursos.
     */
    public double dificultadPromedio() {
        //AÑADIDO
        if (cursos.isEmpty()) {
            return 0;
        }
        double suma = 0;
        for (Curso curso : cursos) {
            suma += curso.dificultadEsperada();
        }
        return suma / cursos.size();
    }

    public String getNombre() { return nombre; }
    public ArrayList<Curso> getCursos() { return cursos; }

    //AÑADIDO

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }
}