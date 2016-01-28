import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** http://www.acmerblog.com/bucket-sort-4884.html
 * 1) Time complexity O(n)
 * 2) can be stable
 * 3) Memory cost, complexity:
 * 4) 工作的原理是将数组分到有限数量的桶子里。每个桶子再个别排序. 桶排序是鸽巢排序的一种归纳结果。
 * 当要被排序的数组内的数值是 "均匀分配" 的时候，桶排序使用线性时间（Θ（n））。
 * 但桶排序并不是 比较排序，他不受到 O(n log n) 下限的影响。
 * 5) 为代码见算法导论中文版112. (每个桶(list)内部排序可以用jdk自带的Collections.sort())

 * Useful for: when input is uniformly distributed over a range, such as
 *          Sort a large set of floating point numbers which are in range
 *          from 0.0 to 1.0 and are uniformly distributed across the range.
 *          How do we sort the numbers efficiently?
 */
public class BucketSort implements Sort {
    public int[] sort(int[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return numbers;
        }
        int max = numbers[0];
        int min = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            max = Math.max(max, numbers[i]);
            min = Math.min(min, numbers[i]);
        }

        double len = (double) (max - min) / (numbers.length - 1);
        List<Integer>[] buckets = new ArrayList[numbers.length];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < numbers.length; i++) {
            int index = (int) ((numbers[i] - min) / len);
            buckets[index].add(numbers[i]);
        }
        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            Collections.sort(buckets[i]);
            for (Integer number: buckets[i]) {
                numbers[j++] = number;
            }
        }

        return numbers;
    }
}
