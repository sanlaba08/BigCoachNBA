package com.utn.BigCouchNBA.config;

import com.utn.BigCouchNBA.session.AdminSessionFilter;
import com.utn.BigCouchNBA.session.UserSessionFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@org.springframework.context.annotation.Configuration
@PropertySource("application.properties")
@EnableScheduling
@EnableCaching
public class Configuration {

    @Autowired
    UserSessionFilter userSessionFilter;

    @Autowired
    AdminSessionFilter adminSessionFilter;

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(userSessionFilter);
        registration.addUrlPatterns("/api/web/*");
        return registration;
    }

    @Bean
    public FilterRegistrationBean myFilterBis() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(adminSessionFilter);
        registration.addUrlPatterns("/api/admin/*");
        return registration;
    }

}
