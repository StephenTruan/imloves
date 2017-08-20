package com.imloves.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by wujianchuan
 * 2017/8/19 20:37
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT nick_name, password, state FROM customer WHERE nick_name = ?")
                .authoritiesByUsernameQuery("SELECT c.nick_name, r.role_name FROM customer_role cr LEFT JOIN customer c ON c.customer_id = cr.customer_id RIGHT JOIN role r ON r.role_id = cr.role_id WHERE c.nick_name = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .formLogin().and()
                .httpBasic().and()
                .rememberMe().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").authenticated();
    }
}
