import java.io.*;
import java.util.*;
public class Main {
    static int Mod = 1000000007;
    static int INIT = 1000;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[INIT+1];

        dp[0] = 0;
        dp[1] = 2;
        dp[2] = 7;
        dp[3] = 22;


        for(int i=4; i<=n; i++) {
            dp[i] = (((dp[i-2]%Mod + dp[i-1]%Mod)%Mod - dp[i-3]%Mod)%Mod + (dp[i-1]*2)%Mod)%Mod;
        }


        System.out.println(dp[n]);

    }
}