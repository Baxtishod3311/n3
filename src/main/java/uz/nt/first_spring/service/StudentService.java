package uz.nt.first_spring.service;

import org.springframework.stereotype.Service;
import uz.nt.first_spring.dato.ResponseDto;
import uz.nt.first_spring.dato.StudentDto;

import java.util.List;
@Service
public interface StudentService {
    ResponseDto addStudent (StudentDto studentDto);
    List <StudentDto> getStudents();
    ResponseDto updateStudent(StudentDto studentDto);
    ResponseDto deleteStudent(Integer id);

}
