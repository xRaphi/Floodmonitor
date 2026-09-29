package at.ac.tgm.floodmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FloodmonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(FloodmonitorApplication.class, args);
    }

}