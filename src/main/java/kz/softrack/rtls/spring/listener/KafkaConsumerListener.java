package kz.softrack.rtls.spring.listener;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kz.softrack.rtls.model.Device;
import kz.softrack.rtls.spring.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by aigerim on 11/3/18.
 */
@Service
public class KafkaConsumerListener {

    @Autowired
    private DeviceService deviceService;

    private final Gson gson = new Gson();

    @KafkaListener(topics = "device", groupId = "kz-kaznu")
    public void listen(String message) throws InterruptedException {
        System.out.println("Received Message : " + message);
        List<Device> deviceList = gson.fromJson(message, new TypeToken<List<Device>>(){}.getType());
        deviceService.saveDevices(deviceList);
    }

}
