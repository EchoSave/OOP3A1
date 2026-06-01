package shapes;

import utilities.Prism;

public class OctagonalPrism extends Prism
{

	public OctagonalPrism(double height, double side) {
		super(height, side);
		// TODO Auto-generated constructor stub
	}

	public double calcVolume () {
		double volume = calcBaseArea()*height;
		return volume;
	}
	
	public double calcBaseArea() {
		double baseArea = 2*(1+Math.sqrt(2))*Math.pow(side, 2);
		return baseArea;
	}
}
