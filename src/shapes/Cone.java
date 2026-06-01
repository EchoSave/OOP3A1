package shapes;

import utilities.Shape;

public class Cone extends Shape
{
	public double radius;
	

	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}


	public double getRadius() {
		return radius;
	}


	public void setRadius(double radius) {
		this.radius = radius;
	}


	@Override
	public String toString() {
		return "radius: " + radius + "\nheight: " + height;
	}
	
	

}
