package Imp;

public class mainEntry {

	public static void main(String[] args) {
		CallMethod method = new CallMethod();
		method.callAdapterPattern(false);
		method.callBridgePattern(false);
		method.callObserverPattern(true);
	}
	
}
