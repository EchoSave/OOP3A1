package utilities;

import java.util.Comparator;

public abstract class Prism extends Shape{

	double height;
	double side;
	public double calcVolume() {
		return 0;
	}
	public double calcBaseArea() {
		return 0;
	}
	public Prism(double height, double side) {
		super(height);
		this.height = height;
		this.side = side;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	@Override
	public String toString() {
		return "height: " + height + "\nside: " + side;
	}
	
	
}
