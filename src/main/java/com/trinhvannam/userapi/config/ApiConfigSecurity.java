package com.trinhvannam.userapi.config;

import com.trinhvannam.userapi.Repository.UserRepository;
import com.trinhvannam.userapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiConfigSecurity extends WebSecurityConfigurerAdapter {


    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user").hasAnyRole("USER")
                .antMatchers("/api").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authProvider);
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl r = new RoleHierarchyImpl();
        r.setHierarchy("ROLE_ADMIN >  ROLE_USER");
        return r;
    }
}
