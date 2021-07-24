package com.icedevcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IceUpmsServiceApplication {

    public static void main(String[] args) {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","{}");
        SpringApplication.run(IceUpmsServiceApplication.class, args);
    }

}
