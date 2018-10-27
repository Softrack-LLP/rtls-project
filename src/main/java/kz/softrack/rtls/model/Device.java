package kz.softrack.rtls.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Device model representing data from beacon")
public class Device {

    @Id
    @JsonIgnore
    private long id;

    @Indexed(unique = false)
    @ApiModelProperty(notes = "ID of the user/beacon.", example = "123asdf", dataType = "java.lang.String")
    private String userId;

    @Indexed(unique = false)
    @ApiModelProperty(notes = "Name of the BLE station that receives this signal", example = "ENTRANCE_1", dataType = "java.lang.String")
    private String name;

    @ApiModelProperty(notes = "RSSI value of the BLE", example = "-61", dataType = "java.lang.Integer")
    private Integer rssi;

    @ApiModelProperty(notes = "UNIX timestamp representing timestamp of signal", example = "123456789", dataType = "java.lang.Long")
    private Long timestamp;
}
