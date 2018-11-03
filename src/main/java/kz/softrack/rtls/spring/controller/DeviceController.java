package kz.softrack.rtls.spring.controller;

import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.concurrent.ExecutionException;

import kz.softrack.rtls.model.Device;
import kz.softrack.rtls.model.DeviceRequest;
import kz.softrack.rtls.spring.DeviceService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
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

    final DeviceService deviceService;
    private final Gson gson = new Gson();

    @Value("${message.topic.name}")
    private String topicName;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public DeviceController(final DeviceService deviceService) {

        this.deviceService = deviceService;
    }

    @RequestMapping(value = "/saveList", method = RequestMethod.POST)
    @ApiOperation("Save list of devices")
    @ApiResponses(@ApiResponse(code = 200, message = "Save list of device signals"))
    public void saveList(@RequestBody List<DeviceRequest> devices) throws ExecutionException, InterruptedException {
        final String devicesAsJsonArray = gson.toJson(devices);
        kafkaTemplate.send(new ProducerRecord<>(topicName, devicesAsJsonArray)).get();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ApiOperation("Save list of devices")
    @ApiResponses(@ApiResponse(code = 200, message = "Get list of device signals", response = Device.class, responseContainer = "List"))
    public List<Device> getList(@RequestParam(defaultValue = "0") Integer page,
                                @RequestParam(defaultValue = "10") Integer size) {

        return deviceService.findAll(page, size);
    }

}
