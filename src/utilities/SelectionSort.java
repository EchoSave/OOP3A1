package utilities;

import java.util.ArrayList;

public class SelectionSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes, String type) {

        int n = shapes.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (Sorter.compare(shapes.get(j), shapes.get(maxIndex), type) > 0) {
                    maxIndex = j;
                }
            }

            Shape temp = shapes.get(maxIndex);
            shapes.set(maxIndex, shapes.get(i));
            shapes.set(i, temp);
        }
    }


}