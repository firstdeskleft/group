package com.firstdeskleft.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author nick.sabanis
 */
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource datasource;
    
    @Autowired
    private com.firstdeskleft.service.UserService userDetailsService;
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.authenticationProvider(authenticationProvider());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                
                .antMatchers("/").anonymous()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/*/create/**", "/*/update/**", "/*/delete/**").permitAll()
                
                
//                .and().formLogin()
//                .loginPage("/loginPage")
//                .loginProcessingUrl("/authenticate")                 
//                .permitAll()
                
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/access-denied");

    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());
        
        
        return auth;
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){          
        return new BCryptPasswordEncoder();
    }
    

}
