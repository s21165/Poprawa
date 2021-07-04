package pl.edu.pjwstk.poprawka_s21165.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.poprawka_s21165.entity.Pieniadze;


public interface AverageRepo extends JpaRepository<Pieniadze, Long> {   /* dzieki temu mamy dostep do podstawowych operacji takie jak findbyid, findall, save, delete by id */
    /* model ktory laczy sie z baza danych oraz Long jako id */
}
