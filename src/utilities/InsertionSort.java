package utilities;

import java.util.ArrayList;

public class InsertionSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes, String type) {

        for (int i = 1; i < shapes.size(); i++) {
            Shape key = shapes.get(i);
            int j = i - 1;

            while (j >= 0 && Sorter.compare(shapes.get(j), key, type) < 0) {
                shapes.set(j + 1, shapes.get(j));
                j--;
            }

            shapes.set(j + 1, key);
        }
    }
}