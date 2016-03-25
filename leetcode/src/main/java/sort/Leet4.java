package sort;

/**
 * http://blog.csdn.net/sunjilong/article/details/17731681
 */
public class Leet4 {
    public double findKth(int a[], int startA, int m, int b[], int startB, int n, int k)
    {
        if (m > n) return findKth(b, startB, n, a, startA, m, k);

        if (m == 0)
            return b[startB + k-1];

        if (k == 1)
            return Math.min(a[startA], b[startB]);

        int pa = Math.min(k/2, m), pb = k - pa;

        if (a[startA + pa-1] < b[startB + pb-1])
            return findKth(a, startA + pa, m-pa, b, startB, n, k - pa);
        else
            return findKth(a, startA, m, b, startB + pb, n-pb, k-pb);
    }


    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        int total = m+n;

        if ((total&1) == 1)
            return findKth(A, 0, m, B, 0, n, total/2+1);
        else
            return (findKth(A, 0, m, B, 0, n, total/2) + findKth(A, 0, m, B, 0, n, total/2+1))/2;
    }
}
