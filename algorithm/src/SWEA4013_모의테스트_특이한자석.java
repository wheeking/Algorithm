import java.util.Scanner;

public class SWEA4013_모의테스트_특이한자석 {
    public static int[][] magnet = new int[4][8];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int K = sc.nextInt();

            for (int i = 0; i < magnet.length; i++) {
                for (int j = 0; j < magnet[i].length; j++) {
                    magnet[i][j] = sc.nextInt();
                }
            }
            
            for (int i = 0; i < K; i++) {
                int num = sc.nextInt();
                int dir = sc.nextInt();

                rotate(magnet, num, dir);
            }

            int sum = 0;
            if (magnet[0][0] == 1) {
                sum += 1;
            }
            if (magnet[1][0] == 1) {
                sum += 2;
            }
            if (magnet[2][0] == 1) {
                sum += 4;
            }
            if (magnet[3][0] == 1) {
                sum += 8;
            }

            System.out.println("#" + test_case + " " + sum);
        }
    }

    // 1번 자석은 2번 인덱스. 2번 자석은 왼쪽 6번 오른쪽 2번 인덱스. 3번 자석은 왼쪽 6번 오른쪽 2번 인덱스. 5번 좌석은 왼쪽 6번 인덱
    public static void rotate(int[][] m, int num, int dir) {
        int[] check = check(m);

        if (num == 1) {
            rotateOne(m[0], dir);
            if (check[0] == 1) {
                rotateOne(m[1], dir*-1);
                if (check[1] == 1) {
                    rotateOne(m[2], dir);
                    if (check[2] == 1) {
                        rotateOne(m[3], dir*-1);
                    }
                }
            }
        } else if (num == 2) {
            rotateOne(m[1], dir);
            if (check[0] == 1) {
                rotateOne(m[0], dir*-1);
            }
            if (check[1] == 1) {
                rotateOne(m[2], dir*-1);
                if (check[2] == 1) {
                    rotateOne(m[3], dir);
                }
            }
        } else if (num == 3) {
            rotateOne(m[2], dir);
            if (check[2] == 1) {
                rotateOne(m[3], dir*-1);
            }
            if (check[1] == 1) {
                rotateOne(m[1], dir*-1);
                if (check[0] == 1) {
                    rotateOne(m[0], dir);
                }
            }
        } else {
            rotateOne(m[3], dir);
            if (check[2] == 1) {
                rotateOne(m[2], dir*-1);
                if (check[1] == 1) {
                    rotateOne(m[1], dir);
                    if (check[0] == 1) {
                        rotateOne(m[0], dir*-1);
                    }
                }
            }
        }
    }

    public static void rotateOne(int[] m, int dir) {
        if (dir == 1) { // 시계방향
            int temp = m[7];
            // 자기보다 앞의 인덱스를 가져오려는데 포문에서 먼저 값을 변경했기에 오류가 남. 조심할 것.
            // 뒤에서 부터 돌리면 될듯
            for (int i = m.length-1; i >0; i--) {
                m[i] = m[i-1];
            }
            m[0] = temp;
        } else {    // 반시계방향
            int temp2 = m[0];
            for (int i = 0; i < m.length-1; i++) {
                m[i] = m[i + 1];
            }
            m[7] = temp2;
        }
    }

    
    public static int[] check(int[][] m) {
        int[] check = new int[3];
        if (m[0][2] == m[1][6]) {
            check[0] = 0;
        } else check[0] = 1;        // 다른 자성이면 1
        if (m[1][2] == m[2][6]) {
            check[1] = 0;
        } else check[1] = 1;
        if (m[2][2] == m[3][6]) {
            check[2] = 0;
        } else check[2] = 1;
        return check;
    }
}