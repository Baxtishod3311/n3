package uz.nt.first_spring.dato;

import lombok.Data;

@Data
public class AuthorDto {
    private Integer id;
    private String first_name;
    private String last_name;
    private String birth_date;
}