package com.example.demo.config;

import com.example.demo.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable()
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/rest/**").permitAll()
                //.antMatchers(HttpMethod.DELETE, "rest/user/*").hasRole("ADMIN")
                .antMatchers("/**").permitAll()
                .antMatchers("/rest/activeuser").authenticated()
                .and()
                .formLogin()
                    .loginPage("/rest/login")
                .and()
                .logout().logoutUrl("/rest/logout");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(myUserDetailsService)
                .passwordEncoder(myUserDetailsService.getEncoder());
    }
}
