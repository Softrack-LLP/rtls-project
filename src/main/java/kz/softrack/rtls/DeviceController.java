package kz.softrack.rtls;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@RestController
public class DeviceController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ApiOperation(value = "Save list of devices")
    @ApiResponses({@ApiResponse(code=200, message="Created", response=Device.class, responseContainer = "List")})
    public void list(@RequestBody List<Device> devices) {
        final List<Device> insert = deviceRepository.insert(devices);
    }

}
