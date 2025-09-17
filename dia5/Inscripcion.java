package dia5;

public class Inscripcion {
    private double nota;
    private Asignatura asignatura;

    public Inscripcion(Asignatura asignatura, double nota) {
        this.nota = nota;
        this.asignatura = asignatura;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public boolean estaAprobada() {
        return nota >= 3.5;
    }

    public void imprimirEstado() {
        if (estaAprobada()) {
            System.out.println("Aprobaste");
        } else {
            System.out.println("Reprobaste");
        }
    }
}
