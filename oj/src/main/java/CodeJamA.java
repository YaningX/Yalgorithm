import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CodeJamA {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;

    public static void solve() throws IOException {
        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            int N = nextInt();
            String[] strings = new String[N];
            for (int i = 0; i < N; i++) {
                strings[i] = nextLine();
            }

            Set<Character>[] sets = new Set[strings.length];
            for (int i = 0; i < sets.length; i++) {
                sets[i] = new HashSet<Character>();
            }

            for (int i = 0; i < strings.length; i++) {
                String s = strings[i];
                for (int j = 0; j < s.length(); j++) {
                    sets[i].add(s.charAt(j));
                }
            }

            Arrays.sort(sets, new Comparator<Set<Character>>() {
                @Override
                public int compare(Set<Character> o1, Set<Character> o2) {
                    if (o1.size() < o2.size()) {
                        return 1;
                    } else if (o1.size() > o2.size()) {
                        return -1;
                    } else {
                        List<Character> chars1 = new ArrayList<Character>(o1);
                        List<Character> char2 = new ArrayList<Character>(o2);
                        Collections.sort(chars1);
                        Collections.sort(char2);
                        for (int i = 0; i < chars1.size(); i++) {
                            if (chars1.get(i) > char2.get(i)) {
                                return 1;
                            } else if (chars1.get(i) < char2.get(i)) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                    return 0;
                }
            });

            Set<Character>[] backsets = new Set[strings.length];
            for (int i = 0; i < backsets.length; i++) {
                backsets[i] = new HashSet<Character>();
            }

            for (int i = 0; i < strings.length; i++) {
                String s = strings[i];
                for (int j = 0; j < s.length(); j++) {
                    backsets[i].add(s.charAt(j));
                }
            }

            for (int i = 0; i < strings.length; i++) {
                if (backsets[i].equals(sets[0])) {
                    out.println(String.format("Case #%d: " + strings[i], t));
                }
            }


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

    static String nextLine() throws IOException {
        tok = new StringTokenizer("");
        return in.readLine();
    }
}
