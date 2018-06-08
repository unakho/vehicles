package org.za.assets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * @author unakho.kama
 */
@PropertySource("classpath:application.properties")
@SpringBootApplication
@ComponentScan(basePackages = "org.za.assets")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
