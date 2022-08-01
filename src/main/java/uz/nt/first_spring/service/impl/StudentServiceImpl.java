package uz.nt.first_spring.service.impl;

import org.springframework.stereotype.Service;
import uz.nt.first_spring.dato.ResponseDto;
import uz.nt.first_spring.dato.StudentDto;
import uz.nt.first_spring.service.StudentService;


import java.util.ArrayList;
import java.util.List;

@Service
   public class StudentServiceImpl implements StudentService {
    public static List<StudentDto> students = new ArrayList<>();
    @Override
    public ResponseDto addStudent(StudentDto studentDto) {
        students.add(studentDto);
        return ResponseDto.builder()
                .code(0)
                .success(true)
                .message("Successfully saved!")
                .build();
    }

    @Override
    public List<StudentDto> getStudents() {
        return students;
    }

    @Override
    public ResponseDto updateStudent(StudentDto studentDto) {
        for (StudentDto s : students) {
            if (s.getId().equals(studentDto.getId())) {
                if (studentDto.getName() != null) s.setName(studentDto.getName());
                if (studentDto.getAge() != null) s.setAge(studentDto.getAge());
                if (studentDto.getCourse() != null) s.setCourse(studentDto.getCourse());
                if (studentDto.getBirthDate() != null) s.setBirthDate(studentDto.getBirthDate());
                return ResponseDto.builder()
                        .code(0)
                        .success(true)
                        .message("Successfully updated!")
                        .build();
            }
        }
        return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("Data not found!")
                .build();
    }


    @Override
    public ResponseDto deleteStudent(Integer id) {
        for (StudentDto s: students){
            if(s.getId().equals(id)){
                students.remove(s);
              return ResponseDto.builder()
                        .code(0)
                        .success(true)
                        .message("Successfully delete!")
                        .build();
            }
        }
       return ResponseDto.builder()
                .code(-1)
                .success(false)
                .message("Not Found")
                .build();
    }
}
