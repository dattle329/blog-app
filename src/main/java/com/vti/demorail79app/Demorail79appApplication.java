package com.vti.demorail79app;

import com.vti.demorail79app.entity.Role;
import com.vti.demorail79app.entity.User;
import com.vti.demorail79app.repository.RoleRepository;
import com.vti.demorail79app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@AllArgsConstructor
@SpringBootApplication
public class Demorail79appApplication implements CommandLineRunner {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(Demorail79appApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = new User();
		user.setName("Lê Tuấn Đạt");
		user.setUsername("dattle329");
		user.setEmail("dattle329@gmail.com");
		user.setPassword(passwordEncoder.encode("123456789@"));
		var adminRole = roleRepository.findByType(Role.Type.ADMIN);
		var userRole = roleRepository.findByType(Role.Type.USER);
		user.setRoles(Set.of(adminRole, userRole));
		userRepository.save(user);
	}
}
