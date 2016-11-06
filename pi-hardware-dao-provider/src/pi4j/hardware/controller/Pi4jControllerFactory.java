package pi4j.hardware.controller;

import java.io.IOException;

import glados.controller.hardware.controller.HardwareControllerServiceInterface;
import glados.controller.hardware.controller.LedControllerInterface;
import glados.controller.hardware.controller.PwmLedControllerInterface;
import glados.controller.hardware.controller.ServoControllerInterface;

public class Pi4jControllerFactory implements HardwareControllerServiceInterface {
	
	private Pi4jHardwareConfig config;
	
	@Override
	public void init(String configResourceFilePath) {
		try {
			config = Pi4jHardwareConfig.loadYAML(configResourceFilePath);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize Pi4j hardware controller");
		}
	}
	
	@Override
	public LedControllerInterface getLedController(int pinNumber) {
		LedControllerImpl ledControllerToReturn = new LedControllerImpl(pinNumber);
		return ledControllerToReturn;
	}
	
	@Override
	public PwmLedControllerInterface getPwmLedController(int pinNumber) {
		return new PwmLedControllerImpl(pinNumber);
	}
	
	@Override
	public ServoControllerInterface getServoController(int pinNumber, String servoModel) {
		ServoControllerImpl servoControllerToReturn = null;
		if(servoModel.equalsIgnoreCase(config.mg90sServoModel)) {
			servoControllerToReturn = new ServoControllerImpl(
					config.mg90sServoMaxDegree,
					config.mg90sServoMinDegree,
					config.mg90sServoPwmPeriodMs,
					config.mg90sServoPwmPeriodForMaxPositionMs,
					config.mg90sServoPwmPeriodForMinPositionMs,
					config.mg90sServoPwmPeriodForNeutralPositionMs );
		} else {
			return null;
		}
		return servoControllerToReturn;
	}
}
