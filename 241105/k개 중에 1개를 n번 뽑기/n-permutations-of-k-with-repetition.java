package codetest.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] result = new int[N];
        backtracking(K, N, 0, result);
    }

    private static void backtracking(int K, int N, int depth, int[] result) {
        if (depth == N) {
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= K; i++) {
            result[depth] = i;
            backtracking(K, N, depth + 1, result);
        }
    }
}