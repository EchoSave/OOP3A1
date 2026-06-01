package shapes;

import utilities.Prism;

public class SquarePrism extends Prism
{

	public SquarePrism(double height, double side) {
		super(height, side);
		// TODO Auto-generated constructor stub
	}

	public double calcVolume () {
		double volume = (Math.pow(side, 2))*height;
		return volume;
	}
	
	public double calcBaseArea() {
		double baseArea = Math.pow(side, 2);
		return baseArea;
	}

}
