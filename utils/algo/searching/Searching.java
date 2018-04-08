package utils.algo.searching;

import java.util.Arrays;
import java.util.List;

public class Searching {

    public enum Boundary {
        LOWER, UPPER
    }

    public static int binarySearch(long[] a, long key) {
        return Arrays.binarySearch(a, key);
    }

    public static <T> int boundarySearch(List<T> array, T key, Boundary bound) {
        int low = 0;
        int high = array.size();
        while (low < high) {
            final int mid = (low + high) >> 1;
            Comparable<? super T> midVal = (Comparable) array.get(mid);
            int cmp = midVal.compareTo(key);

            if ((bound.equals(Boundary.UPPER) && cmp < 0) || (bound.equals(Boundary.LOWER) && cmp <= 0)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
