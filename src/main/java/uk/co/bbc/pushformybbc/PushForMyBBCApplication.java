package uk.co.bbc.pushformybbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Chris on 09-May-17.
 */
@SpringBootApplication
public class PushForMyBBCApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PushForMyBBCApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(PushForMyBBCApplication.class, args);
    }
}
