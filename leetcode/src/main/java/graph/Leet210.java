package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xuyaning on 2/2/16.
 */
public class Leet210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        int index = 0;
        Set<Integer>[] posts = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            posts[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i ++) {
            posts[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] preNums = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j: posts[i]) {
                preNums[j]++;
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (preNums[i] == 0) {
                queue.offer(i);
                result[index++] = i;
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i: posts[node]) {
                if (--preNums[i] == 0) {
                    queue.offer(i);
                    result[index++] = i;
                }
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] == -1) {
                return new int[0];
            }
        }
        return result;
    }
}
