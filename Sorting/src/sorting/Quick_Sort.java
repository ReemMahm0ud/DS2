package sorting;

import java.util.Random;

public class Quick_Sort {
    
    
 
    void sort(int list[],int lowerIndex, int higherIndex) {
         
        int i = lowerIndex,j = higherIndex;
        
        Random rnd = new Random();
        
        int pivot = list[lowerIndex + rnd.nextInt(higherIndex - lowerIndex)];
        
        while (i < j) {
            
            while (list[i] < pivot) {
                i++;
            }
            while (list[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                i++;
                j--;
            }
        }
        if (lowerIndex < j)
            sort(list,lowerIndex, j);
        if (i < higherIndex)
            sort(list,i, higherIndex);
    }
 
}
