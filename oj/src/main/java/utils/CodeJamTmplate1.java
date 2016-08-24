package utils;

import java.io.*;
import java.util.StringTokenizer;

public class CodeJamTmplate1 {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void solve() throws IOException {
        int T = nextInt();
        for (int t = 1; t <= T; t++) {



            out.println(String.format("Case #%d: ", t));
        }
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
