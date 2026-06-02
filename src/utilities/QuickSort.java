package utilities;

import java.util.ArrayList;
import utilities.Shape;

public class QuickSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes) {
        quickSort(shapes, 0, shapes.size() - 1);
    }

    private void quickSort(ArrayList<Shape> shapes, int low, int high) {
        if (low < high) {
            int pi = partition(shapes, low, high);

            quickSort(shapes, low, pi - 1);
            quickSort(shapes, pi + 1, high);
        }
    }

    private int partition(ArrayList<Shape> shapes, int low, int high) {

        Shape pivot = shapes.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (shapes.get(j).compareTo(pivot) > 0) {
                i++;
                Shape temp = shapes.get(i);
                shapes.set(i, shapes.get(j));
                shapes.set(j, temp);
            }
        }

        Shape temp = shapes.get(i + 1);
        shapes.set(i + 1, shapes.get(high));
        shapes.set(high, temp);

        return i + 1;
    }
}