package kz.softrack.rtls.spring.repository;

import kz.softrack.rtls.model.Device;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@Repository
public interface DeviceRepository extends MongoRepository<Device, ObjectId> {

}
