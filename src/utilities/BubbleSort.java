package utilities;

import java.util.ArrayList;
import utilities.Shape;

public class BubbleSort implements Sorter {


	@Override
    public void sort(ArrayList<Shape> shapes, String type) {

        int n = shapes.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (compare(shapes.get(j), shapes.get(j + 1), type) < 0) {
                    Shape temp = shapes.get(j);
                    shapes.set(j, shapes.get(j + 1));
                    shapes.set(j + 1, temp);
                }
            }
        }
    }

	private int compare(Shape s1, Shape s2, String type) {
	    switch (type) {
	        case "h":
	            return s1.compareTo(s2);

	        case "a":
	            return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());

	        case "v":
	        	
	            return Double.compare(s1.calcVolume(), s2.calcVolume());
	    }
	    return 0;
	}


}