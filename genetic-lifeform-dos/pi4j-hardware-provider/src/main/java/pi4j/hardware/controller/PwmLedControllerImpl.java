package pi4j.hardware.controller;

import com.pi4j.wiringpi.Gpio;
import com.pi4j.wiringpi.SoftPwm;

import glados.controller.hardware.controller.PwmLedControllerInterface;

public class PwmLedControllerImpl extends HardwareControllerImpl implements PwmLedControllerInterface {
	
	private int pwmHighStatePercentage;
	
	public PwmLedControllerImpl(int pinNumber) {
		this.setPin(pinNumber);
		Gpio.wiringPiSetup();
		SoftPwm.softPwmCreate(pinNumber, 0, 100);
	}
	
	public int getPwmHighStatePercentage() {
		return pwmHighStatePercentage;
	}

	public void setPwmHighStatePercentage(int pwmHighPercentage) {
		pwmHighStatePercentage = pwmHighPercentage;
		SoftPwm.softPwmWrite(getPin(), getPwmHighStatePercentage());
	}

	public void fadeOn(int msSleepGap) {
		for(int i = pwmHighStatePercentage; i < 100; i++) {
			SoftPwm.softPwmWrite(getPin(), i);
			pwmHighStatePercentage = i;
			try {
				Thread.sleep(msSleepGap);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void fadeOff(int msSleepGap) {
		for(int i = pwmHighStatePercentage; i > 0; i--) {
			SoftPwm.softPwmWrite(getPin(), i);
			pwmHighStatePercentage = i;
			try {
				Thread.sleep(msSleepGap);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void fadeOn() {
		fadeOn(0);
	}

	public void fadeOff() {
		fadeOff(0);
	}

}
