import java.util.Scanner;

public class SWEA8382 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for (int test_case = 1; test_case <= TC; test_case++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int dx = abs(x1 - x2);
            int dy = abs(y1 - y2);

            int ans = 0;
            if (dx == dy) {
                ans = 2 * dx;
            } else {
                if (dx > dy) ans = 2 * dy;
                else ans = 2 * dx;

                int gap = abs(dx - dy);
                if (gap % 2 == 0) ans += 2 * gap;
                else ans += 2 * gap - 1;
            }

            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static int abs(int a) {
        if (a > 0)
            return a;
        else
            return a * -1;
    }
}
