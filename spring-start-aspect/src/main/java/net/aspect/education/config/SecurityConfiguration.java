package net.aspect.education.config;

import net.aspect.education.database.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
        httpSec.csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(
                        auth -> auth
                                .requestMatchers("/login", "/users/registration", "/v3/api-docs/", "/swagger-ui/").permitAll()
                                .requestMatchers("/admin/**").hasRole(Role.ADMIN.getAuthority())
                                .requestMatchers(AntPathRequestMatcher.antMatcher("/users/{\\d}/delete")).hasAnyAuthority(Role.ADMIN.getAuthority(), Role.CEO.getAuthority())
                                .anyRequest()
                                .authenticated())
//                .httpBasic(Customizer.withDefaults())
                .formLogin(
                        login ->
                                login
                                        .loginPage("/login")
                                        .defaultSuccessUrl("/users")
                                        .permitAll())
                .logout(logout ->
                        logout
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login")
                                .deleteCookies("JSESSIONID"));
        return httpSec.build();
    }
}
