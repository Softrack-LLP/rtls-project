package kz.softrack.rtls.spring;

import java.util.List;
import kz.softrack.rtls.model.Device;
import kz.softrack.rtls.spring.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@Service
public class DeviceService {

    final DeviceRepository deviceRepository;

    @Autowired
    public DeviceService(final DeviceRepository deviceRepository) {

        this.deviceRepository = deviceRepository;
    }

    public void saveDevices(List<Device> devices) {
        deviceRepository.insert(devices);
    }

    public List<Device> findAll(final int page, final int size) {

        return deviceRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
