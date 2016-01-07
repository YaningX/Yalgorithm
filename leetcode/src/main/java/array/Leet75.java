package array;

/**
 * Created by xuyaning on 7/1/16.
 */
public class Leet75 {
    public void sortColors(int[] A) {
        int zeroPosition = 0;
        int onePosition = 0;
        int twoPosition = 0;
        for(int i = 0; i < A.length; i++){
            if (A[i] == 0){
                A[twoPosition] = 2;
                A[onePosition] = 1;
                A[zeroPosition] = 0;
                zeroPosition++;
                onePosition++;
                twoPosition++;
            }
            else if (A[i] == 1){
                A[twoPosition] = 2;
                A[onePosition] = 1;
                onePosition++;
                twoPosition++;
            }
            else if (A[i] == 2){
                A[twoPosition] = 2;
                twoPosition++;
            }
        }
    }
}
