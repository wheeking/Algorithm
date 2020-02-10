import java.util.*;

public class SWEA1238_Contact {
    private static ArrayList<Integer>[] list;
    private static int[] visited;
    private static int[] ans;
    private static int depMax = 0;
    private static int ansMax = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            int start = sc.nextInt();
            depMax = 0;
            ansMax = 0;
            visited = new int[N+1];
            ans = new int[N];
            list = (ArrayList<Integer>[]) new ArrayList[101];

            for (int i = 0; i < 101; i++) {
                list[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < N / 2; i++) {
                int m = sc.nextInt();
                int n = sc.nextInt();

                list[m].add(n);
            }
            for (int i = 0; i < 101; i++) {
                Collections.sort(list[i]);
            }

            visited[start] = 1;
            qInfo st = new qInfo(start, 1);
            bfs(st);

            System.out.println("#" + test_case + " " + ansMax);
        }
    }

    public static void bfs(qInfo start) {
        Queue<qInfo> q = new LinkedList<qInfo>();

        q.offer(start);

        while(!q.isEmpty()) {
            qInfo temp = q.poll();
            int v = temp.v;
            int dep = temp.depth;


            int i;
            int flag = 0;
            qInfo tempQ = null;
            for (i = 0; i < list[v].size(); i++) {
                if (visited[list[v].get(i)] == 0) {
                    tempQ = new qInfo(list[v].get(i), dep+1);
                    q.offer(tempQ);
                    visited[list[v].get(i)] = 1;
                    flag = 1;
                }
            }

            if (flag == 0) {
//                if (dep >= depMax) {
//                    depMax = dep;
//                    if (v > ansMax) {
//                        ansMax = v;
//                    }
//                }
                // depMax 보다 클때랑, depMax랑 같을 때를 따로 비교하여야 함.
                if (dep > depMax) {
                    depMax = dep;
                    ansMax = v;
                } else if (dep == depMax && v > ansMax)
                    ansMax = v;
            }
        }
    }
}

class qInfo {
    int v;
    int depth;

    qInfo(int v, int depth) {
        this.v = v;
        this.depth = depth;
    }
}