package glados.controller.hardware.controller;

public interface LedControllerInterface extends HardwareControllerInterface {
	public abstract boolean isOn();
	public abstract void toggle();
	public abstract void setOn();
	public abstract void setOff();
	public abstract void setHigh(boolean onHigh);
}
