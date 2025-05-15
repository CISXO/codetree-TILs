
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int n,t;
    static int col, row = 0;

    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("U",2);
        map.put("D",0);
        map.put("L",1);
        map.put("R",3);

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        String d = st.nextToken();

        int dir = map.get(d);
        int checkPos = 1;
        for (int i = 0; i < t; i++) {
            if(checkPos > 0) {
                if (!isRange(col + dx[dir], row + dy[dir])) {
                    checkPos = checkPos * -1;
                } else {
                    if (checkPos == 1) {
                        col += dx[dir];
                        row += dy[dir];
                    } else if (checkPos < 0) {
                        col -= dx[dir];
                        row -= dy[dir];
                    }
                }
            } else {
                if (!isRange(col - dx[dir], row - dy[dir])) {
                    checkPos = checkPos * -1;
                } else {
                    if (checkPos == 1) {
                        col += dx[dir];
                        row += dy[dir];
                    } else if (checkPos < 0) {
                        col -= dx[dir];
                        row -= dy[dir];
                    }
                }
            }
        }
        System.out.println(col + " " + row);
    }
    static boolean isRange(int fx, int fy) {
        return fx > 0 && fy > 0 && fx <= n && fy <= n;
    }
}
