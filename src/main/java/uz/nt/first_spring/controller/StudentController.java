package uz.nt.first_spring.controller;

import org.springframework.web.bind. annotation.*;
import uz.nt.first_spring.dato.ResponseDto;
import uz.nt.first_spring.dato.StudentDto;
import uz.nt.first_spring.service.StudentService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/student" )
public class StudentController {

private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseDto addStudent(@RequestBody StudentDto studentDto) {
        return studentService.addStudent(studentDto);
    }

    @GetMapping
    public List<StudentDto> getStudents() {
        return studentService.getStudents();
    }

    //Patch - Put
    @PatchMapping
    public ResponseDto updateStudent(@RequestBody StudentDto studentDto) {
    return studentService.updateStudent(studentDto);
    }
    @DeleteMapping
    public ResponseDto deleteStudent(@RequestBody Integer id){
        return studentService.deleteStudent(id);
    }
}