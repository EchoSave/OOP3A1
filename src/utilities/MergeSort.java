package utilities;

import java.util.ArrayList;

public class MergeSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes, String type) {
        mergeSort(shapes, 0, shapes.size() - 1, type);
    }

    private void mergeSort(ArrayList<Shape> shapes, int left, int right, String type) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(shapes, left, mid, type);
            mergeSort(shapes, mid + 1, right, type);

            merge(shapes, left, mid, right, type);
        }
    }

    private void merge(ArrayList<Shape> shapes, int left, int mid, int right, String type) {

        ArrayList<Shape> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (compare(shapes.get(i), shapes.get(j), type) >= 0) {
                temp.add(shapes.get(i++));
            } else {
                temp.add(shapes.get(j++));
            }
        }

        while (i <= mid) temp.add(shapes.get(i++));
        while (j <= right) temp.add(shapes.get(j++));

        for (int k = 0; k < temp.size(); k++) {
            shapes.set(left + k, temp.get(k));
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