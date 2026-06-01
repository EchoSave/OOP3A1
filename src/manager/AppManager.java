package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import shapes.Cone;

public class AppManager {

	private final String shape1 = "res/shapes1.txt";
	private final String shapes2 = "res/shapes2.txt";
	private final String shapes3 = "res/shapes3.txt";
	Scanner userInput = new Scanner(System.in);	
	
	public void loadShapes() throws FileNotFoundException {
		String fileChoice = userInput.nextLine();
		File file = new File(fileChoice);
		try(Scanner readFile = new Scanner(file)) {
			while(readFile.hasNext()) {
				String[] shape = readFile.nextLine().split(" ");
				String shapeType = shape[0];
				double shapeHeight = Double.parseDouble(shape[1]);
				if(shape[0].equalsIgnoreCase("Cone")) {
					double shapeRadius = Double.parseDouble(shape[2]);
					Cone cone = new Cone(shapeHeight, shapeRadius);
					
				}else if(shape[0].equalsIgnoreCase("Cylinder")){
					double shapeRadiue = Double.parseDouble(shape[2]);
				}
			}
		}
	}
	
}
