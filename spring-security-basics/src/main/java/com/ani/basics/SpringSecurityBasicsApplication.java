package com.ani.basics;

import com.ani.basics.auth.AppUser;
import com.ani.basics.auth.AppUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringSecurityBasicsApplication.class, args);
		loadUsers(ctx.getBean(AppUserRepository.class), ctx.getBean(PasswordEncoder.class));
	}

	private static void loadUsers(AppUserRepository repo, PasswordEncoder encoder) {
		repo.save(
				new AppUser(
						1L,
						"machine",
						encoder.encode("ani"),
						"machine",
						true,true,true,true,
						"machine:on,machine:off"
				)
		);

		repo.save(
				new AppUser(
						2L,
						"worker",
						encoder.encode("ani"),
						"worker",
						true,true,true,true,
						"worker:login,worker:logout"
				)
		);

		repo.save(
				new AppUser(
						3L,
						"workermachine",
						encoder.encode("ani"),
						"worker_machine",
						true,true,true,true,
						"worker:machine:pause"
				)
		);
	}
}
