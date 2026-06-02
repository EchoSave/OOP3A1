package utilities;

import java.util.ArrayList;

public class ShellSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes, String type) {

        int n = shapes.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                Shape temp = shapes.get(i);
                int j = i;

                while (j >= gap && compare(shapes.get(j - gap), temp, type) < 0) {
                    shapes.set(j, shapes.get(j - gap));
                    j -= gap;
                }

                shapes.set(j, temp);
            }
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