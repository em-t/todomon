package fi.academy.todomon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TodomonApplication extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(TodomonApplication.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TodomonApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(TodomonApplication.class, args);
    }
}
