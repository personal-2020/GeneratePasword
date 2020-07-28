package GeneratorPassword.GeneratorPassword;

import GeneratorPassword.GeneratorPassword.persistence.MongoDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MongoDB.class)
public class GeneratorPasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneratorPasswordApplication.class, args);
	}

}
