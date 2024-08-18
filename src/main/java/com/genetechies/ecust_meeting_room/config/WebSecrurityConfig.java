package com.genetechies.ecust_meeting_room.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecrurityConfig{

    @Resource
    private AuthEntryPoint authEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter(){
        return new JWTAuthenticationFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .exceptionHandling()
                .authenticationEntryPoint(authEntryPoint)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();




//                .formLogin(conf -> conf
//                        .loginProcessingUrl("login")
//                        .successHandler((request, response, authentication) -> {
//
//                        })
//                        .failureHandler((request, response, exception) -> {
//
//                        }))

    }



//    @Autowired
//    private UserService userService;
//
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userService);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/login")
//                .usernameParameter("name")
//                .passwordParameter("passwd")
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication auth) throws IOException, ServletException {
//                        Object principal = auth.getPrincipal();
//                        resp.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = resp.getWriter();
//                        resp.setStatus(200);
//                        Map<String,Object> map = new HashMap<>();
//                        map.put("status",200);
//                        map.put("msg",principal);
//                        ObjectMapper om = new ObjectMapper();
//                        out.write(om.writeValueAsString(map));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler() {
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException auth) throws IOException, ServletException {
//                        resp.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = resp.getWriter();
//                        resp.setStatus(401);
//                        Map<String,Object> map = new HashMap<>();
//                        map.put("status",401);
//                        map.put("msg","login failure");
//                        ObjectMapper om = new ObjectMapper();
//                        out.write(om.writeValueAsString(map));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()
//                .and()
//                .csrf()
//                .disable();
//    }
}
