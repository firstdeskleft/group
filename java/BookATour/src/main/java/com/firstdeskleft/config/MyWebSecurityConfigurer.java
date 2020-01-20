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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

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

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler() {
        return new MySimpleUrlAuthenticationSuccessHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/HomeAdmin").hasRole("ADMIN")
                .antMatchers("/HomeCustomer").hasRole("CUSTOMER")
                .antMatchers("/HomeGuide").hasRole("GUIDE")
                .antMatchers("/tour/list").anonymous()
                .antMatchers("/tour/listforAdmin").hasRole("ADMIN")
                .antMatchers("/tour/listforcustomer").hasRole("CUSTOMER")
                .antMatchers("/tour/create", "/tour/guidetours", "/tour/delete", "/tour/update").hasRole("GUIDE")
                .antMatchers("/customer/list","customer/delete").hasRole("ADMIN")
                .antMatchers("/customer/update","/customer/bookings").hasRole("CUSTOMER")
                .antMatchers("/guide/list","/guide/delete").hasRole("ADMIN")
                .antMatchers("/guide/update").hasRole("GUIDE")
                .antMatchers("/booking/create","/booking/delete").hasRole("CUSTOMER")
                .and().formLogin()
                .loginPage("/Login")
                .loginProcessingUrl("/authenticate")
                .permitAll()
                .successHandler(myAuthenticationSuccessHandler())
                .and().logout().permitAll()
                .and().exceptionHandling().accessDeniedPage("/access-denied");

    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userDetailsService);
        auth.setPasswordEncoder(passwordEncoder());

        return auth;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
