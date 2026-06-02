package shapes;

import utilities.Prism;

public class TriangularPrism extends Prism
{

	public TriangularPrism(double height, double side) {
		super(height, side);
		// TODO Auto-generated constructor stub
	}

	public double calcVolume () {
		double volume = calcBaseArea()*height;
		//System.out.println(volume);
		return volume;
	}
	
	public double calcBaseArea() {
		double baseArea = (Math.pow(side, 2) *Math.sqrt(3))/4;
		return baseArea;
	}

}
