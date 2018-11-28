package lab1_3.sorters;

import java.util.Arrays;

public class MergeBubbleUpSort extends Sorters{

    @Override
    public void sortArray(int[] array) {
        BubbleUpSort bubbleUpSort = new BubbleUpSort();
        int[] firstSubarray = Arrays.copyOfRange(array, 0, array.length/2);
        int[] secondSubarray = Arrays.copyOfRange(array, array.length/2, array.length);

        bubbleUpSort.sortArray(firstSubarray);
        bubbleUpSort.sortArray(secondSubarray);

        doMerge(array, firstSubarray, secondSubarray);
    }
}
