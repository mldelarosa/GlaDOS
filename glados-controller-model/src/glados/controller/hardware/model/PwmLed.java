package glados.controller.hardware.model;

public class PwmLed extends Led {
	private static final long serialVersionUID = -2052891950390587540L;
	
	private int pwmValue;

	public int getPwmValue() {
		return pwmValue;
	}

	public void setPwmValue(int pwmValue) {
		this.pwmValue = pwmValue;
	}
}
