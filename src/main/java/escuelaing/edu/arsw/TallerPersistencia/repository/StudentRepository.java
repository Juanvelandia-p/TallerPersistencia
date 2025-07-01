package escuelaing.edu.arsw.TallerPersistencia.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import escuelaing.edu.arsw.TallerPersistencia.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
    // This interface will automatically provide CRUD operations for the Student entity
    // No additional methods are needed unless specific queries are required

    
}
