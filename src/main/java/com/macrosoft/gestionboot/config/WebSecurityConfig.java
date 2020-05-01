package com.macrosoft.gestionboot.config;


import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.bind.annotation.GetMapping;


@Configuration
@EnableWebSecurity
//TODO
/*
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
*/
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DataSource datasource;
    
    
    @Value("${spring.queries.users-by-username-query}")
    private String usersQuery;
    
    @Value("${spring.queries.authorities-by-username-query}")
    private String authoritiesQuery;
    
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    //TODO
    //@Autowired
    //private CustomerRepository customerRepository;
    

    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/login").permitAll()
                .antMatchers("/gestion/*")
                .hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
                .antMatchers("/gestion/admin/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .failureUrl("/login?error")
                .loginPage("/login")
                //.defaultSuccessUrl("/home")
                .defaultSuccessUrl("/home",true)
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll();
    }
	
    //      .loginProcessingUrl("/perform_login")
    
    
    @Autowired
    protected void  configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
    	
    	log.info("Start Spring Security  configure method:");
    	
    	log.debug("*** usesQuery login ***: "+ usersQuery);
    	log.debug("*** authoritiesQuery login ***: "+ authoritiesQuery);
    	
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                 .authoritiesByUsernameQuery(authoritiesQuery)
                .dataSource(datasource)
                .passwordEncoder(bCryptPasswordEncoder);
       
       /*
     
        //Use Spring Boots User detailsMAnager
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();

        //Set our Datasource to use the one defined in application.properties
        userDetailsService.setDataSource(datasource);
        
      //add components
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
        auth.jdbcAuthentication().dataSource(datasource);

        // add new user "user" with password "password" - password will be encrypted
        if (!userDetailsService.userExists("admin")) {
        	
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
            User userDetails = new User("admin", bCryptPasswordEncoder.encode("admin2020"), authorities);
           
           
            userDetailsService.createUser(userDetails );
            
        	log.debug("configureGlobal method: createUser" +  userDetails.getUsername()); 
            
        
        
        }
        */
    }

  
    
    
    @Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/static/**", "/css/**", "/js/**", "/images/**");
	   
	}
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
	

}

