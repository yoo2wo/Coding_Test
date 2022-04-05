package inputTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Input {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);
        String s2 = st.nextToken();
        String s3 = st.nextToken();
        int i = Integer.parseInt(st.nextToken());


        System.out.println("s2 : " + s2);
        System.out.println("s2 : " + s3);
        System.out.println("i : " + i);
    }
}
