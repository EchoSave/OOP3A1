package shapes;

import utilities.Shape;

public class Cylinder extends Shape
{

	public double radius;
	
	public Cylinder(double height, double radius) {
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
	    return getClass().getSimpleName() +
	           " height=" + height +
	           " radius=" + radius;
	}




	public double calcVolume () {
		double volume = Math.PI*(Math.pow(radius, 2))*height;
		return volume;
	}
	
	public double calcBaseArea() {
		double baseArea = Math.PI*Math.pow(radius, 2);
		return baseArea;
	}

}
