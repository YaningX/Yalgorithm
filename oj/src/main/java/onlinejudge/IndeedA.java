package onlinejudge;

import java.io.*;
import java.util.StringTokenizer;

public class IndeedA {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static boolean solution(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        if (str1.length() == 0) {
            return true;
        }
        int len = str1.length();
        String s1 = "";
        String s2 = "";
        for (int i = 0; i < len; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 != ch2) {
                s1 += ch1;
                s2 += ch2;
            }
        }

        if (s1.length() == 0) {
            return true;
        }

        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (s1.replace(ch1, ch2).equals(s2.replace(ch1, ch2))) {
                return true;
            }
        }
        return false;
    }

    public static void solve() throws IOException {
        String str1 = next();
        String str2 = next();
        if (IndeedA.solution(str1, str2)) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }
    }


    public static void main(String[] args) {

        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));
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
