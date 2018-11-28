package lab1_3.sorters;

import java.util.Arrays;

public class MergeQuickSort extends Sorters{

    @Override
    public void sortArray(int[] array) {
        QuickSort quickSort = new QuickSort();
        int[] firstSubarray = Arrays.copyOfRange(array, 0, array.length/2);
        int[] secondSubarray = Arrays.copyOfRange(array, array.length/2, array.length);

        quickSort.sortArray(firstSubarray);
        quickSort.sortArray(secondSubarray);

        doMerge(array, firstSubarray, secondSubarray);
    }
}
