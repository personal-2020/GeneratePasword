package GeneratorPassword.GeneratorPassword;

import GeneratorPassword.GeneratorPassword.persistence.MongoDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = MongoDB.class)
public class GeneratorPasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeneratorPasswordApplication.class, args);
	}
        
       	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/getPassword/gtn").allowedOrigins("http://localhost:4200");
			}
		};
	}        

}
