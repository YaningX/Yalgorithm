package codeforces;

import java.util.Scanner;

/**
 * -- hard
 * Segment tree + dp
 * 1) 线段树用来求某区间内最大数;
 * 2) 动态规划的状态转移方程:
 *     (1) dp[i] = p[i][i+1] + p[i][i + 2] +...+ p[i][maxIndex] + ... + p[i][a[i]] + ... + p[i][n]
 *     (2) dp[maxIndex] =                         p[maxIndex][maxIndex + 1] + ... + p[maxIndex][n]
 *     (3) 从i到j, j 属于[maxIndex + 1, maxIndex + 2, .... n]: 先跳到maxIndex, 再重新开始, 1 + p[maxIndex][j], 集合内累计为 dp[maxIndex] + n - maxIndex
 *     (4) 从i到j, j 属于[i + 1, i + 2,..., maxIndex], 每个需要1步, 集合内累计为 maxIndex - i
 *     (5) 从i到j, j 属于[maxIndex,....a[i]],只需要一步,而(2)中计算了两步,减去a[i] - maxIndex.
 * 3) 注意
 *      (1) 下标要统一;
 *      (2) 大数值的情况;
 */
public class TrainsAndStatic {
    static class SegmentTree {
        private STNode root;

        public SegmentTree(int[] nums) {
            this.root = build(nums, 1, nums.length - 1);
        }

        private STNode build(int[] nums, int start, int end) {
            STNode node = new STNode(start, end);
            if (start == end) {
                node.maxIndex = start;
                node.maxVal = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                node.left = build(nums, start, mid);
                node.right = build(nums, mid + 1, end);
                if (node.left.maxVal > node.right.maxVal) {
                    node.maxIndex = node.left.maxIndex;
                    node.maxVal = node.left.maxVal;
                } else {
                    node.maxIndex = node.right.maxIndex;
                    node.maxVal = node.right.maxVal;
                }
            }
            return node;
        }

        public int maxRange(int start, int end) {
            return maxRange(root, start, end).maxIndex;
        }

        private STNode maxRange(STNode root, int start, int end) {
            if (start == root.start && end >= root.end) {
                return root;
            } else {
                int mid = root.start + (root.end - root.start) / 2;
                if (end <= mid) {
                    return maxRange(root.left, start, end);
                } else if (start > mid) {
                    return maxRange(root.right, start, end);
                } else {
                    STNode leftMax = maxRange(root.left, start, mid);
                    STNode rightMax = maxRange(root.right, mid + 1, end);
                    STNode max = leftMax.maxVal > rightMax.maxVal? leftMax: rightMax;
                    return max;
                }
            }
        }

        class STNode {
            int start, end;
            STNode left, right;
            int maxIndex, maxVal;
            public STNode(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }


    public static void solve() {
        Scanner in = new Scanner(System.in);
        int n = 0;
        if (in.hasNextInt()) {
            n = in.nextInt();
        }
        int[] nums = new int[n];
        for (int i = 1; i < n; i++) {
            if (in.hasNextInt()) {
                nums[i] = in.nextInt();
            }
        }
        SegmentTree tree = new SegmentTree(nums);
       long[] dp = new long[n + 1];
        dp[n - 1] = 1;
        long sum = dp[n - 1];
        for (int i = n - 2; i > 0; i--) {
            int tmp = tree.maxRange(i + 1, nums[i]);
            dp[i] = dp[tmp] + n - i - (nums[i] - tmp);
            sum += dp[i];
        }
        System.out.println(sum);

    }


    public static void main(String[] args) {
        TrainsAndStatic.solve();
    }
}
