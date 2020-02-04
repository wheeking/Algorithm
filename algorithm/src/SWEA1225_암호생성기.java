import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1225_암호생성기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case;
        Queue<Integer> q = new LinkedList<>();

        int cnt = 0;
        while (cnt < 10) {
            int k = 1;
            test_case = sc.nextInt();
            for (int i = 0; i < 8; i++) {
                q.offer(sc.nextInt());
            }

            while (true) {
                // 빼기
                int a = q.poll();

                // 다시 넣기
                a -= k++;
                if (a <= 0) {
                    a = 0;
                    q.offer(a);
                    break;
                }
                q.offer(a);

                if (k == 6)
                    k = 1;
            }

            System.out.print("#" + test_case + " ");
            
            for (int i = 0; i < 8; i++) {
                System.out.print(q.poll() + " ");
            }
            
            System.out.println();
            cnt++;
        }
    }
}