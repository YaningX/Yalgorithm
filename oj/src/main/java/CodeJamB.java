import java.io.*;
import java.util.StringTokenizer;

public class CodeJamB {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void solve() throws IOException {
        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            int R = nextInt();
            int C = nextInt();
            int[][] nums = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    nums[i][j] = nextInt();
                }
            }
            out.println(String.format("Case #%d: " + dfs(nums, 0, nums.length - 1, 0, nums[0].length - 1), t));
        }
    }


    public static int dfs(int[][] nums, int xStart, int xEnd, int yStart, int yEnd) {
        if (xEnd - xStart <= 1 || yEnd - yStart <= 1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int i = xStart + 1; i < xEnd; i++) {
            min = Math.min(min, nums[i][yStart]);
            min = Math.min(min, nums[i][yEnd]);
        }

        for (int i = yStart + 1; i < yEnd; i++) {
            min = Math.min(min, nums[xStart][i]);
            min = Math.min(min, nums[xEnd][i]);
        }


        int sum0 = 0;

        if (xEnd - xStart == 2) {
            for (int i = yStart + 1; i < yEnd; i++) {
                if (nums[xStart + 1][i] < min) {
                    sum0 = sum0 + min - nums[xStart + 1][i];
                }
            }
            return sum0;
        }

        if (yEnd - yStart == 2) {
            for (int i = xStart + 1; i < xEnd; i++) {
                if (nums[i][yStart + 1] < min) {
                    sum0 = sum0 + min - nums[i][yStart + 1];
                }
            }
            return sum0;
        }

        for (int i = xStart + 1; i < xEnd; i++) {
            if (nums[i][yStart + 1] < min) {
                sum0 = sum0 + min - nums[i][yStart + 1];
            }

            if (nums[i][yEnd - 1] < min) {
                sum0 = sum0 + min - nums[i][yEnd - 1];
            }

        }

        for (int i = yStart + 2; i < yEnd - 1; i++) {
            if (nums[xStart + 1][i] < min) {
                sum0 = sum0 + min - nums[xStart + 1][i];
            }
            if (nums[xEnd - 1][i] < min) {
                sum0 = sum0 + min - nums[xEnd - 1][i];
            }

        }

        return sum0 + dfs(nums, xStart + 1, xEnd - 1, yStart + 1, yEnd - 1);
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new FileReader(args[0]));
            out = new PrintWriter(args[1]);
            solve();
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static int[] nextIntArray(int len, int start) throws IOException {
        int[] a = new int[len];
        for (int i = start; i < len; i++)
            a[i] = nextInt();
        return a;
    }

    static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    static long[] nextLongArray(int len, int start) throws IOException {
        long[] a = new long[len];
        for (int i = start; i < len; i++)
            a[i] = nextLong();
        return a;
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static double[] nextDoubleArray(int len, int start) throws IOException {
        double[] a = new double[len];
        for (int i = start; i < len; i++)
            a[i] = nextDouble();
        return a;
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }
}
