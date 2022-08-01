package uz.nt.first_spring.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Tub {
    private List<Integer> lst = new ArrayList<>();

    @GetMapping(" ")
    public List<Integer> tub(@RequestParam Integer n) {
        for (int i = 1; i < n; i++){
            if(tb(i)){
                lst.add(i);
            }

        }
        return lst;
    }

    private boolean tb(Integer a){
        if (a == 1){
            return false;
        }
        for (int i = 2; i < a; i++){
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}