package glados.controller.hardware.controller;

public interface ServoControllerInterface extends HardwareControllerInterface {
	public int getMaxDegree();
	public int getMinDegree();
	
	public float getPwmPeriod();
	public int getCurrentyDutyCycle();
	public float getPwmPeriodForMaxPosition();
	public float getPwmPeriodForMinPosition();
	public float getPwmPeriodForNeutralPosition();
	
	public void setCurrentPosition(int newPos);
	public int getCurrentPosition();
	public void incrementPositionDegree();
	public void decrementPositionDegree();
}
