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
	    return getClass().getSimpleName() +
	           " height=" + height +
	           " side=" + side;
	}

	public double calcVolume () {
		double volume = (1.0/3.0) * Math.pow(side, 2) * height;
		//System.out.println(volume);
		return volume;
	}
	
	public double calcBaseArea() {
		double baseArea = Math.pow(side, 2);
		return baseArea;
	}
	
}
