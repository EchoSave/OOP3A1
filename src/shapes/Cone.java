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
	    return getClass().getSimpleName() +
	           " height=" + height +
	           " radius=" + radius;
	}

	
	public double calcBaseArea() {
		//double baseArea = Math.pow(radius, 2);
		double baseArea = Math.pow(radius, 2);
		return baseArea;
	}

	public double calcVolume () {
		
		//double volume = (1/3)*Math.PI*(Math.pow(radius, 2))*height;
		double volume = (1.0/3.0) * Math.PI * Math.pow(radius, 2) * height;
		//System.out.println(volume);
		return volume;
	}
}
