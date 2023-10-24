package KWICParnas.My_Object_Oriented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
    private ArrayList<String> kwicList;

    public Alphabetizer(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    public void sort() {
        quickSort(0, kwicList.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        String pivot = kwicList.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (kwicList.get(j).compareToIgnoreCase(pivot) <= 0) {
                i++;
                Collections.swap(kwicList, i, j);
            }
        }
        Collections.swap(kwicList, i + 1, high);
        return i + 1;
    }

    private class AlphabetizerComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            if (o1 == null && o2 == null) {
                throw new NullPointerException();
            }
            int compareValue = 0;
            char o1c = o1.toLowerCase().charAt(0); //忽略大小写
            char o2c = o2.toLowerCase().charAt(0); //忽略大小写
            compareValue = o1c - o2c;
            return compareValue;

        }

    }
}
