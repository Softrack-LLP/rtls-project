package kz.softrack.rtls;

import io.swagger.annotations.ApiModel;
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
@ApiModel
public class Device {

    @Id
    private long id;

    @Indexed(unique = false)
    private String userId;

    @Indexed(unique = false)
    private String name;

    private Integer rssi;

    private Long timestamp;
}
