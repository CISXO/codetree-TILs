import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[][] map;


    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int result = checkConfidence(r, c);
            System.out.println(result);
            map[r][c]++;
            
        }

    }

    public static int checkConfidence(int r, int c) {

        int checkCount=0;
        for(int i=0; i<4; i++) {
            int ddx = r + dx[i];
            int ddy = c + dy[i];

            if(canGo(ddx, ddy)) {
                if(map[ddx][ddy]>0) {
                    checkCount++;
                }
            }

        }

        
        if(checkCount==3) {
            return 1;
        } else {
            return 0;
        }

    }

    public static boolean canGo(int x, int y) {
        if(x<N && y<N && x>=0 && y>=0) {
            return true;
        }
        return false;
    }

    public static void view() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}