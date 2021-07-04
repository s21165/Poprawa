package pl.edu.pjwstk.poprawka_s21165.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.LocalTime;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


 ///  @Bean
 ///  public static LocalTime getTime() {
 ///      return java.time.LocalTime.now();
 ///  }

 ///  @Bean
 ///  public static LocalDate getDate() {
 ///      return java.time.LocalDate.now();
 ///  }

}

   /* potrzebny aby komunikowac sie z API banku */

