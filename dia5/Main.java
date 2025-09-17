package dia5;

public class Main {

    public static void main(String[] args) {
        Asignatura matematica = new Asignatura("Matematica");
        Asignatura literatura = new Asignatura("Literatura");
        Asignatura geografia = new Asignatura("Geografía");
        Asignatura ingles = new Asignatura("Inglés");
        Asignatura programacion = new Asignatura("Programación");
        Asignatura biologia = new Asignatura("Biología");

        Alumno alumno1 = new Alumno("Juan Pablo", 28);
        Alumno alumno2 = new Alumno("Sebastian Mazo", 18);

        alumno1.inscribirAsignatura(matematica, 4.5);
        alumno1.inscribirAsignatura(programacion, 5);
        alumno1.inscribirAsignatura(biologia, 3.8);
        alumno1.inscribirAsignatura(literatura, 3.4);

        alumno2.inscribirAsignatura(geografia, 3.8);
        alumno2.inscribirAsignatura(ingles, 3.3);
        alumno2.inscribirAsignatura(programacion, 4.8);

        System.out.println(alumno1.calcularPromedio());
    }
}
