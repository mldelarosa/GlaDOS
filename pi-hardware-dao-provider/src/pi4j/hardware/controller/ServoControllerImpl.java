package pi4j.hardware.controller;

import java.io.IOException;

import com.pi4j.component.servo.ServoDriver;
import com.pi4j.component.servo.ServoProvider;
import com.pi4j.component.servo.impl.RPIServoBlasterProvider;
import com.pi4j.io.gpio.Pin;

import glados.controller.hardware.controller.ServoControllerInterface;

public class ServoControllerImpl extends HardwareControllerImpl implements ServoControllerInterface {
	
	int maxDegree;
	int minDegree;
	float pwmPeriod;
	int currentPwmDutyCycle;
	float pwmPeriodForMaxPosition;
	float pwmPeriodForMinPosition;
	float pwmPeriodForNeutralPosition;
	int currentDegree;
	ServoDriver servo;
	
	public ServoControllerImpl(
					int maxDegree,
					int minDegree,
					float pwmPeriod,
					float pwmPeriodForMaxPosition,
					float pwmPeriodForMinPosition,
					float pwmPeriodForNeutralPosition) {
		this.maxDegree = maxDegree;
		this.minDegree = minDegree;
		this.pwmPeriod = pwmPeriod;
		this.pwmPeriodForMaxPosition = pwmPeriodForMaxPosition;
		this.pwmPeriodForNeutralPosition = pwmPeriodForNeutralPosition;
		
		try {
			ServoProvider servoProvider = new RPIServoBlasterProvider();
			servo = servoProvider.getServoDriver((Pin)servoProvider.getDefinedServoPins().get(this.getPin()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	private float mapPositionToPwmCycle(int position) {
		int posRange = maxDegree - minDegree;
		float pwmRange = pwmPeriodForMaxPosition - pwmPeriodForMinPosition;
		
		long temp = (long)pwmRange / (long)posRange;
		float fTemp = (float)temp;
		
		float pwmCycle = (float)pwmPeriodForMinPosition + (fTemp);
		return pwmCycle;
	}
	
	public void setCurrentPosition(int newPos) {
		float destPwmCycle = mapPositionToPwmCycle(newPos);
		int destPulseWidth = (int)((servo.getServoPulseResolution() * destPwmCycle) / pwmPeriod);
		servo.setServoPulseWidth(destPulseWidth);
	}
	
	public int getMaxDegree() {
		return maxDegree;
	}

	public int getMinDegree() {
		return minDegree;
	}

	public float getPwmPeriod() {
		return pwmPeriod;
	}

	public int getCurrentyDutyCycle() {
		return currentPwmDutyCycle;
	}

	public float getPwmPeriodForMaxPosition() {
		return pwmPeriodForMaxPosition;
	}

	public float getPwmPeriodForMinPosition() {
		return pwmPeriodForMinPosition;
	}
	
	public float getPwmPeriodForNeutralPosition() {
		return pwmPeriodForNeutralPosition;
	}

	public int getCurrentPosition() {
		return currentDegree;
	}

	public void incrementPositionDegree() {
		if(getCurrentPosition() < getMaxDegree()) {
			
		}
	}

	public void decrementPositionDegree() {
		if(getCurrentPosition() > getMinDegree()) {
			
		}
	}
	
}
