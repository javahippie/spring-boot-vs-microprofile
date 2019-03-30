package de.javahippie.backinthering.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.ConfigurableEnvironment;

@Configuration
public class PropertySourceConfig {

    @Autowired
    private ConfigurableEnvironment env;

    @Bean
    @Lazy(false)
    public MyPropertySource test() {
        MyPropertySource propertySource = new MyPropertySource();
        env.getPropertySources().addBefore("systemProperties", propertySource);
        return propertySource;
    }
}
