import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int basis = 1000;
    static int max = 2001;
    static int sum = 0;
    static int[][] visited = new int[max][max];
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    static ArrayList<int[]> pair = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt() + basis;
        int rect1_y1 = sc.nextInt() + basis;
        int rect1_x2 = sc.nextInt() + basis;
        int rect1_y2 = sc.nextInt() + basis;

        int rect2_x1 = sc.nextInt() + basis;
        int rect2_y1 = sc.nextInt() + basis;
        int rect2_x2 = sc.nextInt() + basis;
        int rect2_y2 = sc.nextInt() + basis;

        go(rect1_x1,rect1_y1, rect1_x2, rect1_y2);

        minus(rect2_x1, rect2_y1, rect2_x2, rect2_y2);

        int check = checkSquare();

        if(check>0) {
            calculate(1); // check가 1이라는 것은 1로 이루어진 것이 직사각형을 이루므로 2를 빼고 세야하고
        } else {
            calculate(0); // check가 0이라는 것은 1로 이루어진 것이 직사각형이 안되므로 2를 포함해서 세야함
        }
        System.out.print(sum);
        // Please write your code here.
    }

    public static void go(int dx, int dy, int ddx, int ddy) {
        for(int i=dx; i< ddx; i++) {
            for(int j=dy; j<ddy; j++) {
                visited[i][j]++;
            }
        }
    }

    public static void minus(int dx, int dy, int ddx, int ddy) {
        for(int i=dx; i<ddx; i++) {
            for(int j=dy; j<ddy; j++) {
                if(visited[i][j]>0) {
                    visited[i][j]++;
                }
            }
        }
    }

    public static int checkSquare() {
        //사각형인 경우 1을 반환
        //사각형이 아닌 경우 0 을 반환
        //1로 이루어진 것들이 사각형인지 확인하면 됨
        for(int i=0; i<max; i++) {
            for(int j=0; j<max; j++) {

                if(visited[i][j]==1) {
                    pair.add(new int[] {i, j});
                }
            }
        }

        int[] minPair = new int[2];
        int[] maxPair = new int[2];
        int count = 0;
        for(int[] data : pair) {
            int a = data[0];
            int b = data[1];
            int basisData = a + b;
            if(basisData<minValue) {
                minValue = basisData;
                minPair = new int[] {a, b};
            }
            if(basisData>maxValue) {
                maxValue = basisData;
                maxPair = new int[] {a, b};
            }
            count++;
        }
        int squarex1 = minPair[0];
        int squarey1 = minPair[1];
        int squarex2 = maxPair[0];
        int squarey2 = maxPair[1];
        int ddxt = squarex2-squarex1 + 1;
        int ddyt = squarey2-squarey1 + 1;
        
        int resultData = ddxt * ddyt;
        
        if(count==resultData || count==0) {
            return 1;
        } else {
            return 0;
        }
        
    }

    public static void calculate(int point) {

        if(point == 1) {
            
            for(int i=0; i<max; i++) {
                for(int j=0; j<max; j++) {
                    if(visited[i][j] == point) {
                        sum++;
                    }
                }
            }
        } else if(point == 0) {
            
            for(int i=0; i<max; i++) {
                for(int j=0; j<max; j++) {
                    if(visited[i][j] > 0) {
                        sum++;
                    }
                }
            }
        }
    }

}
