package com.oguzhanserttas.mediumblog.configuration;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application")
@Getter
@Setter
@ToString
public class ApplicationProperties {
    @Autowired
    public AdminPanel adminPanel;
    private boolean registration;


}
