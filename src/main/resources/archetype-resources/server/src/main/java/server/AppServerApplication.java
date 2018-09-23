package ${package}.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppServerApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(AppServerApplication.class, args);
	}
}
