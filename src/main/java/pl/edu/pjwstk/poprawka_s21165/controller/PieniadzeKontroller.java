package pl.edu.pjwstk.poprawka_s21165.controller;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.poprawka_s21165.entity.Pieniadze;
import pl.edu.pjwstk.poprawka_s21165.service.SerwisWalut;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/dupa")
public class PieniadzeKontroller {

    private final SerwisWalut serwisWalut;

    public PieniadzeKontroller(SerwisWalut serwisWalut) {
        this.serwisWalut = serwisWalut;
    }


///
 ///   @GetMapping("/currency/{waluta}")
 ///   public ResponseEntity<Pieniadze> getCurrency(@PathVariable String waluta,
 ///                                             @RequestParam String dataOd,
 ///                                             @RequestParam String dataDo){
 ///       /*     Pieniadze walutka = serwisWalut.getCurrency(waluta, dataOd, dataDo);  */ /* liczymy srednia oraz przrypisujemy wszystkie dane do obiektu */
 ///       return ResponseEntity.ok(serwisWalut.getCurrency(waluta, dataOd, dataDo));  /* zapisujemy wartosci */
 ///   }


    @GetMapping("/{waluta}")
    public ResponseEntity<Pieniadze> dajPieniadze(

            @PathVariable String waluta,
            @RequestParam String dataOd,
            @RequestParam String dataDo) {
        return ResponseEntity.ok(serwisWalut.dajPieniadze(waluta, dataOd, dataDo));
    }


    @GetMapping("/wszystkie")
    public ResponseEntity<List<Pieniadze>> findAllCurrency() {
        return ResponseEntity.ok(serwisWalut.findAll());
    }

}

