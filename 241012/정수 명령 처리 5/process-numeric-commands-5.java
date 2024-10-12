import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br
                = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> stack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String data = st.nextToken();
            Integer k = null;
            if (st.hasMoreTokens()) {
                k = Integer.parseInt(st.nextToken());
            }
            if(data.equals("push_back")) {
                pushback(stack, k);
            } else if (data.equals("get")) {
                stackget(stack, k);
            } else if (data.equals("size")) {
                stack_size(stack);
            } else if (data.equals("pop_back")) {
                stack_pop(stack);
            }
        }
    }

    private static void stack_pop(ArrayList<Integer> stack) {
        stack.remove(stack.size()-1);
    }

    private static void stack_size(ArrayList<Integer> stack) {
        System.out.println(stack.size());
    }

    private static void stackget(ArrayList<Integer> stack, Integer k) {
        if (k != null) {
            System.out.println(stack.get(k-1));
        } else {
            System.out.println("잘못된 인덱스 또는 k는 null입니다.");
        }
    }

    private static void pushback(ArrayList<Integer> stack, Integer k) {
        stack.add(k);
    }