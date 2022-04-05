package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

//BOJ 15652 N과 M(4)
public class NM3 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int [M + 1];
    }

    static int N,M;
    static int[] selected;
    static int temp;

    static void rec_func(int k){
        if (k == M + 1){
            //다 골랐을때 결과 출력
            for(int i = 1; i <= M ;i++) {
                sb.append(selected[i]);
                if (i != M)
                    sb.append(' ');
            }
            sb.append('\n');
        } else {
            int start = selected[k - 1];
            if (start == 0) start = 1;
            for (int cand = start; cand <= N; cand++){
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }

            //첫번째 방법
//            for (int cand = 1; cand <= N; cand++){
//                if (cand < temp) continue;
//                selected[k] = cand; temp = cand;
//                rec_func(k+1);
//                selected[k] = 0; temp = 0;
//            }
        }
    }

    public static void main(String[] args){
        input();

        rec_func(1);
        System.out.println(sb.toString());
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }

    }
}
