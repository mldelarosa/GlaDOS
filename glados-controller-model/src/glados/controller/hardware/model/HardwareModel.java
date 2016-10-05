package glados.controller.hardware.model;

import java.io.Serializable;

public class HardwareModel implements Serializable {
	private static final long serialVersionUID = -2052891950390587540L;
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
