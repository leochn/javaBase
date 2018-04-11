/**
 * 
 */
package com.vnext.w11io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import static com.alibaba.fastjson.JSON.parseObject;

/**
 * @author leo
 * @since 2018-02-06 17:58:51
 */
public class TestJson {
	
	// 定义jackson对象
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static String read(String filename) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine()) != null) {
			sb.append(s).append("\n");
		}
		in.close();
		return sb.toString();
	}

	public static void main(String[] args) throws IOException {
		String data = "{\r\n" + 
				"  \"deviceId\": \"1512016301\",\r\n" + 
				"  \"timestamp\": \"2018\",\r\n" + 
				"  \"values\": {\r\n" + 
				"    \"PressureLimitValue\": 0.4,\r\n" + 
				"    \"SetWakeUpPressure\": \"0\",\r\n" + 
				"    \"OutletPressure\": 0.5,\r\n" + 
				"    \"No3FrequencySpeed\": 2134.0,\r\n" + 
				"    \"GivenPressure\": 0.5,\r\n" + 
				"    \"No2FrequencyFailure\": \"0\",\r\n" + 
				"    \"No2FrequencyCurrent\": \"0\",\r\n" + 
				"    \"NegativeAlarm\": \"0\",\r\n" + 
				"    \"SleepTime\": 300.0,\r\n" + 
				"    \"OutletRange\": 16.0,\r\n" + 
				"    \"No3FrequencyTotalKWH\": 3393.0,\r\n" + 
				"    \"GivenPressureConfirm\": \"0\",\r\n" + 
				"    \"No3FrequencyRunningTime\": 5360.0,\r\n" + 
				"    \"Proportion\": 15.0,\r\n" + 
				"    \"No2FrequencyTemp\": 25.0,\r\n" + 
				"    \"No2FrequencyTotalKWH\": 3417.0,\r\n" + 
				"    \"No2FrequencyOper\": \"0\",\r\n" + 
				"    \"IncreasedPumpTime\": 30.0,\r\n" + 
				"    \"SetPressureCapValue\": \"0\",\r\n" + 
				"    \"ReducedPumpTime\": 5.0,\r\n" + 
				"    \"PressureCapValue\": 0.55,\r\n" + 
				"    \"SleepingFrequency\": 380.0,\r\n" + 
				"    \"No1FrequencyTemp\": 25.0,\r\n" + 
				"    \"No1FrequencyTotalKWH\": 3433.0,\r\n" + 
				"    \"InvertedPumpTime\": 240.0,\r\n" + 
				"    \"NegativePressureCapValue\": 0.1,\r\n" + 
				"    \"active_power\": 8666.45,\r\n" + 
				"    \"No3FrequencyCurrent\": 3.0,\r\n" + 
				"    \"StopAlarm\": \"0\",\r\n" + 
				"    \"No2PumpFailureAlarm\": \"0\",\r\n" + 
				"    \"NegativePressureLimitValue\": 0.1,\r\n" + 
				"    \"WaterFloodedAlarm\": \"0\",\r\n" + 
				"    \"No1RunningTime\": \"0\",\r\n" + 
				"    \"No1FrequencyOutput\": \"0\",\r\n" + 
				"    \"Integra\": 1.0,\r\n" + 
				"    \"No1FrequencyCurrent\": \"0\",\r\n" + 
				"    \"No3FrequencyOper\": 0.0,\r\n" + 
				"    \"No3FrequencyTemp\": 28.0,\r\n" + 
				"    \"No1FrequencyOper\": \"0\",\r\n" + 
				"    \"No3FrequencyOutput\": 36.0,\r\n" + 
				"    \"No2FrequencySpeed\": \"0\",\r\n" + 
				"    \"No3RunningTime\": 30.0,\r\n" + 
				"    \"SetGivenPressure\": \"0\",\r\n" + 
				"    \"No3FrequencyFailure\": \"0\",\r\n" + 
				"    \"UnderPressureAlarm\": \"0\",\r\n" + 
				"    \"No1FrequencyRunningTime\": 6527.0,\r\n" + 
				"    \"No3PumpFailureAlarm\": \"0\",\r\n" + 
				"    \"OverPressureAlarm\": \"0\",\r\n" + 
				"    \"InletPressure\": 0.25,\r\n" + 
				"    \"No1PumpFailureAlarm\": \"0\",\r\n" + 
				"    \"No1FrequencyFailure\": \"0\",\r\n" + 
				"    \"No2FrequencyOutput\": \"0\",\r\n" + 
				"    \"R_E_stop\": \"0\",\r\n" + 
				"    \"InletRange\": 10.0,\r\n" + 
				"    \"No1FrequencySpeed\": \"0\",\r\n" + 
				"    \"No2RunningTime\": \"0\",\r\n" + 
				"    \"PressureCapValueConfirm\": \"0\",\r\n" + 
				"    \"No2FrequencyRunningTime\": 6120.0,\r\n" + 
				"    \"WakeUpPressure\": 0.45\r\n" + 
				"  }\r\n" + 
				"}";	
		//System.out.print(read(data));
		RealTimeData targetData = parseObject(data, RealTimeData.class);
		
		String source = "{\r\n" + 
				"  \"deviceId\": \"1512016301\",\r\n" + 
				"  \"timestamp\": \"2018-04-09 13:44:08\",\r\n" + 
				"  \"values\": {\r\n" + 
				"    \"BoosterPumpAlarm\": 0.0,\r\n" + 
				"    \"GivenPressure\": 50.0,\r\n" + 
				"    \"GivenPressureConfirm\": 0.0,\r\n" + 
				"    \"HighPressureAlarm\": 0.0,\r\n" + 
				"    \"IncreasedPumpTime\": 30.0,\r\n" + 
				"    \"InletPressure\": 25.0,\r\n" + 
				"    \"InletRange\": 100.0,\r\n" + 
				"    \"Integra\": 1.0,\r\n" + 
				"    \"InvertedPumpTime\": 240.0,\r\n" + 
				"    \"NegativeAlarm\": 0.0,\r\n" + 
				"    \"NegativePressureCapValue\": 12.0,\r\n" + 
				"    \"NegativePressureLimitValue\": 8.0,\r\n" + 
				"    \"No1FrequencyCurrent\": 0.0,\r\n" + 
				"    \"No1FrequencyFailure\": 0.0,\r\n" + 
				"    \"No1FrequencyOper\": 0.0,\r\n" + 
				"    \"No1FrequencyOutput\": 0.0,\r\n" + 
				"    \"No1FrequencyRunningTime\": 6527.0,\r\n" + 
				"    \"No1FrequencySpeed\": 0.0,\r\n" + 
				"    \"No1FrequencyTemp\": 25.0,\r\n" + 
				"    \"No1FrequencyTotalKWH\": 3433.0,\r\n" + 
				"    \"No1PumpFailureAlarm\": 0.0,\r\n" + 
				"    \"No1RunningTime\": 0.0,\r\n" + 
				"    \"No2FrequencyCurrent\": 0.0,\r\n" + 
				"    \"No2FrequencyFailure\": 0.0,\r\n" + 
				"    \"No2FrequencyOper\": 0.0,\r\n" + 
				"    \"No2FrequencyOutput\": 0.0,\r\n" + 
				"    \"No2FrequencyRunningTime\": 6120.0,\r\n" + 
				"    \"No2FrequencySpeed\": 0.0,\r\n" + 
				"    \"No2FrequencyTemp\": 25.0,\r\n" + 
				"    \"No2FrequencyTotalKWH\": 3417.0,\r\n" + 
				"    \"No2PumpFailureAlarm\": 0.0,\r\n" + 
				"    \"No2RunningTime\": 0.0,\r\n" + 
				"    \"No3FrequencyCurrent\": 3.0,\r\n" + 
				"    \"No3FrequencyFailure\": 0.0,\r\n" + 
				"    \"No3FrequencyOper\": 1.0,\r\n" + 
				"    \"No3FrequencyOutput\": 36.0,\r\n" + 
				"    \"No3FrequencyRunningTime\": 5360.0,\r\n" + 
				"    \"No3FrequencySpeed\": 2134.0,\r\n" + 
				"    \"No3FrequencyTemp\": 28.0,\r\n" + 
				"    \"No3FrequencyTotalKWH\": 3393.0,\r\n" + 
				"    \"No3PumpFailureAlarm\": 0.0,\r\n" + 
				"    \"No3RunningTime\": 30.0,\r\n" + 
				"    \"OutletPressure\": 50.0,\r\n" + 
				"    \"OutletRange\": 160.0,\r\n" + 
				"    \"OverPressureAlarm\": 0.0,\r\n" + 
				"    \"PressureCapValue\": 55.0,\r\n" + 
				"    \"PressureCapValueConfirm\": 0.0,\r\n" + 
				"    \"PressureLimitValue\": 40.0,\r\n" + 
				"    \"Proportion\": 15.0,\r\n" + 
				"    \"R_E_stop\": 0.0,\r\n" + 
				"    \"ReducedPumpTime\": 5.0,\r\n" + 
				"    \"SetGivenPressure\": 0.0,\r\n" + 
				"    \"SetPressureCapValue\": 0.0,\r\n" + 
				"    \"SetPressureLimitValue\": 0.0,\r\n" + 
				"    \"SetWakeUpPressure\": 0.0,\r\n" + 
				"    \"SleepTime\": 300.0,\r\n" + 
				"    \"SleepingFrequency\": 380.0,\r\n" + 
				"    \"StopAlarm\": 0.0,\r\n" + 
				"    \"UnderPressureAlarm\": 0.0,\r\n" + 
				"    \"WakeUpPressure\": 46.0,\r\n" + 
				"    \"WakeUpPressureConfirm\": 0.0,\r\n" + 
				"    \"WaterFloodedAlarm\": 0.0,\r\n" + 
				"    \"active_power\": 8666.43\r\n" + 
				"  }\r\n" + 
				"}";		
		RealTimeData sourceData = parseObject(source, RealTimeData.class);
		
		Map<String, Object> targetMap = targetData.getValues();
		Map<String, Object> sourceMap = sourceData.getValues();
		
		sourceMap.forEach((serviceKey, serviceValue) -> {
			if (!targetMap.containsKey(serviceKey)) {
				System.out.println(serviceKey);
			}
			
		});
		
	}
	
	
	@Test
	public void test() {
		String textValue = String.valueOf(1.0);

        float value = Float.valueOf(textValue);
        if (value > 0) {
			
        	System.out.println(value);
		}
	}
}
