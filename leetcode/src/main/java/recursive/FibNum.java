package recursive;

import java.util.Stack;

/**
 * Created by xuyaning on 31/1/16.
 */
public class FibNum {
    public static int fibnum(int n) {
        if (n < 1) {
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibnum(n - 1) + fibnum(n - 2);
    }

    static class SnapShot {
        int intputN;
        int stage;
        int addVal;
        public SnapShot(int intputN, int stage, int addVal) {
            this.intputN = intputN;
            this.stage = stage;
            this.addVal = addVal;
        }
    }

    public static int fibnumLoop(int n) {
        int retVal = 0;
        Stack<SnapShot> stack = new Stack<SnapShot>();
        stack.push(new SnapShot(n, 0, 0));
        while (!stack.isEmpty()) {
            SnapShot snapShot = stack.pop();
            switch (snapShot.stage) {
                case 0: {
                    if (snapShot.intputN < 1) {
                        retVal = -1;
                        continue;
                    }
                    if (snapShot.intputN == 1 || snapShot.intputN == 2) {
                        retVal = 1;
                        continue;
                    }
                    snapShot.stage = 1;
                    stack.push(snapShot);
                    stack.push(new SnapShot(snapShot.intputN - 1, 0, 0));
                    break;
                }
                case 1: {
                    snapShot.addVal = retVal;
                    snapShot.stage = 2;
                    stack.push(snapShot);
                    stack.push(new SnapShot(snapShot.intputN - 2, 0, 0));
                    break;
                }
                case 2: {
                    retVal = snapShot.addVal + retVal;
                }
            }
        }
        return retVal;
    }
}
