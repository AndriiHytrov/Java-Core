package lab1_3.sorters;

public class BubbleDownSort extends BubbleSort{

    @Override
    public void sortArray(int[] array) {
        for (int i = array.length - 1, k = 0; i > 0; i--, k++) {
            for (int j = array.length - 1; j > k; j--) {
                if (array[j] < array[j - 1]) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
            }
        }
    }
}
