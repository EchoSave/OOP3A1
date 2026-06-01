package utilities;

import java.util.Comparator;

public class BaseAreaCompare implements Comparator<Shape>{
	
	@Override
	public int compare(Shape shape1, Shape shape2) {
		if(shape1.calcBaseArea() > shape2.calcBaseArea()) {
			return 1;
		}else if ( shape1.calcBaseArea() < shape2.calcBaseArea()) {
			return -1;
		}
		return 0;
	}
}
