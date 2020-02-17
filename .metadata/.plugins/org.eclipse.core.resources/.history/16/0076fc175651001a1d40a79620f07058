package baekjoon;

import java.util.*;

public class Main {
    static PriorityQueue<Node> pq;
    static class Node implements Comparable<Node>{
        int index;
        int distance;
        int x, y;
        Node(int x, int y, int distance){
            this.x = x;
            this.y =y;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.distance<=o.distance ? -1 : 1;
        }
    }
    static int distance[][];
    static int map[][];
    static int dx [] = {0,0,-1,1};
    static int dy [] = {1,-1,0,0};
    static ArrayList<Node> [] list;
    static int count;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int index = 1;
        while(true) {
            count = sc.nextInt();
            if(count == 0)
                break;
            
            map = new int [count][count];
            distance = new int [count][count];
            pq = new PriorityQueue<>();
            for(int  i= 0; i < count; i++) {
                for(int j = 0; j < count; j++) {
                    map[i][j] = sc.nextInt();
                    distance[i][j]= Integer.MAX_VALUE;
                }
            }
            
            distance[0][0] = 0;
            pq.add(new Node(0,0,map[0][0]));

            dijkstra();
            System.out.println("Problem " + (index++) + ": "+ distance[count-1][count-1]);
        }

    }

    public static void dijkstra() {
        while(!pq.isEmpty()) {
            int x = pq.poll().x;
            int y = pq.poll().y;
            int dist = pq.peek().distance;
            pq.remove();
            for(int i=0; i<4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if(newX >=0 && newY>=0 && newX<count && newY<count) {
                    if(distance[newX][newY] > dist+map[newX][newY]) {
                        distance[newX][newY] = dist+map[newX][newY];
                        pq.offer(new Node(newX,newY,distance[newX][newY]));
                    }
                }
            }
        }
    }
}
