package uz.nt.first_spring.controller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt.first_spring.dato.AuthorDto;
import uz.nt.first_spring.dato.ResponseDto;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Author")

public class AuthorController {
    private List<AuthorDto> authors = new ArrayList<>();

    @GetMapping
    public List<AuthorDto> getAuthor(@RequestParam Integer id){
        return authors;
    }


    @PatchMapping
    public ResponseDto updateAuthor(@RequestBody AuthorDto authorDto) {
        for (AuthorDto a : authors) {
            if (a.getId().equals(authorDto.getId())) {
                if (authorDto.getFirst_name() != null) a.setFirst_name(authorDto.getFirst_name());
                if (authorDto.getLast_name() != null) a.setLast_name(authorDto.getLast_name());
                if (authorDto.getBirth_date() != null) a.setBirth_date(authorDto.getBirth_date());

                return ResponseDto.builder().code(1).success(true).message("Successfully updated").build();
            }
        }
        return ResponseDto.builder().code(-1).success(false).message("Not Found").build();
    }
}