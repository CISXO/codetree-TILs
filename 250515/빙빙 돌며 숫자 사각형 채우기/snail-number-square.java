import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] answer;

    public static int[] dx = {0, 1,  0, -1};
    public static int[] dy = {1, 0, -1,  0};
    public static int x = 0, y = 0;      // 시작은 (0, 0) 입니다.
    public static int dirNum = 0;        // 0: 오른쪽, 1: 아래쪽, 2: 왼쪽, 3: 위쪽
    static int n,m;
    static int stateCount = 1;

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < m && 0 <= y && y < n);
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        answer = new int[m][n];
        answer[0][0] = 1;

        for(int i = 2; i <= n * m; i++) {
            // 현재 방향 dir를 기준으로 그 다음 위치 값을 계산합니다.
            int nx = x + dx[dirNum], ny = y + dy[dirNum];

            // 더 이상 나아갈 수 없다면
            // 시계방향으로 90'를 회전합니다.
            if(!inRange(nx, ny) || answer[nx][ny] != 0)
                dirNum = (dirNum + 1) % 4;

            // 그 다음 위치로 이동한 다음 배열에 올바른 값을 채워넣습니다.
            x = x + dx[dirNum]; y = y + dy[dirNum];
            answer[x][y] = i;
        }

        // 출력:
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(answer[i][j] + " ");
            System.out.println();
        }
    }


}