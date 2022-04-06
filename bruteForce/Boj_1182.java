package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

//부분 수열의 합
public class Boj_1182 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input(){
        N = scan.nextInt();
        S = scan.nextInt();
        nums = new int[N+1];
        for(int i = 1; i <= N; i++)
            nums[i] = scan.nextInt();
    }

    static int N, S, ans;
    static int[] nums;

    static void rec_func(int k, int value){
        if (k == N +1){
            if (value == S) ans++;
        }else {
            //포함 시킨다.
            rec_func(k + 1, value + nums[k]);
            //포한 시키지 않는다.
            rec_func(k + 1, value);

        }
    }

    public static void main(String[] args) {
        input();

        rec_func(1, 0);
        //진 부분 집합인지 확인해야한다.
        if (S==0){
            ans--;
        }
        System.out.println(ans);
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
