package sorting;

public class Bubble_Sort {

    void sort(int[] list) {

        int swap, i, j;

        for (i = 0; i < list.length ; i++) {
            for (j = list.length - 1; j > 0; j--) {
                if (list[j] < list[j - 1]) {
                    swap = list[j - 1];
                    list[j - 1] = list[j];
                    list[j] = swap;
                }
            }
        }
    }
}
