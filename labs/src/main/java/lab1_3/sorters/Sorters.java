package lab1_3.sorters;

public abstract class Sorters {

    public abstract void sortArray(int[] array);

    protected void doMerge(int[] array, int[] firstSubarray, int[] secondSubarray) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (j < firstSubarray.length && k < secondSubarray.length) {
            if (firstSubarray[j] < secondSubarray[k]) {
                array[i] = firstSubarray[j];
                i++;
                j++;

            } else {
                array[i] = secondSubarray[k];
                i++;
                k++;
            }
        }
        if (j < firstSubarray.length) {
            while (j < firstSubarray.length) {
                array[j + k] = firstSubarray[j];
                j++;
            }
        } else if (k < secondSubarray.length) {
            while (k < secondSubarray.length) {
                array[j + k] = secondSubarray[k];
                k++;
            }
        }
    }
}
