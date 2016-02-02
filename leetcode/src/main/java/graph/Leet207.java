package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by xuyaning on 2/2/16.
 */
public class Leet207 {
    /**
     * 图的三种表示方式: 边表示法,邻接矩阵,邻接表.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses < 2) {
            return true;
        }
        Set<Integer>[] posts = new Set[numCourses];
        for (int i = 0; i < numCourses; i++) {
            posts[i] = new HashSet<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
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
            }
        }
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i: posts[node]) {
                if (--preNums[i] == 0) {
                    queue.offer(i);
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (preNums[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
