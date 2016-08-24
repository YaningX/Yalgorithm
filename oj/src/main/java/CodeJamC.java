import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CodeJamC {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void solve() throws IOException {
        int T = nextInt();
        double diff = Math.pow(0.1, 9);
        for (int t = 1; t <= T; t++) {
            int M = nextInt();
            int[] data = new int[M + 1];
            data[0] = nextInt();
            long sum = 0;
            boolean isNegtive = false;
            for (int i = 1; i < M + 1; i++) {
                data[i] = nextInt();
                sum += data[i];
            }

            if (sum == data[0]) {
                out.println(String.format("Case #%d: " + 0, t));
                continue;
            } else if (sum > data[0]) {
                isNegtive = false;
            } else {
                isNegtive = true;
            }

            double left, right, mid;
            if (isNegtive) {
                left = -1;
                right = 0;
            } else {
                left = 0;
                right = 1;
            }

            while (true) {
                mid = (left + right) / 2;
                if (getRes(data, mid) > 0) {
                    left = mid;
                } else {
                    right = mid;
                }
                if (right - left < diff) {
                    break;
                }
            }


            out.println(String.format("Case #%d: " + mid, t));
        }
    }

    public static double getRes(int[] data, double r) {
        int radix = data.length;
        --radix;
        double r1 = 1 + r;
        double res = -data[0] * Math.pow(r1, radix);
        for (int i = 1; i < data.length; i++) {
            --radix;
            res += data[i] * Math.pow(r1, radix);
        }
        return res;
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
