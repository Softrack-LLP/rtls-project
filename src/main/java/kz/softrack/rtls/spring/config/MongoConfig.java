package kz.softrack.rtls.spring.config;

import kz.softrack.rtls.spring.repository.DeviceRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = DeviceRepository.class)
public class MongoConfig {

}
