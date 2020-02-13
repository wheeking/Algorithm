import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// Comparable Overriding

public class SWEA1258_행렬찾기 {
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static int[][] map;
	public static int[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			ArrayList<Loc> list = new ArrayList<Loc>();
			ArrayList<Loc> ansList = new ArrayList<Loc>();
			int N = sc.nextInt();
			map = new int[N][N];
			visited = new int[N][N];
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					if (visited[i][j] == 0 && map[i][j] != 0) {
						Loc loc = new Loc(i, j);
						list.add(loc);
						dfs(loc);
						continue;
					}
				}
			}
			
			// 크기 저장할 어레이
			int[] xArr = new int[list.size()];
			int[] yArr = new int[list.size()];
			
			for (int k = 0; k < list.size(); k++) {
				int x = list.get(k).x;
				int y = list.get(k).y;
				int cntx = 0;
				int cnty = 0;
				for (int i = x; i < map.length; i++) {
					if (visited[i][y] == 0)
						break;
					else
						cntx++;
				}
				for (int i = y; i < map.length; i++) {
					if (visited[x][i] == 0)
						break;
					else
						cnty++;
				}
				
				ansList.add(new Loc(cntx, cnty));
			}
			
			Collections.sort(ansList);
			
			System.out.print("#" + test_case + " " + list.size() + " ");
			for (int i = 0; i < ansList.size(); i++) {
				System.out.print(ansList.get(i).x + " ");
				System.out.print(ansList.get(i).y + " ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(Loc loc) {
		int x = loc.x;
		int y = loc.y;
		
		visited[x][y] = 1;
		for (int k = 0; k < dx.length; k++) {
			int newX = x + dx[k];
			int newY = y + dy[k];
			
			if (newX >= 0 && newY >= 0 && newX < map.length && newY < map.length) {
				if (visited[newX][newY] == 0 && map[newX][newY] != 0) {
					visited[newX][newY] = 1;
					dfs(new Loc(newX, newY));
				}
			}
		}
	}
}

class Loc implements Comparable<Loc> {
	int x;
	int y;
	
	Loc(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Loc o) {
		if (this.x*this.y > o.x*o.y) {
			return 1;
		} else if(this.x*this.y < o.x*o.y) {
			return -1;
		} else if(this.x*this.y == o.x*o.y && this.x > o.x) {
			return 1;
		} else if(this.x*this.y == o.x*o.y && this.x < o.x) {
			return -1;
		}
		
		return 0;
	}
}