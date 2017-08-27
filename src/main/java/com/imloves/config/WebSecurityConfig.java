package com.imloves.config;

import com.imloves.repository.SysRoleRepository;
import com.imloves.repository.SysUserRepository;
import com.imloves.repository.SysUserRoleRepository;
import com.imloves.service.JwtUserDetailServiceImpl;
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

    @Autowired
    SysUserRoleRepository sysUserRoleRepository;

    @Autowired
    SysRoleRepository sysRoleRepository;

    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(new JwtUserDetailServiceImpl(sysUserRepository, sysRoleRepository, sysUserRoleRepository));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .formLogin().and()
                .httpBasic().and()
                .rememberMe().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/home").authenticated();
    }
}
