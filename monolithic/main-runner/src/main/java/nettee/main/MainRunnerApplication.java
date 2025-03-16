package nettee.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "nettee")
public class MainRunnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainRunnerApplication.class, args);
    }

}
