package lab1_3.sorters;

public class QuickSort extends Sorters{

    @Override
    public void sortArray(int[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex, array);
    }


    private void doSort(int start, int end, int[] array) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, array);
        doSort(cur+1, end, array);
    }
}
