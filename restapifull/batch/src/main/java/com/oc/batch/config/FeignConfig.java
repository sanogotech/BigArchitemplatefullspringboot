package com.oc.batch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.auth.BasicAuthRequestInterceptor;

/**
 * FeignConfig
 */
@Configuration
public class FeignConfig {

    /**
     * Send username and password to API for Basic Auth for each request
     * 
     */
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("OCBibliotheque-client", "OCB2020");
    }
    
}