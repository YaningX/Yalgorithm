package round2;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * time O(log(m + n)), space O(log(m + n)),递归的深度; java对尾递归没有进行优化,C语言进行了优化
 * 可以使用while来优化递归,减少空间复杂度
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total = nums1.length + nums2.length;
        if ((total & 1) == 1) {
            return findKth(nums1, 0, nums2, 0, total / 2 + 1);
        } else {
            return 0.5 * (findKth(nums1, 0, nums2, 0, total / 2) + findKth(nums1, 0, nums2, 0, total / 2 + 1));
        }
    }

    private double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        int len1 = nums1.length - start1;
        int len2 = nums2.length - start2;
        if (len1 > len2) {
            return findKth(nums2, start2, nums1, start1, k);
        }
        if (len1 == 0) {
            return nums2[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int pa = Math.min(k / 2, len1);
        int pb = k - pa;
        if (nums1[start1 + pa - 1] < nums2[start2 + pb - 1]) {
            return findKth(nums1, start1 + pa, nums2, start2, k - pa);
        } else {
            return findKth(nums1, start1, nums2, start2 + pb, k - pb);
        }
    }
}
