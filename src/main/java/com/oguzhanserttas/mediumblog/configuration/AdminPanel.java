package com.oguzhanserttas.mediumblog.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "application.admin-panel")
@Configuration
public class AdminPanel {
    private String username;
    private String password;
}
