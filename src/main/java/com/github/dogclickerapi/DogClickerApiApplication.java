package com.github.dogclickerapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DogClickerApiApplication implements ApplicationRunner {

  public static void main(String[] args) {
    SpringApplication.run(DogClickerApiApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) {
    log.info("LOCAL: http://localhost:8080/api/swagger-ui.html");
    log.info("DOCKER: http://localhost:8090/api/swagger-ui.html");
  }
}
