package DesignImpl.Bridge;

public abstract class Shape2 {
	protected DrawAPI drawAPI;

	protected Shape2(DrawAPI drawAPI) {
		this.drawAPI = drawAPI;
	}

	public abstract void draw();
}