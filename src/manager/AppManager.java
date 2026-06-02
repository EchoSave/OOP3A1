package manager;

import java.io.*;
import java.util.*;

import shapes.*;
import utilities.*;
import benchmark.BenchmarkUtil;
import sorting.SortContext;

public class AppManager {

	private final String shapes1 = "res/shapes1.txt";
	private final String shapes2 = "res/shapes2.txt";
	private final String shapes3 = "res/shapes3.txt";

	Scanner userInput = new Scanner(System.in);
	public ArrayList<Shape> shapes = new ArrayList<>();

	public String fileChoice(String choice) {

		// Checks which file the user typed
		switch (choice.toLowerCase()) {
		case "shapes1":
		case "res/shapes1.txt":
			return shapes1;

		case "shapes2":
		case "res/shapes2.txt":
			return shapes2;

		case "shapes3":
		case "res/shapes3.txt":
			return shapes3;

		default:
			System.out.println("Invalid choice. Try: shapes1, shapes2, shapes3");
			return null;
		}
	}

	public void loadShapes() throws FileNotFoundException {

		System.out.println("Enter file: shapes1, shapes2, or shapes3");
		String userChoice = userInput.nextLine();

		String filePath = fileChoice(userChoice);

		if (filePath == null) {
			return;
		}

		File file = new File(filePath);

		try (Scanner readFile = new Scanner(file)) {

			// First line tells how many shapes are inside the file
			int numberOfShapes = Integer.parseInt(readFile.nextLine());

			for (int i = 0; i < numberOfShapes && readFile.hasNextLine(); i++) {

				// Read one shape line
				String line = readFile.nextLine().trim();

				// If blank line comes, skip it
				if (line.isEmpty()) {
					i--;
					continue;
				}

				// Split line into type, height, and side/radius
				String[] shape = line.split(" ");

				String type = shape[0];
				double height = Double.parseDouble(shape[1]);
				double sideOrRadius = Double.parseDouble(shape[2]);

				// Create correct shape object
				switch (type.toLowerCase()) {
				case "cone":
					shapes.add(new Cone(height, sideOrRadius));
					break;

				case "cylinder":
					shapes.add(new Cylinder(height, sideOrRadius));
					break;

				case "pyramid":
					shapes.add(new Pyramid(height, sideOrRadius));
					break;

				case "octagonalprism":
					shapes.add(new OctagonalPrism(height, sideOrRadius));
					break;

				case "pentagonalprism":
					shapes.add(new PentagonalPrism(height, sideOrRadius));
					break;

				case "triangularprism":
					shapes.add(new TriangularPrism(height, sideOrRadius));
					break;

				case "squareprism":
					shapes.add(new SquarePrism(height, sideOrRadius));
					break;
				}
			}
		}
	}

	public void sortBy() {

		System.out.println("Choose compare type: h for height, a for base area, v for volume");
		String choice = userInput.nextLine().toLowerCase();

		// Choose what property to sort by
		switch (choice) {
		case "h":
			Collections.sort(shapes);
			break;

		case "a":
			Collections.sort(shapes, new BaseAreaCompare());
			break;

		case "v":
			Collections.sort(shapes, new VolumeCompare());
			break;

		default:
			System.out.println("Invalid sorting method.");
			return;
		}
	}

	public void executeSortingAndBenchmarking() {

		SortContext sortContext = new SortContext();

		System.out.println("Choose sorting algorithm: b, s, i, m, q, or z");
		String choice = userInput.nextLine().toLowerCase();

		long timeTaken = 0;

		// Timer only measures selected sorting method
		switch (choice) {
		case "b":
			timeTaken = sortContext.runSort(() -> bubbleSort());
			break;

		case "s":
			timeTaken = sortContext.runSort(() -> selectionSort());
			break;

		case "i":
			timeTaken = sortContext.runSort(() -> insertionSort());
			break;

		case "m":
			timeTaken = sortContext.runSort(() -> mergeSort());
			break;

		case "q":
			timeTaken = sortContext.runSort(() -> quickSort());
			break;

		case "z":
			timeTaken = sortContext.runSort(() -> mySort());
			break;

		default:
			System.out.println("Invalid sorting algorithm.");
			return;
		}

		// Print first, every 1000th, and last shape
		OutputUtil.printSortedValues(shapes.toArray(new Shape[0]));

		// Print sorting time
		BenchmarkUtil.printBenchmark(timeTaken);
	}

	private void mySort() {
	}

	private void quickSort() {
	}

	private void mergeSort() {
	}

	private void insertionSort() {
	}

	private void selectionSort() {
	}

	private void bubbleSort() {
	}
}