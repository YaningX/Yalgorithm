package string;

/**
 * Created by xuyaning on 28/1/16.
 */
public class Leet165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < v1.length && j < v2.length) {
            int ver1 = Integer.valueOf(v1[i]);
            int ver2 = Integer.valueOf(v2[j]);
            if (ver1 > ver2) {
                return 1;
            } else if (ver1 < ver2) {
                return -1;
            }
            i++;
            j++;
        }
        while (i < v1.length && Integer.valueOf(v1[i]) == 0) {
            i++;
        }
        while (j < v2.length && Integer.valueOf(v2[j]) == 0) {
            j++;
        }
        if (i < v1.length) {
            return 1;
        }
        if (j < v2.length) {
            return -1;
        }
        return 0;
    }
}
