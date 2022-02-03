package by.ita.je;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
public class M3App {
    public static void main(String[] args) {

        SpringApplication.run(M3App.class,args);
    }
}
