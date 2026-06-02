package utilities;

import java.util.ArrayList;

public class SelectionSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes, String type) {

        int n = shapes.size();

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (compare(shapes.get(j), shapes.get(maxIndex), type) > 0) {
                    maxIndex = j;
                }
            }

            Shape temp = shapes.get(maxIndex);
            shapes.set(maxIndex, shapes.get(i));
            shapes.set(i, temp);
        }
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