package co.edu.unisabana.siga;
import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    List<Estudiante> estudianteList=new ArrayList<>();

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
