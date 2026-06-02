package appDomain;

import java.io.FileNotFoundException;

import benchmark.BenchmarkUtil;
import manager.ArgumentParser;
import manager.FileLoader;
import sorting.SortContext;
import utilities.OutputUtil;
import utilities.Shape;

public class AppDriver {

	public static void main(String[] args) {

		try {
			// Read command line values like -f, -t, and -s
			ArgumentParser parser = new ArgumentParser(args);

			// Load shapes from selected file
			Shape[] shapes = FileLoader.loadShapes(parser.getFileName());

			SortContext sortContext = new SortContext();

			long timeTaken = sortContext.runSort(() -> {
				
			});

			// Print required output after sorting
			OutputUtil.printSortedValues(shapes);

			// Print benchmark time
			BenchmarkUtil.printBenchmark(timeTaken);

		} catch (FileNotFoundException e) {
			System.out.println("File not found. Please check the file name.");
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}