package appDomain;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import manager.AppManager;
import manager.FileLoader;
import utilities.Shape;

/**
 * <p>
 * This application driver code is designed to be used as a basis for the
 * Complexity and Sorting assignment that will be developed in the CPRG304 
 * class at SAIT. The implementors of this applications will be required
 * to add all the correct functionality.
 * </p>
 */
public class AppDriver
{
	/**
	 *  The main method is the entry point of the application.
	 *  
	 *  @param args The input to control the execution of the application.
	 */
	public static void main( String[] args )
	{


		System.out.println("Sort by (h=height, a=area, v=volume):");
		//String choice = userInput.nextLine().toLowerCase();
		// Load shapes from file
        Shape[] shapeArray = null;
		try {
			shapeArray = FileLoader.loadShapes("res/shapes1.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Convert array → ArrayList (needed for your sorting)
        ArrayList<Shape> shapeList = new ArrayList<>(Arrays.asList(shapeArray));

        // Create AppManager and give it the shapes
        AppManager app = new AppManager();
        app.shapes = shapeList;


        

        // Run sorting
        app.sortWith();


		


		// refer to demo00 BasicFileIO.java for a simple example on how to
		// read data from a text file

		// refer to demo01 Test.java for an example on how to parse command
		// line arguments and benchmarking tests

		// refer to demo02 Student.java for comparable implementation, and
		// NameCompare.java or GradeCompare for comparator implementations

		// refer to demo02 KittySort.java on how to use a custom sorting
		// algorithm on a list of comparables to sort using either the
		// natural order (comparable) or other orders (comparators)

	}

}
