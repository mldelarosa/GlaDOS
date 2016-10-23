package glados.controller.hardware.model;

import java.io.Serializable;

public class HardwareController implements Serializable {
	private static final long serialVersionUID = -2052891950390587540L;
	protected String name;
	protected int pin;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
}
