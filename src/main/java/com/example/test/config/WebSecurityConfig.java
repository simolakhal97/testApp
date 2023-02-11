package com.example.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Autowired
    UserDetailsService userDetailsService;


    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }





    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();


    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests().antMatchers(HttpMethod.POST).hasAnyRole("etudient")
                .antMatchers(HttpMethod.PUT).hasAnyRole("etudient")
                .antMatchers(HttpMethod.DELETE).hasAnyRole("Etudient")
                .antMatchers(HttpMethod.GET,"/etudient").hasAnyRole("Etudient")

                .antMatchers(HttpMethod.GET,"/etudient").hasAnyRole("etudient")
                .antMatchers(HttpMethod.GET,"/Etudient/{userId}").access("@userSecurity.hasEtudientId(authentication,#Id)")
        ;
        http.cors().disable();
        http.csrf().disable();
        http.headers().frameOptions().disable();
        http.csrf().disable().headers().disable();
        super.configure(http);


    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/postgres-console/**");
    }












}
