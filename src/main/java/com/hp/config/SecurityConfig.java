package com.hp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired//注入database
    private DataSource dataSource;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String p666 = encoder.encode("666");
        String p123 = encoder.encode("123");
        System.out.println(p666);
        System.out.println(p123);

        //连接jdbc认证用户信息
        auth.jdbcAuthentication().passwordEncoder(encoder).
                dataSource(dataSource).usersByUsernameQuery("select name ,psw ,1 from h_users where name=?").
                authoritiesByUsernameQuery("select name  ,role  from h_users where name=?");

    }

    @Override//重写方法
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/").permitAll()
                .antMatchers("/house/**","/users/**","/admin","/index","/").hasAuthority("房东")
                .antMatchers("/index").hasAuthority("租客")
                .anyRequest().authenticated()
                .and().formLogin();
    }
    }

