package io.github.rodrigoweich.fincontrolapi;

import io.github.rodrigoweich.fincontrolapi.entity.Movement;
import io.github.rodrigoweich.fincontrolapi.entity.User;
import io.github.rodrigoweich.fincontrolapi.enums.MovementEnum;
import io.github.rodrigoweich.fincontrolapi.repository.MovementRepository;
import io.github.rodrigoweich.fincontrolapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FincontrolApiApplication {

	@Bean
	public CommandLineRunner commandLineRunner(
			@Autowired UserRepository userRepository,
			@Autowired MovementRepository movementRepository
		) {
		return args -> {
			User user = new User();
			user.setName("Rodrigo Gomes Weich");
			userRepository.save(user);

			Movement movement = new Movement();
			movement.setUser(user);
			movement.setMovement(MovementEnum.INSERT);
			movementRepository.save(movement);

			Movement movement1 = new Movement();
			movement1.setUser(user);
			movement1.setMovement(MovementEnum.REMOVE);
			movementRepository.save(movement1);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(FincontrolApiApplication.class, args);
	}

}
