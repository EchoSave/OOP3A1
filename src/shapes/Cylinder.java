package shapes;

import utilities.Shape;

public class Cylinder extends Shape
{

	public double radius;
	
	public Cylinder(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	public double calcVolume () {
		return 0;
	}
	
	public double calcBaseArea() {
		return 0;
	}

}
