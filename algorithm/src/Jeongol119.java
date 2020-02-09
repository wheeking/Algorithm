import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jeongol119 {
    public static int[][] map;
    public static int[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        map = new int[M][N];
        visited = new int[M][N];

        // 도착 좌표
        int x = sc.nextInt();
        int y = sc.nextInt();

        // 입력
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                // visited 배열 최대값으로 초기화. 턴 횟수를 (양수니까) 비짓티드 값으로 활용해서 최소값 구할 것임.
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        bfs();

        System.out.println(visited[x][y]);

    } // end of main

    public static void bfs() {
        Queue<Info> q = new LinkedList<Info>();

        visited[0][0] = 0;
        // 오른쪽
        Info info = new Info(0, 0, 0, 4);
        // 아래쪽
        Info info2 = new Info(0, 0, 0, 2);
        q.offer(info);
        q.offer(info2);

        while(!q.isEmpty()) {
            Info temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int turn = temp.turn;
            int dir = temp.dir;

            // 오른쪽으로 갈 경우
            int turnTemp = turn + (dir == 4 ? 0 : 1);   // 이전에 가던 방향이면 안 더해주고, 방향 바뀌면 1 증가
            if (y+1 < map[0].length && map[x][y+1] == 1 && turnTemp <= visited[x][y+1]) {
                // 오른쪽으로한칸(y+1)이 범위를 넘지 않고, 오른쪽이 길일 때, 현재까지 턴수가 오른쪽에 저장된 턴수보다 작거나 같을 때
                visited[x][y+1] = turnTemp;
                Info newInfo = new Info(x, y+1, turnTemp, 4);
                q.offer(newInfo);
            }

            // 왼쪽으로 갈 경우
            turnTemp = turn + (dir == 3 ? 0 : 1);   // 이전에 가던 방향이면 안 더해주고, 방향 바뀌면 1 증가
            if (y-1 >= 0 && map[x][y-1] == 1 && turnTemp <= visited[x][y-1]) {
                visited[x][y-1] = turnTemp;
                Info newInfo = new Info(x, y-1, turnTemp, 3);
                q.offer(newInfo);
            }

            // 아래로 갈 경우
            turnTemp = turn + (dir == 2 ? 0 : 1);   // 이전에 가던 방향이면 안 더해주고, 방향 바뀌면 1 증가
            if (x+1 < map.length && map[x+1][y] == 1 && turnTemp <= visited[x+1][y]) {
                visited[x+1][y] = turnTemp;
                Info newInfo = new Info(x+1, y, turnTemp, 2);
                q.offer(newInfo);
            }

            // 위로 갈 경우
            turnTemp = turn + (dir == 1 ? 0 : 1);   // 이전에 가던 방향이면 안 더해주고, 방향 바뀌면 1 증가
            if (x-1 >= 0 && map[x-1][y] == 1 && turnTemp <= visited[x-1][y]) {
                // 오른쪽으로한칸(y+1)이 범위를 넘지 않고, 오른쪽이 길일 때, 현재까지 턴수가 오른쪽에 저장된 턴수보다 작거나 같을 때
                visited[x-1][y] = turnTemp;
                Info newInfo = new Info(x-1, y, turnTemp, 1);
                q.offer(newInfo);
            }
        }
        // end!!
    }
} // end of class

class Info {
    int x;  //  x 좌표
    int y;  // y 좌표
    int turn;  // turn 횟수
    int dir; // 1: 상, 2: 하, 3: 좌, 4: 우

    Info(int x, int y, int turn, int dir) {
        this.x = x;
        this.y = y;
        this.turn = turn;
        this.dir = dir;
    }
}