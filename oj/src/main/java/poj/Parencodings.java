package poj;

import java.util.Scanner;
import java.util.Stack;

/**
 * http://poj.org/problem?id=1068
 */
public class Parencodings {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] pNums = new int[n];
            for (int j = 0; j < n; j++) {
                pNums[j] = in.nextInt();
            }
            int[] wNums = Parencodings.solve(pNums);
            for (int j = 0; j < n; j++) {
                System.out.print(wNums[j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] solve(int[] pNums) {
        int[] wNums = new int[pNums.length];
        char[] s = new char[pNums.length * 2];
        if (pNums.length == 0) {
            return wNums;
        }

        int left = 0;
        int index = 0;
        for (int count: pNums) {
            for (int i = 0; i < count - left; i++) {
                s[index++] = '(';
            }
            left = count;
            s[index++] = ')';
        }

        index = 0;
        Stack<Integer> leftStack = new Stack<Integer>();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                leftStack.push(i);
            } else {
                int leftIndex = leftStack.pop();
                wNums[index++] = (i - leftIndex + 1) / 2;
            }
        }

        return wNums;
    }

}
