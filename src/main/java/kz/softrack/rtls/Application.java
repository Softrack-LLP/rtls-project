package kz.softrack.rtls;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@SpringBootApplication
@EnableAutoConfiguration
@Import({SpringDataRestConfiguration.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
