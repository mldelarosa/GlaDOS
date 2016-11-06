package pi4j.hardware.controller;

import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class Pi4jHardwareConfig {
	
	protected String mg90sServoModel;
	protected int mg90sServoMaxDegree;
	protected int mg90sServoMinDegree;
	protected float mg90sServoPwmPeriodMs;
	protected float mg90sServoPwmPeriodForMaxPositionMs;
	protected float mg90sServoPwmPeriodForMinPositionMs;
	protected float mg90sServoPwmPeriodForNeutralPositionMs;
	
	public static Pi4jHardwareConfig loadYAML(String resourceFilePath) throws IOException {
		ObjectMapper mapper = new ObjectMapper(new YAMLFactory()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return (Pi4jHardwareConfig) mapper.readValue(Pi4jHardwareConfig.class.getClassLoader().getResourceAsStream(resourceFilePath), Pi4jHardwareConfig.class);
	}
}
