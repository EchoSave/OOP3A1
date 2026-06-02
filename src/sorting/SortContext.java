package sorting;

import benchmark.BenchmarkUtil;

public class SortContext {

	public long runSort(Runnable sortMethod) {

		// Start timer before sorting
		long startTime = BenchmarkUtil.startTimer();

		// Run selected sorting method
		sortMethod.run();

		// Stop timer after sorting
		long endTime = BenchmarkUtil.stopTimer();

		// Return only sorting time
		return BenchmarkUtil.getElapsedTime(startTime, endTime);
	}
}