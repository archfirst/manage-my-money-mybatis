package org.archfirst.mmm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ImportResource("/applicationContext.xml")
@PropertySource("/application.properties")
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
