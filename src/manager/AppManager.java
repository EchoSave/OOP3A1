package manager;

import java.io.*;
import java.util.*;

import shapes.*;
import utilities.*;

public class AppManager {

	private final String shapes1 = "res/shapes1.txt";
	private final String shapes2 = "res/shapes2.txt";
	private final String shapes3 = "res/shapes3.txt";
	Scanner userInput = new Scanner(System.in);	
	public ArrayList<Shape> shapes = new ArrayList<>();
	
	public String fileChoice(String choice) {
	    switch (choice.toLowerCase()) {
	        case "res/shapes1.txt": return shapes1;
	        case "res/shapes2.txt": return shapes2;
	        case "sres/shapes3.txt": return shapes3;
	        default: 
	            System.out.println("Invalid choice. Try: shapes1, shapes2, shapes3");
	            return null;
	    }
	}

	
	public void loadShapes() throws FileNotFoundException {

	    System.out.println("Enter file: shapes1, shapes2, or shapes3");
	    String userChoice = userInput.nextLine();

	    String filePath = fileChoice(userChoice);
	    if (filePath == null) return;

	    File file = new File(filePath);

	    try (Scanner readFile = new Scanner(file)) {
	        while (readFile.hasNext()) {
	            String[] shape = readFile.nextLine().split(" ");
	            readFile.nextLine();
	            String type = shape[0];
	            double height = Double.parseDouble(shape[1]);
	            double sideOrRadius = Double.parseDouble(shape[2]);

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
	    Shape[] arrayOShapes = shapes.toArray(new Shape[0]);
	}

	public void sortBy() {
	    //System.out.println("Choose sorting method (height, basearea, volume):");
	    String choice = userInput.nextLine().toLowerCase();

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

	    // Print results
	    for (Shape s : shapes) {
	        System.out.println(s);
	    }
	}

	public void sortWith() {
		String choice = userInput.nextLine().toLowerCase();
		
		switch(choice) {
		case "b": bubbleSort(); break;
		case "s": selectionSort(); break;
		case "i": insertionSort(); break;
		case "m": mergeSort(); break;
		case "q": quickSort(); break;
		case "z": mySort(); break;
		}
	}


	private void mySort() {
		// TODO Auto-generated method stub
		
	}


	private void quickSort() {
		// TODO Auto-generated method stub
		
	}


	private void mergeSort() {
		// TODO Auto-generated method stub
		
	}


	private void insertionSort() {
		// TODO Auto-generated method stub
		
	}


	private void selectionSort() {
		// TODO Auto-generated method stub
		
	}


	private void bubbleSort() {
		// TODO Auto-generated method stub
		
	}
}
