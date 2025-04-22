import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        // Please write your code here.
        int day = A - 11;
        int hour = day*24 + B -11;
        int minute = hour * 60 + C - 11;

        if(minute>0) {

        System.out.println(minute);
        } else {

        System.out.println(-1);
        }
    }
}