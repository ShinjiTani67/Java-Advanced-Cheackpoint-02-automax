package com.suaempresa.suaplicacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        https
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/vendedor/novo", "/vendedor/salvar", "/vendedor/editar/**", "/vendedor/deletar/**").hasRole("ADMIN")
                .requestMatchers("/vendedor/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
            )
            .formLogin(Customizer.withDefaults())
            .logout(logout -> logout.logoutSuccessUrl("/login?logout").permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
        return new InMemoryUserDetailsManager(
            User.withUsername("admin")
                .password(encoder.encode("admin123"))
                .roles("ADMIN")
                .build(),
            User.withUsername("usuario")
                .password(encoder.encode("usuario123"))
                .roles("USER")
                .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
