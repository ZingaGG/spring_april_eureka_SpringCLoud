package ru.gb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ru.gb.aspect.LoggingAspect;

@Configuration
@ComponentScan(basePackages = "ru.gb")
@EnableAspectJAutoProxy
public class AspectConfig {

    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}