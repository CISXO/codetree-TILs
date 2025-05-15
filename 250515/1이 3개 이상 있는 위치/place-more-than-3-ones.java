
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int n;
    //동 남 서 북
    static int[][] grid;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        grid= new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int count=0;
            while(st.hasMoreTokens()) {
                grid[i][count] = Integer.parseInt(st.nextToken());
                count++;
            }
        }
        int isResultCount=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                isResultCount += checkDir(i, j);
            }
        }
        System.out.println(isResultCount);
    }

    private static int checkDir(int i, int j) {
        int stateCount =0;
        for(int dir=0; dir<4; dir++) {
            if(!isRange(i+dx[dir], j+dy[dir])) {
                continue;
            }
            if(grid[i + dx[dir]][j + dy[dir]]==1) {
                stateCount++;
            }
        }
        if(stateCount>=3) {
            return 1;
        } else {
            return 0;
        }
    }

    static public boolean isRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

}
