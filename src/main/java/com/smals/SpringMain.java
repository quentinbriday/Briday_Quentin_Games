package com.smals;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringMain {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringMain.class).build().run();
    }
}
