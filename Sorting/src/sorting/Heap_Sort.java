package sorting;

public class Heap_Sort {

    public void buildMaxHeap(int list[]) {

        for (int lastparent = list.length / 2 - 1; lastparent >= 0; lastparent--) {
            maxHeapify(list, list.length, lastparent);
        }

        for (int i = list.length - 1; i >= 0; i--) {
            
            int temp = list[0];
            list[0] = list[i];
            list[i] = temp;
            
            maxHeapify(list, i, 0);

        }
    }

    void maxHeapify(int list[], int arraylength, int lastparent) {

        int largest = lastparent;
        int l = 2 * lastparent + 1;
        int r = 2 * lastparent + 2;

        if (l < arraylength && list[l] > list[largest]) {
            largest = l;
        }

        if (r < arraylength && list[r] > list[largest]) {
            largest = r;
        }

        if (largest != lastparent) {
            int swap = list[lastparent];
            list[lastparent] = list[largest];
            list[largest] = swap;

            maxHeapify(list, arraylength, largest);
        }
    }
}
