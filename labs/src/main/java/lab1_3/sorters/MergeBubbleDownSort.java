package lab1_3.sorters;

import java.util.Arrays;

public class MergeBubbleDownSort extends Sorters{

    @Override
    public void sortArray(int[] array) {
        BubbleDownSort bubbleDownSort = new BubbleDownSort();
        int[] firstSubarray = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] secondSubarray = Arrays.copyOfRange(array, array.length / 2, array.length);

        bubbleDownSort.sortArray(firstSubarray);
        bubbleDownSort.sortArray(secondSubarray);

        doMerge(array, firstSubarray, secondSubarray);
    }
}
