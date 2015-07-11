import org.junit.Test;

import java.util.Arrays;

public class G4GTest {

    @Test
    public void findMaxProductTest() {
        int[] array = new int[] {1, 2, 3, -5, -7, 8, 0, 10};

        //Calculate the expectedResult by enumerate all possible pairs.
        long maxProduct = 0;
        int[] expectedResult = new int[] {0, 1};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] * array[j] > maxProduct) {
                    maxProduct = array[i] * array[j];
                    expectedResult[0] = array[i];
                    expectedResult[1] = array[j];
                }
            }
        }
        //The efficient method
        int[] result = G4GSolutions.findMaxProduct(array);
        if ((expectedResult[0] == result[0] && expectedResult[1] == result[1])
                || (expectedResult[0] == result[1] && expectedResult[1] == result[0])) {
            System.out.println("The right result is : " + Arrays.toString(result));
        } else {
            System.err.println("The result is wrong : " + Arrays.toString(result)
            + "\n while the right result is : " + Arrays.toString(expectedResult));
        }
    }
}
