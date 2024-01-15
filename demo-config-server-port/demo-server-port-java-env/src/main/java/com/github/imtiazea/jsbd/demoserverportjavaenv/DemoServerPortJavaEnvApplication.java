package com.github.imtiazea.jsbd.demoserverportjavaenv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoServerPortJavaEnvApplication {

    public static void main(String[] args) {
        System.setProperty("server.port", "8090");
        SpringApplication.run(DemoServerPortJavaEnvApplication.class, args);
    }

}
