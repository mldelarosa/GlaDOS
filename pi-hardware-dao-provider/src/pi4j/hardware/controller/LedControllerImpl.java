package pi4j.hardware.controller;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;
import glados.controller.hardware.controller.*;

public class LedControllerImpl extends HardwareControllerImpl implements LedControllerInterface {
	
	private GpioPinDigitalOutput pinOut;
	private GpioController gpioController;
	
	public LedControllerImpl(int pinNumber) {
		this.setPin(pinNumber);
		gpioController = GpioFactory.getInstance();
		pinOut = gpioController.provisionDigitalOutputPin(
				super.getRaspiPin(),
				super.getName(),
				PinState.LOW);
	}

	public boolean isOn() {
		return pinOut.getState().isHigh();
	}

	public void toggle() {
		pinOut.toggle();
	}

	public void setOn() {
		pinOut.setState(PinState.HIGH);
	}

	public void setOff() {
		pinOut.setState(PinState.LOW);
	}

	@Override
	public void setHigh(boolean onHigh) {
		if(onHigh) {
			setOn();
		} else {
			setOff();
		}
	}
}