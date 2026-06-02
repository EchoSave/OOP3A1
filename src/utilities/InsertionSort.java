package utilities;

import java.util.ArrayList;
import utilities.Shape;

public class InsertionSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes) {

        int n = shapes.size();

        for (int i = 1; i < n; i++) {
            Shape key = shapes.get(i);
            int j = i - 1;

            while (j >= 0 && shapes.get(j).compareTo(key) < 0) {
                shapes.set(j + 1, shapes.get(j));
                j--;
            }

            shapes.set(j + 1, key);
        }
    }
}