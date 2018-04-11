package com.vnext.w11io;

import java.io.Serializable;
import java.util.Map;

/**
 * @author leo
 * @since 2018-04-09 14:03:54
 */
public class RealTimeData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String deviceId;
	private String timestamp;
	private Map<String, Object> values;
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public Map<String, Object> getValues() {
		return values;
	}
	public void setValues(Map<String, Object> values) {
		this.values = values;
	}
	
	
}
