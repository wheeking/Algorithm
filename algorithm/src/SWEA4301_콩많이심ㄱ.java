import java.util.Scanner;

public class SWEA4301_콩많이심ㄱ {
    public static int[][] visited;
    public static final int[] dx = {0, 0, 2, -2};
    public static final int[] dy = {2, -2, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int ans = 0;
            int N = sc.nextInt();
            int M = sc.nextInt();
            visited = new int[M][N];

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 4; k++) {
                        int newX = i + dx[k];
                        int newY = j + dy[k];
                        if (newX >= 0 && newY >=0 && newX < M && newY < N) {
                            if (visited[newX][newY] == 1) {
                                visited[i][j] = 0;
                                break;
                            }
                            visited[i][j] = 1;
                        } else
                            visited[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(visited[i][j] + " ");
                    if (visited[i][j] == 1)
                        ans++;
                }
                System.out.println();
            }
            System.out.println("#" + test_case + " " + ans);
        }
    }
}
