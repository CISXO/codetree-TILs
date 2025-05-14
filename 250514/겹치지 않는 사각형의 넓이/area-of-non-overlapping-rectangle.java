import java.util.*;
import java.io.*;

public class Main {
    static int basis = 1000;
    static int max = 2001;
    static int sum = 0;
    static int[][] visited = new int[max][max];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt() + basis;
        int ay1 = sc.nextInt() + basis;
        int ax2 = sc.nextInt() + basis;
        int ay2 = sc.nextInt() + basis;
        int bx1 = sc.nextInt() + basis;
        int by1 = sc.nextInt() + basis;
        int bx2 = sc.nextInt() + basis;
        int by2 = sc.nextInt() + basis;
        int mx1 = sc.nextInt() + basis;
        int my1 = sc.nextInt() + basis;
        int mx2 = sc.nextInt() + basis;
        int my2 = sc.nextInt() + basis;

        go(ax1,ay1, ax2, ay2);
        go(bx1, by1, bx2, by2);
        minus(mx1, my1, mx2, my2);
        int data = calculate();
        System.out.print(data);

    }
    public static void go(int dx, int dy, int ddx, int ddy) {
        for(int i=dx; i<ddx; i++) {
            for(int j=dy; j<ddy; j++) {
                visited[i][j]++;
            }
        }
    }

    public static void minus(int dx, int dy, int ddx, int ddy) {
        for(int i=dx; i<ddx; i++) {
            for(int j=dy; j<ddy; j++) {
                if(visited[i][j]>0) {
                    visited[i][j] = 0;
                }
            }
        }
    }

    public static int calculate() {
        int result = 0;
        for(int i=0; i<max; i++) {
            for(int j=0; j<max; j++) {
                if(visited[i][j]>0) {
                    result++;
                }
            }
        }
        return result;
    }

}