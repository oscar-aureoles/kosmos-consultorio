package kosmos.consultorio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("kosmos.consultorio")
public class ConsultorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultorioApplication.class, args);
	}

}
