package kz.softrack.rtls.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("Device model representing data from beacon")
public class DeviceRequest {

    @ApiModelProperty(notes = "ID of the user/beacon.", example = "123asdf", dataType = "java.lang.String")
    private String userId;

    @ApiModelProperty(notes = "Name of the BLE station that receives this signal", example = "ENTRANCE_1", dataType = "java.lang.String")
    private String name;

    @ApiModelProperty(notes = "RSSI value of the BLE", example = "-61", dataType = "java.lang.Integer")
    private Integer rssi;

    @ApiModelProperty(notes = "UNIX timestamp representing timestamp of signal", example = "123456789", dataType = "java.lang.Long")
    private Long timestamp;

    public static Device toDevice(DeviceRequest request) {

        return new Device(request.getUserId(), request.getName(), request.getRssi(), request.getTimestamp());

    }
}
