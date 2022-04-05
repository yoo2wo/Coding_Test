package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

//연산자 끼워넣기
public class Boj_14888 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input(){
        N = scan.nextInt();
        nums = new int[N+1];
        operators = new int [5];
        for(int i = 1; i<= N; i++) nums[i] = scan.nextInt();
        for(int i = 1; i<=4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators;

    static int calculator(int op1, int operator, int op2){
        if (operator == 1){
            return op1 + op2;
        } else if (operator == 2){
            return op1 - op2;
        } else if (operator == 3){
            return op1 * op2;
        } else
            return op1 / op2;
    }

    static void rec_func(int k, int value){
        if (k == N){
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            for(int cand = 1; cand <=4; cand++){
                if (operators[cand] >=1) {
                    operators[cand]--;
                    rec_func(k+1, calculator(value, cand, nums[k + 1]));
                    operators[cand]++;
                }
            }
        }
    }

    public static void main(String[] args){
        input();

        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());
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
