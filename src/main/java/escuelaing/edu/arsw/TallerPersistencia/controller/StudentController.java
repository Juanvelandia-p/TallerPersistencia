package escuelaing.edu.arsw.TallerPersistencia.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import escuelaing.edu.arsw.TallerPersistencia.model.Student;
import escuelaing.edu.arsw.TallerPersistencia.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        List<Student>students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PostMapping
    public ResponseEntity<Student> addNewStudent(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam LocalDate birthday,
        @RequestParam String program) {
        Student student = studentService.addStudent(name, email, birthday, program);
        return ResponseEntity.ok(student);
    }
    
}
