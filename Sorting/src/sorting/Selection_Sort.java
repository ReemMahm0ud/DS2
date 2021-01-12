package sorting;

public class Selection_Sort {

    void sort(int[] list) {

        int swap, i, j;

        for (i = 0; i < list.length - 1; i++) {
            for (j = i + 1; j < list.length; j++) {
                if (list[j] < list[i]) {
                    swap = list[i];
                    list[i] = list[j];
                    list[j] = swap;
                }
            }
        }
    }

}
