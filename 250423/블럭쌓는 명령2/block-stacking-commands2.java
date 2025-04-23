import java.util.Scanner;
public class Main {
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N+1];
        for (int i = 0; i < K; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int depth = B - A + 1;

            for(int j=0; j<depth; j++) {
                arr[A+j]++;
            }
        }
        for(int i=0; i<N+1;i++) {
            max = Math.max(arr[i],max);
            
        }
        System.out.print(max);

    }
}