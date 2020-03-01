package com.stepify;

import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StepifyApplication {

    public static void main(String[] args) {
        SpringApplication.run(StepifyApplication.class, args);
    }

    @PostConstruct
    public void start() throws IOException {
        new ProcessBuilder().command("cmd.exe", "/c", "start", "http://localhost:8000/login").start();
    }
}
