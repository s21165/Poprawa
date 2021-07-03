package pl.edu.pjwstk.poprawka_s21165.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


/* https://api.nbp.pl/api/exchangerates/rates/a/USD/2012-01-01/2012-01-05/?format=json chcemy aby dane wartosci z api byli zmienniane wraz z zapytaniem */
@Entity                                           /* tworzymy obiekt ktory bedzie zawieral te same wartosci co w bazie danych */
public class Pieniadze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataOd, DataDo, szukanieDate, szukanieCzas;
    private Double srednia;


    public Pieniadze() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataOd() {
        return dataOd;
    }

    public void setDataOd(LocalDate dataOd) {
        this.dataOd = dataOd;
    }

    public LocalDate getDataDo() {
        return DataDo;
    }

    public void setDataDo(LocalDate dataDo) {
        DataDo = dataDo;
    }

    public LocalDate getSzukanieDate() {
        return szukanieDate;
    }

    public void setSzukanieDate(LocalDate szukanieDate) {
        this.szukanieDate = szukanieDate;
    }

    public LocalDate getSzukanieCzas() {
        return szukanieCzas;
    }

    public void setSzukanieCzas(LocalDate szukanieCzas) {
        this.szukanieCzas = szukanieCzas;
    }

    public Double getSrednia() {
        return srednia;
    }

    public void setSrednia(Double srednia) {
        this.srednia = srednia;
    }

    public Pieniadze(Long id, LocalDate dataOd, LocalDate dataDo, LocalDate szukanieDate, LocalDate szukanieCzas, Double srednia) {
        this.id = id;
        this.dataOd = dataOd;
        DataDo = dataDo;
        this.szukanieDate = szukanieDate;
        this.szukanieCzas = szukanieCzas;
        this.srednia = srednia;
    }

    public Pieniadze(String waluta, LocalDate dataOd, LocalDate dataDo, double srednia) {

    }


}