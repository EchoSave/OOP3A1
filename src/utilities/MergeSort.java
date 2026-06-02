package utilities;

import java.util.ArrayList;


public class MergeSort implements Sorter {

    @Override
    public void sort(ArrayList<Shape> shapes) {
        mergeSortRecursive(shapes, 0, shapes.size() - 1);
    }

    private void mergeSortRecursive(ArrayList<Shape> shapes, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSortRecursive(shapes, left, mid);
            mergeSortRecursive(shapes, mid + 1, right);

            merge(shapes, left, mid, right);
        }
    }

    private void merge(ArrayList<Shape> shapes, int left, int mid, int right) {

        ArrayList<Shape> temp = new ArrayList<>();

        int i = left;
        int j = mid + 1;

        while (i <= mid && j <= right) {
            if (shapes.get(i).compareTo(shapes.get(j)) >= 0) {
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
}