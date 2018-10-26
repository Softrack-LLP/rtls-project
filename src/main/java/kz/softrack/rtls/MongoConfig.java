package kz.softrack.rtls;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@Configuration
@EnableMongoRepositories(basePackageClasses = DeviceRepository.class)
public class MongoConfig {

}
