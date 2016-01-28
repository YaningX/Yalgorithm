package sort;

/**
 * Suppose there are N elements and they range from A to B.

 * Then the maximum gap will be no smaller than ceiling[(B - A) / (N - 1)]

 * Let the length of a bucket to be len = ceiling[(B - A) / (N - 1)], then we will have at most num = (B - A) / len + 1 of bucket

 * for any number K in the array, we can easily find out which bucket it belongs by calculating loc = (K - A) / len and therefore maintain the maximum and minimum elements in each bucket.

 * Since the maximum difference between elements in the same buckets will be at most len - 1, so the final answer will not be taken from two elements in the same buckets.

 * For each non-empty buckets p, find the next non-empty buckets q, then q.min - p.max could be the potential answer to the question. Return the maximum of all those values.

 */
public class Leet164 {
    class Bucket {
        public int high;
        public int low;
        public Bucket() {
            high = -1;
            low = -1;
        }
    }

    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        double len = (double) (max - min) / (nums.length - 1);
        Bucket[] buckets = new Bucket[nums.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        for (int i = 0; i < nums.length; i++) {
            int index = (int) ((nums[i] - min) / len);
            if (buckets[index].low == - 1) {
                buckets[index].low = nums[i];
                buckets[index].high = nums[i];
            } else {
                buckets[index].low = Math.min(buckets[index].low, nums[i]);
                buckets[index].high = Math.max(buckets[index].high, nums[i]);
            }
        }

        int result = 0;
        int pre = buckets[0].high;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].low != -1) {
                result = Math.max(result, buckets[i].low - pre);
                pre = buckets[i].high;
            }

        }
        return result;
    }
}
