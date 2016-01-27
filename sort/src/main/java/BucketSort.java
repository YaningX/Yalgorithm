/**
 * 1) Time complexity O(n)
 * 2) can be stable
 * 3) Memory cost, complexity:
 * 4) 工作的原理是将数组分到有限数量的桶子里。每个桶子再个别排序. 桶排序是鸽巢排序的一种归纳结果。
 * 当要被排序的数组内的数值是 "均匀分配" 的时候，桶排序使用线性时间（Θ（n））。
 * 但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。

 * Useful for: when input is uniformly distributed over a range, such as
 *          Sort a large set of floating point numbers which are in range
 *          from 0.0 to 1.0 and are uniformly distributed across the range.
 *          How do we sort the numbers efficiently?
 */
public class BucketSort implements Sort {
    @Override
    public int[] sort(int[] numbers) {
        return new int[0];
    }
}
