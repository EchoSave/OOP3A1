package utilities;package utilities.util.ArrayList;

import java.util.ArrayList;

public class QuickSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes, String type) {
        quickSort(shapes, 0, shapes.size() - 1, type);
    }

    private void quickSort(ArrayList<Shape> shapes, int low, int high, String type) {
        if (low < high) {
            int pi = partition(shapes, low, high, type);

            quickSort(shapes, low, pi - 1, type);
            quickSort(shapes, pi + 1, high, type);
        }
    }

    private int partition(ArrayList<Shape> shapes, int low, int high, String type) {

        Shape pivot = shapes.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(shapes.get(j), pivot, type) > 0) {
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

    private int compare(Shape s1, Shape s2, String type) {
        switch (type) {
            case "h": return s1.compareTo(s2);
            case "a": return Double.compare(s1.calcBaseArea(), s2.calcBaseArea());
            case "v": return Double.compare(s1.calcVolume(), s2.calcVolume());
        }
        return 0;
    }
}


