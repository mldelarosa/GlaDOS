package glados.controller.hardware.controller;

public interface PwmLedControllerInterface extends HardwareControllerInterface{
	public int getPwmHighStatePercentage();
	public void setPwmHighStatePercentage(int pwmHighStatePercentage);
	public void fadeOn();
	public void fadeOff();
}
