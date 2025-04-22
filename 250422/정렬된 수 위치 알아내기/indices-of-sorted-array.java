import java.util.*;

public class Main {
    
    static int[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n][2];

        for(int i = 0; i < n; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = 1;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i==j) {
                    continue;
                }
                if(arr[i][0] > arr[j][0]) {
                    arr[i][1]++;
                } else if(arr[i][0] == arr[j][0]) {
                    if(i>j) {
                        arr[i][1]++;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            System.out.print(arr[i][1] + " ");
        }


        // Please write your code here.
    }

}