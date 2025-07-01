package escuelaing.edu.arsw.TallerPersistencia.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import escuelaing.edu.arsw.TallerPersistencia.model.Student;
import escuelaing.edu.arsw.TallerPersistencia.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student addStudent(String name, String email, LocalDate birthday, String program) {
        // Assuming Student is a class with a constructor that matches these parameters
        // You would need to create the Student class accordingly
        Student student = new Student(null, name, email, birthday, program);
        //studentRepository.save(student);
        return studentRepository.save(student);
    }
}
