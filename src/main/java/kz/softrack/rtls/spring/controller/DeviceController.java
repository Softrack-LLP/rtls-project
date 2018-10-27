package kz.softrack.rtls.spring.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import kz.softrack.rtls.model.Device;
import kz.softrack.rtls.spring.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@RestController("/device")
public class DeviceController {

    final DeviceRepository deviceRepository;

    @Autowired
    public DeviceController(final DeviceRepository deviceRepository) {

        this.deviceRepository = deviceRepository;
    }

    @RequestMapping(value = "/saveList", method = RequestMethod.POST)
    @ApiOperation("Save list of devices")
    @ApiResponses(@ApiResponse(code = 200, message = "Save list of device signals"))
    public void saveList(@RequestBody List<Device> devices) {

        deviceRepository.insert(devices);
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ApiOperation("Save list of devices")
    @ApiResponses(@ApiResponse(code = 200, message = "Get list of device signals", response = Device.class, responseContainer = "List"))
    public List<Device> getList(@RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "10") Integer size) {

        final Page<Device> insert = deviceRepository.findAll(PageRequest.of(page, size));
        return insert.getContent();
    }

}
