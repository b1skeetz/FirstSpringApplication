package damir.kad.medicine.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin(formLoginConfigurer -> {
            formLoginConfigurer.defaultSuccessUrl("/medicines");
        });
        httpSecurity.logout(logoutConfigurer -> {
            logoutConfigurer.logoutSuccessUrl("/medicines");
        });
        httpSecurity.authorizeHttpRequests(authorizationConfigurer -> {
            authorizationConfigurer
                    .requestMatchers(
                            "/medicines/create",
                            "/medicines/update",
                            "/medicines/delete"
                    ).hasRole("admin");
            authorizationConfigurer
                    .anyRequest()
                    .permitAll();
        });
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}