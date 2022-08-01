package uz.nt.first_spring.dato;

import lombok.Data;

@Data
public class StudentDto {
    private Integer id;
    private Integer age;
    private String name;     
    private String birthDate;
    private String course;


}
