package lab1_3.analyzer;


import lab1_3.sorters.Sorters;

public class Analyzer {

    public long SortTimeAnalyzer(int[] array, Sorters sort){
        long before = System.nanoTime();
        sort.sortArray(array);
        long after = System.nanoTime();
        System.out.println(after - before);
        return after - before;
    }
}
