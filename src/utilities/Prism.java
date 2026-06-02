package utilities;

public abstract class Prism extends Shape{

	public double height;
	public double side;
	public double calcVolume() {
		System.out.println("1");
		return 0;
	}
	public double calcBaseArea() {
		System.out.println("2");
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
	    return getClass().getSimpleName() +
	           " height=" + height +
	           " side=" + side;
	}

	
}
