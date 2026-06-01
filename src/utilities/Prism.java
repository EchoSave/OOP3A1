package utilities;

import java.util.Comparator;

public abstract class Prism {

	double height;
	double side;
	double calcVolume() {
		return 0;
	}
	double calcBaseArea() {
		return 0;
	}
	public Prism(double height, double side) {
		super();
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
