package lib;

import java.util.Arrays;


public class DisjointSet {
    public int[] nums;

    public DisjointSet(int n) {
        this.nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
    }

    public void union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        nums[fy] = fx;
    }

    /**
    public int find(int x) {
        while (nums[x] != x) {
            x = nums[x];
        }
        return x;
    }*/


    //路径压缩优化
    public int find(int x) {
        int r = x;
        while (nums[r] != r) {
            r = nums[r];
        }
        int i;
        while (nums[x] != r) {
            i = nums[x];
            nums[x] = r;
            x = i;
        }
        return r;
    }

    public void standard() {
        for (int i = 0; i < nums.length; i++) {
            find(i);
        }
    }

    public boolean isSame(int x, int y) {
        return find(x) == find(y);
    }


    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(10);
        set.union(1,2);
        set.union(2,3);
        set.union(4,5);
        set.union(4,1);
        set.union(6,7);
        set.union(9,8);
        set.union(8,0);
        set.standard();
        System.out.println(Arrays.toString(set.nums));
        System.out.println(set.isSame(5, 8));
    }
}
