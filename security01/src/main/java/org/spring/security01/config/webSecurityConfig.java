package org.spring.security01.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Log4j2
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class webSecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//        Block outer approach
        http.csrf().disable();

//        Page settings
        http.authorizeHttpRequests()
                        .antMatchers("/", "/join", "/login").permitAll()
                        .antMatchers("/loginIndex").authenticated() // After logging in,
                        .antMatchers("/admin/**").hasAnyRole("ADMIN")
                        .antMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER")
                        .antMatchers("/member/**").hasAnyRole("ADMIN", "MANAGER", "MEMBER");



//        Login settings
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/", true)
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
//                .failureForwardUrl("/fail")
                .failureUrl("/index")
                .and()
                .oauth2Login()
                .loginPage("/login");
                // executing log in by post method
        // when logging in, it generates name value of each ID

//        Logout settings
        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");
        http.userDetailsService(userDetailsService);

        return http.build();
    }

//    Secure passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
