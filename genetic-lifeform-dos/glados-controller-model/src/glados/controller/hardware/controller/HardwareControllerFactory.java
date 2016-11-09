package glados.controller.hardware.controller;

import java.util.ServiceLoader;

public class HardwareControllerFactory {
	public static HardwareControllerFactoryInstance getInstance() {
		return HardwareControllerFactoryInstance.INSTANCE;
	}
	
	public enum HardwareControllerFactoryInstance {
		INSTANCE;
		
		private HardwareControllerServiceInterface hardwareControllerService;
				
		private HardwareControllerFactoryInstance() {
			System.out.println("Creating hardware controller via service loader");
			ServiceLoader<HardwareControllerServiceInterface> serviceLoader = ServiceLoader.load(HardwareControllerServiceInterface.class);
			if(!serviceLoader.iterator().hasNext()) {
				throw new RuntimeException("No service loader available for hardware controller service");
			}
			for(HardwareControllerServiceInterface service : serviceLoader) {
				System.out.println("Configuring via yaml: " + service.toString());
				service.init("hardware-config.yml");
				hardwareControllerService = service;
			}
			if(hardwareControllerService == null) {
				throw new RuntimeException("Failed to create instance of hardware controller factory");
			}
		}
		
		public HardwareControllerServiceInterface getHardwareController() {
			return hardwareControllerService;
		}
		
		public String getStatus() {
			return "Good";
		}
	}
}
