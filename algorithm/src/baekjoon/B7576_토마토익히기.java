package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576_토마토익히기 {
    public static int[] dx = {0, 0, 1, -1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] map = new int[n][m];
        int[][] check = new int[n][m];


        Queue<Loc> q = new LinkedList<Loc>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                check[i][j] = -1;   // 익지 않은 거 모두 -1
                if (map[i][j] == 1) {
                    q.add(new Loc(i, j));  // 1인 익은 토마토는 모두 큐고 시작.
                    check[i][j] = 0;
                }
            }
        }

        while (!q.isEmpty()) {
            Loc p = q.poll();
            int x = p.x;
            int y = p.y;

            for (int k = 0; k < dx.length; k++) {
                int newX = x + dx[k];
                int newY = y + dy[k];

                if (newX >=0 && newY >=0 && newX < n && newY < m) {
                    if (map[newX][newY] == 0 && check[newX][newY] == -1) {
                        q.add(new Loc(newX, newY));
                        // 전보다 1 증가
                        check[newX][newY] = check[x][y] + 1;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j] > ans)
                    ans = check[i][j];
            }

        }

        // 익지 않은 토마토가 있을 경우!!
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && check[i][j] == -1)
                    ans = -1;
            }

        }
        System.out.println(ans);
    }
}

class Loc {
    int x;
    int y;

    Loc (int x, int y) {
        this.x = x;
        this.y = y;
    }
}