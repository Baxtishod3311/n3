package uz.nt.first_spring.controller;

import org.springframework.web.bind.annotation.*;
import uz.nt.first_spring.dato.BookDto;
import uz.nt.first_spring.dato.ResponseDto;
import uz.nt.first_spring.model.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@RestController
@RequestMapping("/Book")
public class BookController {
    private List<Book> books = new ArrayList<>(List.of(
            new Book(  3,"Molxona", "Jorj Oruel", 39000.0),
            new Book( 2,  "1984","Jorj Oruel",  35000.0),
            new Book( 1, "Atom odatlar",  "Jeyms Klir",  45000.0)));
    @GetMapping
    public BookDto getById(@RequestParam Integer id) {
        for (Book b : books) {
            if (b.getId() == id) {
                return new BookDto( b.getId(),b.getName(), b.getAuthorName(), b.getPrice());
            }
        }
        return null;
    }
       @PatchMapping
            public ResponseDto updateBook(@RequestBody BookDto bookDto) {
           for (Book b : books) {
               if (b.getId().equals(bookDto.getId())) {
                   if (bookDto.getName() != null) b.setName(bookDto.getName());
                   if (bookDto.getAuthorName() != null) b.setAuthorName(bookDto.getAuthorName());
                   if (bookDto.getPrice() !=null)b.setPrice(bookDto.getPrice());

                   return ResponseDto.builder().code(1).success(true).message("successfully update").build();
               }
           }
           return ResponseDto.builder().code(-1).success(false).message("Not Found").build();
       }

       }