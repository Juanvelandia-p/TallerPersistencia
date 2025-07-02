package escuelaing.edu.arsw.TallerPersistencia.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private String email;
    private LocalDate birthday;
    private String program;

    // Getters y setters
}
