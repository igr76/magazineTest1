package com.example.springSecurity.sequrity.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SequiriryConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/authentication/**").authenticated()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/profile/**").authenticated()
                .and()
                .formLogin()
                .and()
                .logout().logoutSuccessUrl("/");
    }

    @Bean
    public UserDetailsService user()  {
       UserDetails user = User.builder()
               .username("user")
               .password("{bcrypt}$2a$12$Cx71jghnV2Nml2bL/4n0WuNWgE3D20Hc5Y6JaikUo/UsSCdv0Sfuq")
               .roles("USER")
               .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password("{bcrypt}$2a$12$Cx71jghnV2Nml2bL/4n0WuNWgE3D20Hc5Y6JaikUo/UsSCdv0Sfuq")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
