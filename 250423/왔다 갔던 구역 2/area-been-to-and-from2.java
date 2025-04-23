import java.util.*;
import java.io.*;


public class Main {

    static Queue<Integer> que = new LinkedList<>();
    static int N;
    static int result=0;

    static ArrayList<Integer> list = new ArrayList<>();

    static ArrayList<Integer> contact = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        N = Integer.parseInt(bf.readLine());

        int dir = 0;
        String current ="x";

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            String data = st.nextToken();
            
            if(data.equals("L")) {
                for(int j=0; j<k; j++) {
                    if(current.equals("R")) {
                        dir++;
                    }

                    dir--;
                    que.add(dir);
                    current="L";
                }
            } else if(data.equals("R")) {
                for(int j=0; j<k; j++) {
                    if(current.equals("L")) {
                        dir--;
                    }

                    dir++;
                    que.add(dir);

                    current="R";
                }
            }
        }

        for(int data : que) {
            //System.out.print(data + " ");
            if(!list.contains(data)) {
                list.add(data);
            } else {
                if(contact.contains(data)) {
                    continue;
                }
                contact.add(data);
                result++;
            }
        }

        System.out.println(result);
    }
}
