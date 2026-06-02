package benchmark;

public class BenchmarkUtil {

    public static long startTimer() {
        return System.nanoTime();
    }

    public static long stopTimer() {
        return System.nanoTime();
    }

    public static long getElapsedTime(long startTime, long endTime) {
        return endTime - startTime;
    }

    public static void printBenchmark(long timeTaken) {
        System.out.println("Benchmark Time: " + timeTaken + " ns");
    }
}