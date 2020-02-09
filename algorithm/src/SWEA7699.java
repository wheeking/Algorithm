import java.util.Arrays;
import java.util.Scanner;

public class SWEA7699 {
    public static int[][] map;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int[] visited;
    public static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            visited = new int[26];  // A:0, Z:25
            ans = 0;
            int M = sc.nextInt();
            int N = sc.nextInt();
            map = new int[M][N];

            // 맵을 아예 숫자로 저장(0 ~ 25)
            for (int i = 0; i < M; i++) {
                String temp = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = charToInt(temp.charAt(j));
                }
            }

            visited[map[0][0]] = 1;
            Pair2 first = new Pair2(0, 0, 1);

            dfs(first);

            System.out.println(Arrays.toString(visited));

            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static void dfs(Pair2 p) {
        int max = p.cnt;        // 지금껏 방문
        if (max > ans)
            ans = max;

        if (ans == 26)
            return;

        for (int i = 0; i < dx.length; i++) {
            int newX = p.x + dx[i];
            int newY = p.y + dy[i];
            if (newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length) {
                if (visited[map[newX][newY]] == 0) {
                    visited[map[newX][newY]] = 1;
                    Pair2 temp = new Pair2(newX, newY, max+1);

                    dfs(temp);
                    // 이 단계에서 dfs 끝나고 다시 돌아왔을 때 안들른 것으로 체크해줘야 함
                    visited[map[newX][newY]] = 0;
                }
            }
        }
    }

    public static int charToInt(char ch) {
        return ch - '0' - 17;
    }
}

class Pair2 {
    int x;
    int y;
    int cnt;

    Pair2(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}