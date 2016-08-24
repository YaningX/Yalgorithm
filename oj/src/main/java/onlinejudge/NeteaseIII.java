package onlinejudge;

import java.util.*;

public class NeteaseIII {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] nums = new int[N];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int product = 1;

        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
            sum += nums[i];
            product *= nums[i];
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int[] keys = new int[map.size()];
        int[] values = new int[map.size()];
        int k = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            keys[k] = entry.getKey();
            values[k] = entry.getValue();
            k++;
        }

        System.out.println(dfs(keys, values, product, sum, 0));

    }

    private static int dfs(int[] keys, int[] values, int product, int sum, int start) {
        if (sum <= product) {
            return 0;
        }

        if (start == keys.length) {
            return 1;
        }

        int result = 0;
        int tmp = values[start];
        while (values[start] >= 0) {
            result += dfs(keys, values, product, sum, start + 1);
            values[start]--;
            product /= keys[start];
            sum -= keys[start];
        }
        values[start] = tmp;
        return result;
    }


}
