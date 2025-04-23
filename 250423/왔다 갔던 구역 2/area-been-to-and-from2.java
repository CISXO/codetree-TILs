import java.util.*;
import java.io.*;


public class Main {

    static Queue<Integer> que = new LinkedList<>();
    static int N;
    static int result=0;

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        int dir = 0;

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            String data = st.nextToken();
            if(data.equals("L")) {
                for(int j=0; j<k; j++) {
                    dir--;
                    que.add(dir);
                }
            } else if(data.equals("R")) {
                for(int j=0; j<k; j++) {
                    dir++;
                    que.add(dir);
                }
            }
        }

        for(int data : que) {
            if(!list.contains(data)) {
                list.add(data);
            } else {
                result++;
            }
        }

        System.out.println(result);
    }
}
