package manager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import utilities.Shape;

public class ArgumentParser {
	private String fileName;
	private char compareType;
	private char sortType;
	
	public ArgumentParser (String[] args) {
		parse(args);
		validate();
	}
	
	private void parse(String[] args) {
		Shape[] shapeArray = null;
		AppManager app = new AppManager();
		
		for (String arg : args) {
			String currentArg = arg.trim().toLowerCase();
			
			if (currentArg.startsWith("-f")) {
				fileName = currentArg.substring(2);
				try { 
			        shapeArray = FileLoader.loadShapes("res/" + fileName);
			    } catch (FileNotFoundException e) {
			        e.printStackTrace();
			    }
				ArrayList<Shape> shapeList = new ArrayList<>(Arrays.asList(shapeArray));
				
			    app.shapes = shapeList;
				
			} else if (currentArg.startsWith("-t")) {
				compareType = currentArg.charAt(2);
			
			} else if (currentArg.startsWith("-s")) {
				sortType = currentArg.charAt(2);			
			}		
		}
		app.sortWith(compareType, sortType);
	}
	private void validate() {
		if (fileName == null || fileName.isEmpty()) { 
			throw new IllegalArgumentException( "Invalid file path. Use: -fshapes1.txt, -fshapes2.txt, -fshapes3.txt"); 
		} 
		
		if (compareType != 'h' && compareType != 'a' && compareType != 'v') {
			throw new IllegalArgumentException( "Invalid compare type. Use h, a, or v."); 
		} 
		
		if (sortType != 'b' 
				&& sortType != 's'
				&& sortType != 'i' 
				&& sortType != 'm' 
				&& sortType != 'q' 
				&& sortType != 'z') {
			throw new IllegalArgumentException( "Invalid sort type. Use b, s, i, m, q, or z."); 
		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public char getCompareType() {
		return compareType;
	}

	public void setCompareType(char compareType) {
		this.compareType = compareType;
	}

	public char getSortType() {
		return sortType;
	}

	public void setSortType(char sortType) {
		this.sortType = sortType;
	}

	@Override
	public String toString() {
		return "ArgumentParser [fileName=" + fileName + ", compareType=" + compareType + ", sortType=" + sortType + "]";
	}
	
	
}
