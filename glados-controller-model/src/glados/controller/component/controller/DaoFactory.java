package glados.controller.component.controller;

public class DaoFactory {
	
	public static DaoFactoryImpl getInstance() {
		return DaoFactoryImpl.INSTANCE;
	}
	
	public enum DaoFactoryImpl {
		INSTANCE;
		
		
	}
	
}
