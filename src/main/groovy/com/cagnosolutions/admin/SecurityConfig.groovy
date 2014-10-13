package com.cagnosolutions.admin
import groovy.transform.CompileStatic
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

/**
 * Created by Scott Cagno.
 * Copyright Cagno Solutions. All rights reserved.
 */

@CompileStatic
@Configuration
@EnableWebMvcSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/hypervisor/**").hasAnyRole("ADMIN")
        http.formLogin().loginPage("/login")
        http.logout().logoutSuccessUrl("/").logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
    }
}
