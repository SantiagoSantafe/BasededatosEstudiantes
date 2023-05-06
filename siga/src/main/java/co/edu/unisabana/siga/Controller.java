package co.edu.unisabana.siga;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    List<Estudiante> estudianteList=new ArrayList<>();
    
    /*public Controller() {
        this.estudianteList = new ArrayList<>();
        estudianteList.add(new Estudiante("Santiago", 2525, 3, "femenino"));
        estudianteList.add(new Estudiante("xoxo", 2452, 3, "Masculino"));
        estudianteList.add(new Estudiante("caca", 4132, 3, "Masculino"));
        estudianteList.add(new Estudiante("fsagv", 1522, 3, "Masculino"));
        estudianteList.add(new Estudiante("afas", 8994, 4, "Masculino"));
    }*/
    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> listaest() {
        return estudianteList;
    }

    @GetMapping(path = "/estudiantes")
    public List<Estudiante> obtenerEstporSemestre(@RequestParam int semestre, @RequestParam String facultad) {
        List<Estudiante> busqueda= new ArrayList<>();
        for (Estudiante estudiante: estudianteList){
            if (estudiante.getSemestre()== semestre && estudiante.getFacultad().equals(facultad)) {
                busqueda.add(estudiante);
            }
        }
        return busqueda;
    }
    @GetMapping (path = "/estudiante/{codigo}")
    public Estudiante obtenerEstudianteporCodigo(@PathVariable int codigo) {
        for (Estudiante estudiante: estudianteList){
            if (estudiante.getCodigo()== codigo) {
               return estudiante;
            }
        }
        return new Estudiante();
    }
    @PostMapping (path = "/estudiante/crear")
    public String crearEstudiante(@RequestBody Estudiante estudiante) {
        estudiante.setCodigo((int)(Math.random()*1000));
        estudianteList.add(estudiante);
        return "Estudiante ingresado correctamente";
    }
    @DeleteMapping(path = "estudiante/eliminar/{codigo}")
    public String eliminarEstudiantePorCodigo(@PathVariable int codigo){
        for (Estudiante estudiante: estudianteList){
            if (estudiante.getCodigo()==codigo){
                estudianteList.remove(estudiante);
                return "Se elimino con exito";
            }
        }
        return "No se enctro Estudiante";
    }
}
