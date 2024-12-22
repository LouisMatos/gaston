package br.com.matos.gaston;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication(scanBasePackages = { "br.com.matos.gaston"})
public class GastonApplication {

  public static void main(String[] args) {
    SpringApplication.run(GastonApplication.class, args);
  }

}
