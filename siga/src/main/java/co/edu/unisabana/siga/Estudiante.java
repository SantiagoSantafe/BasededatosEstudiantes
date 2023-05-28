package co.edu.unisabana.siga;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {

    @NotBlank
    @NotEmpty (message = "Ingrese un valor para el nombre")
    @NotNull(message = "Mande el campooo!!!!!!!") //Validaciones
    @Size(min = 2,max = 30) //Validacion del tamaño del String
    private String nombre;
    private int codigo;


    @NotNull(message = "Mande el campooo!!!!!!!")
    @Min(1) //Validaciones de minimo tantos digitos.
    @Max(12)
    private int semestre;
    private Enum<FacultadEnum> facultad; //Este solo permite una sarie de datos. Los que estab dentro del enum
    private String genero;
    private String programa;


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

}
