package ru.vtb.toropov.limit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LimitApplication {

  public static void main(String[] args) {
    SpringApplication.run(LimitApplication.class, args);
  }

}
