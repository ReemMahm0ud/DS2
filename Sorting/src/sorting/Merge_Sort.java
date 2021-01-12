package sorting;

public class Merge_Sort {

    void merge(int arr[], int startIndex, int middleIndex, int lastIndex) {

        int n1 = middleIndex - startIndex + 1;
        int n2 = lastIndex - middleIndex;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[startIndex + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[middleIndex + 1 + j];
        }

        int i = 0, j = 0, k = startIndex;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int[] list, int startIndex, int lastIndex) {
        if (startIndex < lastIndex) {

            int middleIndex = (startIndex + lastIndex) / 2;

            sort(list, startIndex, middleIndex);
            sort(list, middleIndex + 1, lastIndex);
            merge(list, startIndex, middleIndex, lastIndex);
        }
    }
}
