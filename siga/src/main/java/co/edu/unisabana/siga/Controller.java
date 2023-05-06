package co.edu.unisabana.siga;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    List<Estudiante> estudianteList = new ArrayList<>();

    public Controller() {
        this.estudianteList = new ArrayList<>();
        estudianteList.add(new Estudiante("Santiago", 2525, 3, "femenino"));
        estudianteList.add(new Estudiante("xoxo", 2452, 3, "Masculino"));
        estudianteList.add(new Estudiante("caca", 4132, 3, "Masculino"));
        estudianteList.add(new Estudiante("fsagv", 1522, 3, "Masculino"));
        estudianteList.add(new Estudiante("afas", 8994, 4, "Masculino"));
    }

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

    @GetMapping(path = "/estudiante/{codigo}")
    public Estudiante obtenerEstudianteporCodigo(@PathVariable int codigo) {
        for (Estudiante estudiante : estudianteList) {
            if (estudiante.getCodigo() == codigo) {
                return estudiante;
            }
        }
        return new Estudiante();
    }

    @PostMapping(path = "/estudiante/agregar")
    public String agregarEstudiante(@RequestBody Estudiante estudiante) {
        estudiante.setCodigo((int) (Math.random() * 1000));
        estudianteList.add(estudiante);
        return "Estudiante ingresado correctamente";
    }

    @GetMapping(path = "/estudiante/actualizar/{codigo}")
    public void actualizarEstudiante(@PathVariable int codigo, @RequestBody Estudiante estudiante) {
        for (Estudiante estudiante2 : estudianteList) {
            if (estudiante2.getCodigo()== codigo) {
                estudiante2.setFacultad(estudiante.getFacultad());
                estudiante2.setNombre(estudiante.getNombre());
                estudiante2.setSemestre(estudiante.getSemestre());
            }
        }

    }
}
