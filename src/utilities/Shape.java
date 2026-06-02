package utilities;

public abstract class Shape implements Comparable<Shape>{

	public double height;
	public double calcVolume() {
		System.out.println("3");
		return 0;
		
	}
	public double calcBaseArea() {
		System.out.println("4");
		return 0;
	}
	public Shape(double height) {
		super();
		this.height = height;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	
	@Override
	public String toString() {
	    return getClass().getSimpleName() +
	           " height=" + height +
	           " volume=" + calcVolume() +
	           " baseArea=" + calcBaseArea();
	}


	
	public int compareTo(Shape shape){
		if ( this.getHeight() > shape.getHeight() ) return 1;
		else if ( this.getHeight() < shape.getHeight() ) return -1;
		else return 0;
	}
	
//	public int compareBaseArea(Shape shape1, Shape shape2) {
//		if( shape1.calcBaseArea() > shape2.calcBaseArea()) return 1;
//		else if (shape1.calcBaseArea() < shape2.calcBaseArea()) return -1;
//		return 0;
//		
//	}
//	
//	public int comapreVolume(Shape shape1, Shape shape2) {
//		if(shape1.calcVolume() > shape2.calcVolume()) return 1;
//		else if (shape1.calcVolume() < shape2.calcVolume()) return -1;
//		return 0;
//	}
}
