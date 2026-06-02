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

	    System.out.println("Time taken: " + (end - start) + " ns");

	    for (Shape s : shapes) {
	        System.out.println(s);
	    }
	}

			/*

	private void mySort() {
	    int n = shapes.size();

	    for (int gap = n / 2; gap > 0; gap /= 2) {
	        for (int i = gap; i < n; i++) {
	            Shape temp = shapes.get(i);
	            int j = i;

	            while (j >= gap && shapes.get(j - gap).compareTo(temp) < 0) {
	                shapes.set(j, shapes.get(j - gap));
	                j -= gap;
	            }

	            shapes.set(j, temp);
	        }
	    }
	}

	private void quickSort() {
	    quickSortRecursive(0, shapes.size() - 1);
	}

	private void quickSortRecursive(int low, int high) {
	    if (low < high) {
	        int pi = partition(low, high);
	        quickSortRecursive(low, pi - 1);
	        quickSortRecursive(pi + 1, high);
	    }
	}

	private int partition(int low, int high) {
	    Shape pivot = shapes.get(high);
	    int i = low - 1;

	    for (int j = low; j < high; j++) {
	        if (shapes.get(j).compareTo(pivot) > 0) {
	            i++;
	            Shape temp = shapes.get(i);
	            shapes.set(i, shapes.get(j));
	            shapes.set(j, temp);
	        }
	    }

	    Shape temp = shapes.get(i + 1);
	    shapes.set(i + 1, shapes.get(high));
	    shapes.set(high, temp);

	    return i + 1;
	}

	private void mergeSort() {
	    mergeSortRecursive(0, shapes.size() - 1);
	}

	private void mergeSortRecursive(int left, int right) {
	    if (left < right) {
	        int mid = (left + right) / 2;

	        mergeSortRecursive(left, mid);
	        mergeSortRecursive(mid + 1, right);

	        merge(left, mid, right);
	    }
	}

	private void merge(int left, int mid, int right) {
	    ArrayList<Shape> temp = new ArrayList<>();

	    int i = left;
	    int j = mid + 1;

	    while (i <= mid && j <= right) {
	        if (shapes.get(i).compareTo(shapes.get(j)) >= 0) {
	            temp.add(shapes.get(i));
	            i++;
	        } else {
	            temp.add(shapes.get(j));
	            j++;
	        }
	    }

	    while (i <= mid) {
	        temp.add(shapes.get(i));
	        i++;
	    }

	    while (j <= right) {
	        temp.add(shapes.get(j));
	        j++;
	    }

	    for (int k = 0; k < temp.size(); k++) {
	        shapes.set(left + k, temp.get(k));
	    }
	}

	private void insertionSort() {
	    int n = shapes.size();

	    for (int i = 1; i < n; i++) {
	        Shape key = shapes.get(i);
	        int j = i - 1;

	        while (j >= 0 && shapes.get(j).compareTo(key) < 0) {
	            shapes.set(j + 1, shapes.get(j));
	            j--;
	        }

	        shapes.set(j + 1, key);
	    }
	}

	private void selectionSort() {
	    int n = shapes.size();

	    for (int i = 0; i < n - 1; i++) {
	        int maxIndex = i;

	        for (int j = i + 1; j < n; j++) {
	            if (shapes.get(j).compareTo(shapes.get(maxIndex)) > 0) {
	                maxIndex = j;
	            }
	        }

	        Shape temp = shapes.get(maxIndex);
	        shapes.set(maxIndex, shapes.get(i));
	        shapes.set(i, temp);
	    }
	}

	private void bubbleSort() {
	    int n = shapes.size();

	    for (int i = 0; i < n - 1; i++) {
	        for (int j = 0; j < n - i - 1; j++) {
	            if (shapes.get(j).compareTo(shapes.get(j + 1)) < 0) {
	                Shape temp = shapes.get(j);
	                shapes.set(j, shapes.get(j + 1));
	                shapes.set(j + 1, temp);
	            }
	        }
	    }
	    
	    for (Shape s : shapes) {
	        System.out.println(s);
	    }
	}
	*/
}
