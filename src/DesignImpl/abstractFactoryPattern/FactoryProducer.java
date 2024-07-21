package DesignImpl.abstractFactoryPattern;

public class FactoryProducer {
	public static AbstractFactory getFactory(String choice) {
		
		AbstractFactory entry = null;
		switch(choice) {
		case "SHAPE":
			entry = new ShapeFactory();
			break;
		case "COLOR":
			entry = new ColorFactory();
			break;
		default:
			throw new IllegalArgumentException();
		}
		return entry;
	}
}