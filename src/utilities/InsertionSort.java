package utilities;

import java.util.ArrayList;

public class InsertionSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes, String type) {

        for (int i = 1; i < shapes.size(); i++) {
            Shape key = shapes.get(i);
            int j = i - 1;

            while (j >= 0 && compare(shapes.get(j), key, type) < 0) {
                shapes.set(j + 1, shapes.get(j));
                j--;
            }

            shapes.set(j + 1, key);
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