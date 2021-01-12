package sorting;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        
        Bubble_Sort bubble = new Bubble_Sort();
        Heap_Sort heap = new Heap_Sort();
        Insertion_Sort insertion = new Insertion_Sort();
        Merge_Sort merge = new Merge_Sort();
        Quick_Sort quick = new Quick_Sort();
        Selection_Sort selection = new Selection_Sort();
        
        System.out.println("1-Bubble 2-Heap 3-Insertion 4-Merge 5-Quick 6-Selection");
        System.out.println("Enter sort type :");
        int x = scan.nextInt();
        System.out.println("Enter Number of elements : ");
        int numberOfList = scan.nextInt();

        int list[] = new int[numberOfList];

        for (int i = 0; i < list.length; i++) {
            list[i] = rand.nextInt(numberOfList) ;
        }
        
        double startTime = System.nanoTime();
        
        switch(x)
        {
            case 1:
                bubble.sort(list);
                break;
            case 2:
                heap.buildMaxHeap(list);
                break;
            case 3:
                insertion.sort(list);
                break;
            case 4:
                merge.sort(list, 0, list.length - 1);
                break;
            case 5:
                quick.sort(list, 0, list.length-1);
                break;
            case 6:
                selection.sort(list);
                break;    
        }
        
        
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }

        double endTime = System.nanoTime();
        double totalTime = endTime - startTime;
        System.out.println(totalTime*(Math.pow(10, -6)));
    }

}
