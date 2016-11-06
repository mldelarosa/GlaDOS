package glados.controller.hardware.controller;

public interface HardwareControllerServiceInterface {
	public void init(String configResourceName);
	
	public LedControllerInterface getLedController(int pinNumber);
	public PwmLedControllerInterface getPwmLedController(int pinNumber);
	public ServoControllerInterface getServoController(int pinNumber, String servoModel);
}
