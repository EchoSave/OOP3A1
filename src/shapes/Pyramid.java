package shapes;

import utilities.Shape;

public class Pyramid extends Shape
{
	public double side;
	public Pyramid(double height, double side) {
		super(height);
		this.side = side;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	@Override
	public String toString() {
		return "side: " + side + "\nheight: " + getHeight();
	}
	public double calcVolume () {
		double volume = (1/3)*(Math.pow(side, 2))*height;
		return volume;
	}
	
	public double calcBaseArea() {
		double baseArea = Math.pow(side, 2);
		return baseArea;
	}
	
}
