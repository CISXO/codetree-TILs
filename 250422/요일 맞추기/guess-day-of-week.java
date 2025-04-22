import java.util.*;
public class Main {
    static HashMap<Integer, String> dept = new HashMap<>();
    static HashMap<Integer, Integer> depthDay = new HashMap<>();

    static int result;

    public static void main(String[] args) {
        dept.put(0,"Mon");
        dept.put(1,"Tue");
        dept.put(2,"Wed");
        dept.put(3,"Thu");
        dept.put(4,"Fri");
        dept.put(5,"Sat");
        dept.put(6,"Sun");

        depthDay.put(1, 0);
        depthDay.put(2, 31);
        depthDay.put(3, 59);
        depthDay.put(4, 90);
        depthDay.put(5, 120);
        depthDay.put(6, 151);
        depthDay.put(7, 181);
        depthDay.put(8, 212);
        depthDay.put(9, 243);
        depthDay.put(10, 273);
        depthDay.put(11, 304);
        depthDay.put(12, 334);


        Scanner sc = new Scanner(System.in);
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int firstMonth = depthDay.get(m1) + d1;

        int secondMonth = depthDay.get(m2) + d2;

        if(firstMonth< secondMonth) {
            result = (secondMonth - firstMonth)%7;
        } else if(firstMonth > secondMonth) {
            result = secondMonth - firstMonth;
            result = 7 - (-result)%7;
        }

        System.out.println(dept.get(result));
        // Please write your code here.
    }
}