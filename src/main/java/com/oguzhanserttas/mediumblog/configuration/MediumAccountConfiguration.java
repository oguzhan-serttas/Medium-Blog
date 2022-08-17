package com.oguzhanserttas.mediumblog.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "medium")
@Getter
@Setter
@ToString
public class MediumAccountConfiguration {
    private String userId;
    private String accessToken;
}
