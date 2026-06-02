package utilities;


import java.util.ArrayList;
import utilities.Shape;

public class ShellSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes) {

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
}
