package dia5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Alumno extends Persona{
    Inscripcion[] inscripciones = new Inscripcion[4];

    public Alumno(String nombre, int edad) {
        super(nombre, edad);
    }

    public void inscribirAsignatura(Asignatura asignatura, double nota) {
        for (int i = 0; i < inscripciones.length; i++) {
            if (inscripciones[i] != null &&
                    inscripciones[i].getAsignatura().equals(asignatura)) {
                System.out.println("Error, asignatura actualmente inscripta");
                return;
            }
        }

        for (int j = 0; j < inscripciones.length; j++) {
            if (inscripciones[j] == null) {
                inscripciones[j] = new Inscripcion(asignatura, nota);
                System.out.println("Inscripto correctamente");
                return;
            }
        }
        System.out.println("Error se alcanzó el limite de asignaturas inscriptas");
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion != null) {
                System.out.println("Asignatura: " + inscripcion.getAsignatura().getNombre());
                System.out.println("Nota: " + inscripcion.getNota());
                inscripcion.imprimirEstado();
            }
        }
        System.out.println("El promedio es: " + calcularPromedio());
    }

    public double calcularPromedio() {
        double suma = 0;
        int contador = 0;

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion != null) {
                suma += inscripcion.getNota();
                contador++;
            }
        }
        return contador > 0 ? suma / contador : 0;
    }

}



