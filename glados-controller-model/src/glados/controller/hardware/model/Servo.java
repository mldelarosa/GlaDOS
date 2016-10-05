package glados.controller.hardware.model;

public class Servo {
	private static final long serialVersionUID = -2052891950390587540L;
	private int currentPosition;
	private int maxPosition;
	private int minPosition;
	
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	public int getMaxPosition() {
		return maxPosition;
	}
	public void setMaxPosition(int maxPosition) {
		this.maxPosition = maxPosition;
	}
	public int getMinPosition() {
		return minPosition;
	}
	public void setMinPosition(int minPosition) {
		this.minPosition = minPosition;
	}
	
}
