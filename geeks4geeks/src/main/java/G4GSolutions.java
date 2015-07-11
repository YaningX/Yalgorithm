public class G4GSolutions {
    /**
     * Find a pair with maximum product in array of Integers.
     * Given an array with both +ive and -ive integers, return a pair with highest product.
     * Examples:
     * Input: arr[] = {1, 4, 3, 6, 7, 0}
     * Output: {6,7}
     * Input: arr[] = {-1, -3, -4, 2, 0, -5}
     * Output: {-4,-5}
     * source: http://www.geeksforgeeks.org/return-a-pair-with-maximum-product-in-array-of-integers/
     */
    public static int[] findMaxProduct(int[] array) {
        if (array.length == 0) {
            return null;
        }
        if (array.length == 1) {
            return array;
        }
        int[] posMax = new int[] {0, 0};//This is how to initialize an array with initial value in java; otherwise int[] posMax = new int[2] with a size;
        int[] negMax = new int[] {0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] > posMax[0]) {
                posMax[1] = posMax[0];
                posMax[0] = array[i];
            }
            if (array[i] < negMax[0]) {
                negMax[1] = negMax[0];
                negMax[0] = array[i];
            }
        }
        if (posMax[0] * posMax[1] > negMax[0] * negMax[1]) {
            return posMax;
        } else {
            return negMax;
        }
    }
}
