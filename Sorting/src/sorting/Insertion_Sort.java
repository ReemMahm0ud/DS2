package sorting;

public class Insertion_Sort {

    void sort(int[] list) {

        int swap, i, j;

        for (i = 1; i < list.length; i++) {
            for (j = i - 1; j >= 0; j--) {
                if (list[j + 1] < list[j]) {
                    swap = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = swap;
                }
            }
        }
    }
}
