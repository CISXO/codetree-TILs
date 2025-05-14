import java.util.*;

public class Main {
    static Queue<Character> queueA = new LinkedList<>();
    static Queue<Character> queueB = new LinkedList<>();

    static int max = Integer.MIN_VALUE;
    static int depth=0;
    static int currentA=0;
    static int currentB=0;
    static int totalResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            depth +=t;
            char d = sc.next().charAt(0);
            for(int j=0; j<t; j++) {
                queueA.add(d);
            }
            max = depth;
        }
        depth = 0;

        for (int i = 0; i < m; i++) {
            int t = sc.nextInt();
            depth+=t;
            char d = sc.next().charAt(0);

            for(int j=0; j<t; j++) {
                queueB.add(d);
            }
            max = Math.max(max, depth);
            // Please write your code here.
        }
        int prevA = 0;
        int prevB = 0;

        for (int i = 0; i < max; i++) {
            char cuA = queueA.isEmpty() ? 'T' : queueA.poll();
            char cuB = queueB.isEmpty() ? 'T' : queueB.poll();

            // 위치 업데이트 전 상태 저장
            prevA = currentA;
            prevB = currentB;

            // 이동
            if (cuA == 'L') currentA--;
            else if (cuA == 'R') currentA++;

            if (cuB == 'L') currentB--;
            else if (cuB == 'R') currentB++;

            // 충돌 조건: 직전엔 다르고, 지금은 같을 때
            if (prevA != prevB && currentA == currentB) {
                totalResult++;
            }
        }
        // Please write your code here.
        System.out.println(totalResult);
    }
}