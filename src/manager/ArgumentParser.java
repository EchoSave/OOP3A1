package manager;

public class ArgumentParser {

	private String fileName;
	private char compareType;
	private char sortType;

	public ArgumentParser(String[] args) {
		parse(args);
		validate();
	}

	private void parse(String[] args) {
		for (String arg : args) {
			String currentArg = arg.trim().toLowerCase();

			if (currentArg.startsWith("-f")) {
				fileName = currentArg.substring(2);
			} else if (currentArg.startsWith("-t")) {
				compareType = currentArg.charAt(2);
			} else if (currentArg.startsWith("-s")) {
				sortType = currentArg.charAt(2);
			}
		}
	}

	private void validate() {
		if (fileName == null || fileName.isEmpty()) {
			throw new IllegalArgumentException("Invalid file path. Use: -fres/shapes1.txt");
		}

		if (compareType != 'h' && compareType != 'a' && compareType != 'v') {
			throw new IllegalArgumentException("Invalid compare type. Use h, a, or v.");
		}

		if (sortType != 'b' && sortType != 's' && sortType != 'i'
				&& sortType != 'm' && sortType != 'q' && sortType != 'z') {
			throw new IllegalArgumentException("Invalid sort type. Use b, s, i, m, q, or z.");
		}
	}

	public String getFileName() {
		return fileName;
	}

	public char getCompareType() {
		return compareType;
	}

	public char getSortType() {
		return sortType;
	}
}