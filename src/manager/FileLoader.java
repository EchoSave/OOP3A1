package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utilities.Shape;

public class FileLoader {

	public static Shape[] loadShapes(String filePath) throws FileNotFoundException {

		File file = new File(filePath);
		Scanner readFile = new Scanner(file);

		// First line tells how many shapes are in the file
		int numberOfShapes = Integer.parseInt(readFile.nextLine());

		Shape[] shapes = new Shape[numberOfShapes];

		int index = 0;

		while (readFile.hasNextLine() && index < numberOfShapes) {

			String line = readFile.nextLine().trim();

			// Skip empty lines if there are any
			if (line.isEmpty()) {
				continue;
			}

			String[] parts = line.split(" ");

			String type = parts[0];
			double height = Double.parseDouble(parts[1]);
			double sideOrRadius = Double.parseDouble(parts[2]);

			shapes[index] = ShapeFactory.createShape(type, height, sideOrRadius);

			index++;
		}

		readFile.close();

		return shapes;
	}
}