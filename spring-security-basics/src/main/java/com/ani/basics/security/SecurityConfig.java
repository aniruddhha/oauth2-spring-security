package com.ani.basics.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.lang.reflect.Method;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DaoAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))//X-XSRF-TOKEN
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers( "/api/worker/**").hasRole(AppRole.WORKER.name())
//                .antMatchers("/api/machine/**").hasRole(AppRole.MACHINE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    /*@Override
    @Bean
    protected UserDetailsService userDetailsService() {
        var machine = User.builder()
                .username("machine")
                .password(passwordEncoder.encode("ani"))
//                .roles(AppRole.MACHINE.name())
                .authorities(AppRole.MACHINE.grantedAuthorities())
                .build();

        var worker = User.builder()
                .username("worker")
                .password(passwordEncoder.encode("ani"))
                .roles(AppRole.WORKER.name())
//                .authorities(AppRole.WORKER.grantedAuthorities())
                .build();

        var workerMachine = User.builder()
                .username("workerMachine")
                .password(passwordEncoder.encode("ani"))
                .authorities(AppRole.WORKER_MACHINE.grantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(machine, worker, workerMachine);
    }*/
}
