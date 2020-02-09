package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B1012_배추 {
    public static final int[] dx = {0, 0, 1, -1};
    public static final int[] dy = {1, -1, 0, 0};
    public static int[][] visited;
    public static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int ans = 0;
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();
            map = new int[N][M];
            visited = new int[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && visited[i][j] == 0) {
                        bfs(new Pair2(i, j));
                        ans++;
                    }
                }
            }


            System.out.println(ans);
        }
    }

    public static void bfs(Pair2 p) {
        Queue<Pair2> q = new LinkedList<Pair2>();
        q.offer(p);
        visited[p.x][p.y] = 1;

        while(!q.isEmpty()){
            Pair2 temp = q.poll();

            for (int k = 0; k < dx.length; k++) {
                int newX = temp.x + dx[k];
                int newY = temp.y + dy[k];
                if (newX >= 0 && newY >=0 && newX < map.length && newY < map[0].length) {
                    if (visited[newX][newY] == 0 && map[newX][newY] != 0) {
                        visited[newX][newY] = 1;
                        q.offer(new Pair2(newX, newY));

                    }
                }
            }
        }


    }
}

class Pair2 {
    int x;
    int y;

    Pair2 (int x, int y) {
        this.x = x;
        this.y = y;
    }
}