package fi.academy.todomon;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import fi.academy.todomon.CustomizedAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) {
        try {
            auth.jdbcAuthentication().dataSource(dataSource)
                    .usersByUsernameQuery("select username,password, enabled from users where username=?")
                    .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Autowired
    CustomizedAuthenticationSuccessHandler customizedAuthenticationSuccessHandler;


    @Override
    protected void configure(HttpSecurity http) {
        try {
            http
                    .authorizeRequests()
                    .antMatchers("/", "/home").permitAll()
                    .antMatchers("/admin").hasRole("ADMIN")
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().successHandler(customizedAuthenticationSuccessHandler)
                    .loginPage("/login")
                    .permitAll()
                    .and()
                    .logout()
                    .permitAll();
            http.exceptionHandling().accessDeniedPage("/403");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) {
//        try {
//            auth
//                    .inMemoryAuthentication()
//                    .withUser("user").password("user").roles("USER")
//                    .and()
//                    .withUser("admin").password("admin").roles("ADMIN");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}


