package glados.controller.hardware.model;

public class LedController extends HardwareController {
	private static final long serialVersionUID = -2052891950390587540L;
	private boolean isOn;

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}
}
