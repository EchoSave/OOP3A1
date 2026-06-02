package utilities;

import java.util.ArrayList;
import utilities.Shape;

public class SelectionSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes) {

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
}