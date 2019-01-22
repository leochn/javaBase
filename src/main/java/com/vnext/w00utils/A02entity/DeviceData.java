package com.vnext.w00utils.A02entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Auther: LEO
 * @Date: 2018/11/22 14:58
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceData {
    /**
     * 	id_device,
     * 	ID_SERVICE,
     * 	tag_name,
     * 	pv,
     * 	date_time
     */
    private String idDevice;
    private String idService;
    private String tagName;
    private String pv;
    private Date dateTime;
    private String realPV;
    private String unit;
    private Object realData;

    public DeviceData(String idService, String tagName, Date dateTime, String realPV, String unit) {
        this.idService = idService;
        this.tagName = tagName;
        this.dateTime = dateTime;
        this.realPV = realPV;
        this.unit = unit;
    }
}
