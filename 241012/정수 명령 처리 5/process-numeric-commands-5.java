import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();  // 개행 문자 제거

        Stack<Integer> stack = new Stack<>();
        ArrayList<String> stAL = new ArrayList<>();
        stAL.add("push_back");
        stAL.add("pop_back");
        stAL.add("size");
        stAL.add("get");

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] stChange = str.split("\\s");

            if (stChange.length > 1) {
                int k = Integer.parseInt(stChange[1]);

                if (stChange[0].equals("push_back")) {  // push_back 비교
                    stack.push(k);
                } else if (stChange[0].equals("get")) {  // get 명령 처리
                    if (!stack.isEmpty()) {
                        System.out.println(stack.elementAt(k-1));
                    } else {
                        System.out.println("Stack is empty");
                    }
                } else {
                    System.out.println("input error");
                }
            } else {
                if (stChange[0].equals("pop_back")) {  // pop_back 비교
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        System.out.println("Stack is empty");
                    }
                } else if (stChange[0].equals("size")) {  // size 명령 처리
                    System.out.println(stack.size());
                } else {
                    System.out.println("input error");
                }
            }
        }
    }
}