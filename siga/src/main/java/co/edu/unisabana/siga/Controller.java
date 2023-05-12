package co.edu.unisabana.siga;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    List<Estudiante> estudianteList = new ArrayList<>();
    @GetMapping(path = "/saludameporfavor")
    public String saludar() {
        return "hola";
    }

    @GetMapping(path = "/estudiantes/todos")
    public List<Estudiante> listaest() {
        return estudianteList;
    }

    @GetMapping(path = "/estudiantes")
    public List<Estudiante> obtenerEstporSemestre(@RequestParam int semestre, @RequestParam String facultad) {
        List<Estudiante> busqueda = new ArrayList<>();
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getSemestre() == semestre && estudiante.getFacultad().equals(facultad)) {
                busqueda.add(estudiante);
            }
        }
        return busqueda;
    }
    @GetMapping(path = "/estudiante/buscar")// con este path se puede buscar un estudiante ingresando su facultad y la cantidad de resultados que quiere hallar
    public List<Estudiante> obtenerEstporFacultad(@RequestParam String facultad, @RequestParam int cantidad_resultados) {
        List<Estudiante> busqueda= new ArrayList<>();
        for (Estudiante estudiante: estudianteList){
            if ( estudiante.getFacultad().equalsIgnoreCase(facultad) && busqueda.size()< cantidad_resultados){
                busqueda.add(estudiante);
            }
        }
        return busqueda;
    }

    @GetMapping(path = "/estudiante/{codigo}")
    public Estudiante obtenerEstudianteporCodigo(@PathVariable int codigo) {
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getCodigo() == codigo) {
                return estudiante;
            }
        }
        return new Estudiante();
    }

    @PostMapping(path = "/estudiante/agregar")// con este path se agrega un estudiante ingresando su nombre, facultad y semestre en el body.
    public String agregarEstudiante(@RequestBody Estudiante estudiante) {
        estudiante.setCodigo((int) (Math.random() * 1000));
        estudianteList.add(estudiante);
        return "Estudiante ingresado correctamente";
    }

    @DeleteMapping(path = "estudiante/eliminar/{codigo}")// con este path se elimina un estudiante ingresando su codigo
    public String eliminarEstudiantePorCodigo(@PathVariable int codigo) {
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getCodigo() == codigo) {
                estudianteList.remove(estudiante);
                return "Se elimino con exito";
            }
        }
        return "No se encontro Estudiante";
    }

    @PutMapping(path = "/estudiante/actualizar/{codigo}") // con este path se puede actualizar un estudiante ingresando su codigo
    public String actualizarEstudiante(@PathVariable int codigo, @RequestBody Estudiante estudiante) {
        for (Estudiante estudiante2 : estudianteList) {
            if (estudiante2.getCodigo() == codigo) {
                estudiante2.setFacultad(estudiante.getFacultad());
                estudiante2.setNombre(estudiante.getNombre());
                estudiante2.setSemestre(estudiante.getSemestre());
                estudiante2.setCodigo(estudiante.getCodigo());
                estudiante2.setGenero(estudiante.getGenero());
                estudiante2.setPrograma(estudiante.getPrograma());
                return "El estudiante ha sido actualizado";
            }
        }
        return "No existe un estudiante con ese codigo";
    }
}
