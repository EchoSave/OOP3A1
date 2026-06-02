package utilities;

public class OutputUtil {

	public static void printSortedValues(Shape[] shapes) {

		if (shapes == null || shapes.length == 0) {
			System.out.println("No shapes to display.");
			return;
		}

		System.out.println("First element is:");
		System.out.println(shapes[0]);

		for (int i = 999; i < shapes.length; i = i + 1000) {
			System.out.println((i + 1) + "-th element:");
			System.out.println(shapes[i]);
		}

		System.out.println("Last element is:");
		System.out.println(shapes[shapes.length - 1]);
	}
}