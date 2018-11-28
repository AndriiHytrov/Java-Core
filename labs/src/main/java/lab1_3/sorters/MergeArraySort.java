package lab1_3.sorters;

import java.util.Arrays;

public class MergeArraySort extends Sorters{

    @Override
    public void sortArray(int[] array) {
        ArraysSort arraysSort = new ArraysSort();
        int[] firstSubarray = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] secondSubarray = Arrays.copyOfRange(array, array.length / 2, array.length);

        arraysSort.sortArray(firstSubarray);
        arraysSort.sortArray(secondSubarray);

        doMerge(array, firstSubarray, secondSubarray);
    }
}