package kz.softrack.rtls.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@Document(collection = "device")
@Data
@AllArgsConstructor
public class Device {

    public Device(final String userId, final String name, final Integer rssi,
                  final Long timestamp) {

        this.userId = userId;
        this.name = name;
        this.rssi = rssi;
        this.timestamp = timestamp;
    }

    @Id
    private UUID id = UUID.randomUUID();

    @Indexed(unique = false)
    private String userId;

    @Indexed(unique = false)
    private String name;

    private Integer rssi;

    private Long timestamp;
}
