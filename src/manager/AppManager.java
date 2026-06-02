package manager;

import java.io.*;
import java.util.*;

import shapes.*;
import utilities.*;
import utilities.Sorter;  

public class AppManager {

	private final String shapes1 = "res/shapes1.txt";
	private final String shapes2 = "res/shapes2.txt";
	private final String shapes3 = "res/shapes3.txt";
	Scanner userInput = new Scanner(System.in);	
	public ArrayList<Shape> shapes = new ArrayList<>();
	
	// make sure file choices are in the res folder
	public String fileChoice(String choice) {
	    switch (choice.toLowerCase()) {
	        case "res/shapes1.txt": return shapes1;
	        case "res/shapes2.txt": return shapes2;
	        case "res/shapes3.txt": return shapes3;
	        default: 
	            System.out.println("Invalid choice. Try: shapes1, shapes2, shapes3");
	            return null;
	    }
	}

	// Get shapes
	public void loadShapes() throws FileNotFoundException {

	    System.out.println("Enter file: shapes1, shapes2, or shapes3");
	    String userChoice = userInput.nextLine(); // user enters one of the txt files

	    String filePath = fileChoice(userChoice);
	    if (filePath == null) return;

	    File file = new File(filePath);

	    try (Scanner readFile = new Scanner(file)) { 
	        while (readFile.hasNext()) {
	            String[] shape = readFile.nextLine().split(" ");
	            //readFile.nextLine(); I think this is a bug
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
	    //System.out.println(arrayOShapes);
	}
	
	public void sortWith() {
	    System.out.println("Choose algorithm (b=Bubble, s=Selection, i=Insertion, m=Merge, q=Quick, z=MySort):");

	    String choice = userInput.nextLine().toLowerCase();

	    Sorter sorter = null;

	    switch(choice) { // changes sort to the sort algorithm

			case "b": sorter = new BubbleSort(); break;
			case "s": sorter = new SelectionSort(); break;
			case "i": sorter = new InsertionSort(); break;
			case "m": sorter = new MergeSort(); break;
			case "q": sorter = new QuickSort(); break;
			case "z": sorter = new ShellSort(); break;

	        default:
	            System.out.println("Invalid choice");
	            return;
	    }
	    

		System.out.println("Sort by (h=height, a=area, v=volume):");
		String type = userInput.nextLine().toLowerCase();


	    long start = System.nanoTime(); // start the timer

	    sorter.sort(shapes, type);

	    long end = System.nanoTime(); // end timer


    	double timeMs = (end - start) / 1_000_000.0;
    	System.out.printf("Time taken: %.3f ms%n", timeMs);
    
	    
	    // OUTPUT //

	    // First element
	    Shape first = shapes.get(0);

	    if (type.equals("v")) {
	        System.out.println("First element is:    " + first.getClass().getName() +
	            "    Volume: " + first.calcVolume());
	    } 
	    else if (type.equals("a")) {
	        System.out.println("First element is:    " + first.getClass().getName() +
	            "    BaseArea: " + first.calcBaseArea());
	    } 
	    else {
	        System.out.println("First element is:    " + first);
	    }


	    // For every 1000th element

		for (int i = 0; i < shapes.size(); i++) {
		    if (i == 0 || i == shapes.size() - 1) continue;


	        Shape s = shapes.get(i);

	        if (type.equals("v")) {
	            System.out.println((i) + "000th element:    " +
	                s.getClass().getName() +
	                "    Volume: " + s.calcVolume());

	        } 
	        else if (type.equals("a")) {
	            System.out.println((i) + "000th element:    " +
	                s.getClass().getName() +
	                "    BaseArea: " + s.calcBaseArea());

	        } 
	        else {
	            System.out.println((i) + "000th element:    " + s);
	        }
	    }


	    // last element
	    Shape last = shapes.get(shapes.size() - 1);

	    if (type.equals("v")) {
	        System.out.println("Last element is:    " +
	            last.getClass().getName() +
	            "    Volume: " + last.calcVolume());
	    } 
	    else if (type.equals("a")) {
	        System.out.println("Last element is:    " +
	            last.getClass().getName() +
	            "    BaseArea: " + last.calcBaseArea());
	    } 
	    else {
	        System.out.println("Last element is:    " + last);
	    } 
	    
	}
}
