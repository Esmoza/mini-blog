package com.auk.project.miniblog.config;

import com.auk.project.miniblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
<<<<<<< HEAD
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
=======
>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public SecurityConfiguration(CustomUserDetailsService userPrincipalDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

<<<<<<< HEAD
=======

>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception {
       auth.userDetailsService(customUserDetailsService)
       .passwordEncoder(getPasswordEncoder());
    }

     private PasswordEncoder getPasswordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
     }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
<<<<<<< HEAD

                http.authorizeRequests()
                .antMatchers("/index.html", "/registration").permitAll()
                .antMatchers("/static/**","/templates/signup").permitAll()
                .antMatchers("/blog/**").authenticated()
                        .antMatchers("/categories/**").authenticated()
                .antMatchers("/profile").authenticated()
=======
        http.csrf().disable();
                http.authorizeRequests()
                .anyRequest().authenticated()
>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f
                .and()
                .formLogin()
                .loginProcessingUrl("/signin")
                .loginPage("/login").permitAll()
                        .successHandler(new AuthenticationSuccessHandler() {
                            @Override
                            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
<<<<<<< HEAD
                                httpServletResponse.sendRedirect("/blog/list");
=======
                                httpServletResponse.sendRedirect("/index");
>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f
                            }
                        })
                        .failureHandler(new AuthenticationFailureHandler() {
                            @Override
                            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                                httpServletResponse.sendRedirect("/login");
                            }
                        })
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
<<<<<<< HEAD
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .rememberMe()
                .rememberMeParameter("remember-me-option") // it is name of checkbox at login page
                .rememberMeCookieName("rememberlogin") .tokenValiditySeconds(2592000).key("mySecret");


=======
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f
    }

   /* @Bean
    DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.customUserDetailsService);

        return daoAuthenticationProvider;
    }
<<<<<<< HEAD
*/
    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
=======

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }*/
>>>>>>> 9a7faa920f6fa9cfbdcb09863ac57ae674c4748f

}
