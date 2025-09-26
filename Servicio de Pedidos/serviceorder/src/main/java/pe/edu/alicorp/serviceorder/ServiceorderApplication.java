package pe.edu.alicorp.serviceorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceorderApplication.class, args);
	}

}
