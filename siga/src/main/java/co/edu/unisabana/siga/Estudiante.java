package co.edu.unisabana.siga;

public class Estudiante {
    private String nombre;
    private int codigo;
    private int semestre;
    private String facultad;
    private String genero;
    private String programa;
    public Estudiante() {
    }
    public Estudiante(String nombre, int codigo, int semestre, String facultad,String genero, String programa) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.semestre = semestre;
        this.facultad = facultad;
        this.genero=genero;
        this.programa=programa;
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
    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
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
    public String getPrograma() {
        return programa;
    }
    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
