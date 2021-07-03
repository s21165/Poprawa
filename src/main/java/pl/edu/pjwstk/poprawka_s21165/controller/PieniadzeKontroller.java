package pl.edu.pjwstk.poprawka_s21165.controller;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.poprawka_s21165.entity.Pieniadze;
import pl.edu.pjwstk.poprawka_s21165.service.SerwisWalut;

import java.util.List;

@RestController
@RequestMapping("")
public class PieniadzeKontroller {

    private final SerwisWalut serwisWalut;

    public PieniadzeKontroller(SerwisWalut serwisWalut) {
        this.serwisWalut = serwisWalut;
    }

    @GetMapping("/currency/{cur_name}")
    public ResponseEntity<Double> getCurrency(@PathVariable String cur_name,
                                              @RequestParam String start_search_date,
                                              @RequestParam String end_search_date){
        return ResponseEntity.ok(serwisWalut.getCurrency(cur_name, start_search_date, end_search_date));
    }

    @GetMapping("/currency")
    public ResponseEntity<List<Pieniadze>> findAllCurrency() {
        return ResponseEntity.ok(serwisWalut.findAll());
    }

}

