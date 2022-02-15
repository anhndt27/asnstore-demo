package com.trinhvannam.userapi.config;

import com.trinhvannam.userapi.Repository.UserRepository;
import com.trinhvannam.userapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;

@Configuration
@EnableWebSecurity
public class ApiConfigSecurity extends WebSecurityConfigurerAdapter {




    @Override
        protected void configure(HttpSecurity http) throws Exception {

            HttpBasicConfigurer<HttpSecurity> user = http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/user").hasAnyRole("false")
                    .antMatchers("/admin").hasAnyRole("true")
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic();
        }
}
