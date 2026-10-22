package facultad;

import plan.PlanEstudios; //Permite usar la clase planEstudio que esta en otro paquete
import java.util.ArrayList;

/**
 * Facultad que AGREGA planes de estudio.
 */
public class Facultad {

    private String nombre;
    //Relacion de agregacion: el atributo planes es una lista que guarda varios objetos de tipo PlanEstudios, pero la facultad no es responsable de crearlos ni destruirlos.
    private ArrayList<PlanEstudios> planes;

    public Facultad(String nombre) {
        this.nombre = nombre;
        this.planes = new ArrayList<>();
    }

    /** Agrega un plan ya existente (agregación). */
    public void agregarPlan(PlanEstudios plan) {
        //AÑADIDO
        planes.add(plan);
    }

    /**
     * Total de cursos de todos los planes de la facultad.
     */
    public int totalCursos() {
        //AÑADIDO
        int total = 0;
        for (PlanEstudios plan : planes) {
            total += plan.getCursos().size();
        }
        return total;
    }

    public String getNombre() { return nombre; }
    public ArrayList<PlanEstudios> getPlanes() { return planes; }

    //AÑADIDO
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPlanes(ArrayList<PlanEstudios> planes) {
        this.planes = planes;
    }
}