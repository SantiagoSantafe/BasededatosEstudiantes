package co.edu.unisabana.siga;

public class Estudiante {
    private String nombre;
    private int codigo;
    private int semestre;
    private String facultad;
    
    public Estudiante() {
    }
    public Estudiante(String nombre, int codigo, int semestre, String facultad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
        this.facultad = facultad;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getSemestre() {
        return semestre;
    }
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
    public String getFacultad() {
        return facultad;
    }
    public void setFacultad(String genero) {
        this.facultad = genero;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + codigo;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudiante other = (Estudiante) obj;
        return codigo == other.codigo;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                ", semestre=" + semestre +
                ", facultad='" + facultad + '\'' +
                '}';
    }
}
