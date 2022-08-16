package com.oguzhanserttas.mediumblog;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MediumBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MediumBlogApplication.class, args);
    }

 /*   @Bean
    ApplicationRunner applicationRunner(ApplicationProperties applicationProperties){
        return args -> System.out.println(applicationProperties.adminPanel);
    }
*/
}
