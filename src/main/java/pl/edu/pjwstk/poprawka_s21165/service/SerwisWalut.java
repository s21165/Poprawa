package pl.edu.pjwstk.poprawka_s21165.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.poprawka_s21165.entity.Pieniadze;
import pl.edu.pjwstk.poprawka_s21165.entity.Root;
import pl.edu.pjwstk.poprawka_s21165.repository.AverageRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service  /* "Service objects provide the client view of a Web service" tutaj bedzie logika aplikacji umozliwiajaca komunikacje, szuka @RestController, oraz @Contrroller */
public class SerwisWalut {
    private final RestTemplate restTemplate;
    private final AverageRepo averageRepo;

    public SerwisWalut(RestTemplate restTemplate, AverageRepo averageRepo) {
        this.restTemplate = restTemplate;
        this.averageRepo = averageRepo;
        /* dzieki temu mozemy wykorzystac korzysci plynace z RestTemplateConfig (bean) oraz AverageRepo(JpaRepository) */
    }
public  Pieniadze zapisz(String waluta, LocalDate dataOd, LocalDate dataDo, double srednia ) {
    Pieniadze pieniadze = new Pieniadze(waluta, dataOd, dataDo, srednia);
    return averageRepo.save(pieniadze);
}

    public Double getCurrency(String waluta, String dataOd, String dataDo){
        String fooResourceUrl = String.format("http://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s/?format=json", waluta,dataOd, dataDo);
        Root ulotnePieniazki = restTemplate.getForEntity(fooResourceUrl, Root.class).getBody();   /* wyciagamy body z zapytania (wszystko) */
        int days = ulotnePieniazki.getRates().size(); /*wyciagamy getRates z body i liczymy ilosc elementow w tablicy getRates tym samym odzymujac wartosc dni pomiedzy dataOd dataDo */
        List<Double> wartosciWalut = new ArrayList<Double>();
        double suma = 0;

        for(int i=0; i<days; i++){     /* sumujemy wartosci walut na przestrzeni dni ktorych wybralismy a nastepnie liczymy z nich srednia */
            wartosciWalut.add(ulotnePieniazki.getRates().get(i).getMid());
            suma += wartosciWalut.get(i);
        }
        double srednia = suma/days;

        LocalDate dataFormatowanaOd = LocalDate.parse(dataOd);    /* formatujemy date */
        LocalDate dataFormatowanaDo = LocalDate.parse(dataDo);

        Pieniadze  ulotneP = new Pieniadze(waluta, dataFormatowanaOd, dataFormatowanaDo, srednia);
        averageRepo.save(ulotneP);          /* zapisujemy zapytanie do bazy danych */
        return srednia;
    }
    public List<Pieniadze> findAll(){
        return averageRepo.findAll();
    }


}

