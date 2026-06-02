package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utilities.Shape;

public class FileLoader {
	public static Shape[] loadShapes(String filePath) throws FileNotFoundException {
		System.out.println("Enter file: shapes1, shapes2, or shapes3");
		File file = new File(filePath);
		
		Scanner readFile = new Scanner(file);
		
		int numberOfShapes = Integer.parseInt(readFile.nextLine());
		
		// Create list of shapes based on the file (first line in file path)
		Shape[] shapes = new Shape[numberOfShapes];
		
		int index = 0;
		while (readFile.hasNextLine() && index < numberOfShapes) {
			String line = readFile.nextLine().trim();
			
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
