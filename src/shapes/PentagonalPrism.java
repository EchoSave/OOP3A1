package shapes;

import utilities.Prism;

public class PentagonalPrism extends Prism
{

	public PentagonalPrism(double height, double side) {
		super(height, side);
		// TODO Auto-generated constructor stub
	}

	public double calcVolume () {
		double volume = calcBaseArea()*height;
		return volume;
	}
	
	public double calcBaseArea() {
		double baseArea = (5*Math.pow(side, 2)*Math.tan(54))/4;
		return baseArea;
	}
}
