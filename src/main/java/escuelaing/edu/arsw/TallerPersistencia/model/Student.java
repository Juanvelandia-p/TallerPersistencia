package escuelaing.edu.arsw.TallerPersistencia.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")

public class Student {
    @Id
    private String id;

    private String name;
    private String email;
    private LocalDate  birthday;
    private String program;

}
