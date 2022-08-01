package uz.nt.first_spring.dato;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {
    private Integer id;
    private String name;
    private String authorName;
    private Double price;
}
