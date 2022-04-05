package bruteForce;

import java.io.*;
import java.util.StringTokenizer;

// 조금더 비효율적인 방법
public class Boj_14888_2 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input(){
        N = scan.nextInt();
        nums = new int[N+1];
        operators = new int [5];
        order = new int [N + 1];
        for(int i = 1; i<= N; i++) nums[i] = scan.nextInt();
        for(int i = 1; i<=4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order;

    //완성된 식에 맞게 계산해서 정답 갱신
    static int calculator(){
        int value = nums[1];
        for(int i=1;i<=N-1;i++){
            if (order[i] == 1)
                value = value + nums[i+1];
            if (order[i] == 2)
                value = value - nums[i+1];
            if (order[i] == 3)
                value = value * nums[i+1];
            if (order[i] == 4)
                value = value / nums[i+1];
        }
        return value;
    }

    // order[1..N-1] 에 연산자들이 순서대로 저장
    static void rec_func(int k){
        if (k == N){
            // 완성된 계산 결과값 저장
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            //k번째 연산자 선택
            for(int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1) {
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k+1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args){
        input();

        rec_func(1);
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
