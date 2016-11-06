package pi4j.hardware.controller;

import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;

import glados.controller.hardware.controller.HardwareControllerInterface;

public class HardwareControllerImpl implements HardwareControllerInterface {
	
	private String name;
	private int pin;
	
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
	
	public Pin getRaspiPin() {
		return RaspiPin.getPinByAddress(pin);
	}
}
