import java.util.Scanner;
public class Main {
    static int sum=0;

    public static final int MAX_K = 100000;
    public static int n;
    public static int[] arr = new int[2 * MAX_K + 1];
    static int le=0;
    static int re=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cur = MAX_K;
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            char d = sc.next().charAt(0);
            if(d=='L') {

                while(x-- > 0) {
                    arr[cur] = 1;
                    if(x > 0) cur--;
                }

            } else if(d=='R') {
                while(x-- > 0) {
                    arr[cur] = 2;
                    if(x > 0) cur++;
                }
            }
        }


    for(int i=0; i<2 * MAX_K + 1; i++) {
        if(arr[i]==1) {
            le++;
        } else if(arr[i]==2) {
            re++;
        }
    }
    System.out.print(le+" "+re);

        
    }
}