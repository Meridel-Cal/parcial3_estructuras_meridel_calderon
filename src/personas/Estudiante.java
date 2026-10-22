package personas;

import cursos.Curso;//Permite usar el paqute de cursos
import java.util.ArrayList;

/**
 * Estudiante con notas en un arreglo de capacidad fija (int[])
 * y cursos inscritos en un ArrayList (asociación N:M con Curso).
 */
public class Estudiante {

    private String nombre;
    private int[] notas;
    private int contadorNotas;
    //Relacion de asociacion
    private ArrayList<Curso> inscritos;

    //Constructor
    public Estudiante(String nombre, int maxNotas) {
        this.nombre = nombre;
        this.notas = new int[maxNotas]; //Crea el arreglo de notas con la capacidad maxima de notas que el envie como parametro
        this.contadorNotas = 0;
        this.inscritos = new ArrayList<>(); //Crea el ArrayList de cursos inscritos
    }

    /**
     * Registra una nota. Si el arreglo está lleno, no se registra.
     */
    public void registrarNota(int nota) {
        //AÑADIDO
        if (contadorNotas < notas.length) { //Si el arreglo de notas tiene todavia espacio, añade la nota y al contador sumale 1
            notas[contadorNotas] = nota;
            contadorNotas++;
        }
    }

    /**
     * Promedio de las notas registradas. Retorna 0 si no hay notas.
     */
    public double promedio() {
        //AÑADIDO
        if (contadorNotas == 0) {
            return 0;
        }
        int suma = 0;
        for (int i = 0; i < contadorNotas; i++) {
            suma += notas[i];
        }
        return (double) suma / contadorNotas; //Convierte la suma de enteros a dobles
    }

    /** Asocia al estudiante con un curso (no lo crea). */
    public void inscribirCurso(Curso curso) {
        //AÑADIDO
        if (!inscritos.contains(curso)) { //Se verifica que el curso no este en la lista
            inscritos.add(curso);
        }
    }

    public String getNombre() { return nombre; }
    public int[] getNotas() { return notas; }
    public int getContadorNotas() { return contadorNotas; }
    public ArrayList<Curso> getInscritos() { return inscritos; }

    //AÑADIDO
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setNotas(int[] notas) { this.notas = notas; }
    public void setContadorNotas(int contadorNotas) { this.contadorNotas = contadorNotas; }
    public void setInscritos(ArrayList<Curso> inscritos) { this.inscritos = inscritos; }
}