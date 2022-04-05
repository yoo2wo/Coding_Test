package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

//백준 15649 N과M(1)
// NM1과 거이 유사
// 값을 넣을때 부분만 다르다.
public class NM2 {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int [M + 1];
        used = new int [N + 1];
    }

    static int N,M;
    static int[] selected;
    static int[] used; //version 2

    /**
     * version 1
     */
//    static void rec_func(int k){
//        if (k == M + 1){
//            //다 골랐을때 결과 출력
//            for(int i = 1; i <= M ;i++) {
//                sb.append(selected[i]).append(' ');
//            }
//            sb.append('\n');
//        } else {
//            for (int cand = 1; cand <= N; cand++){
//                boolean isUsed = false;
//                for (int i=1; i < k; i++)
//                    if (cand == selected[i])
//                        isUsed = true;
//                if (!isUsed){
//                    selected[k] = cand;
//                    rec_func(k+1);
//                    selected[k] = 0;
//                }
//            }
//        }
//    }

    static void rec_func(int k){
        if (k == M + 1){
            for(int i = 1; i <= M; i++) {
                sb.append(selected[i]);
                if (i != M)
                    sb.append(' ');
            }
            sb.append('\n');
        } else {
            for (int cand = 1; cand <= N; cand++){
                if (used[cand] == 1)
                    continue;
                selected[k] = cand; used[cand] = 1;
                rec_func(k+1);
                selected[k] = 0; used[cand] = 0;
            }
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
