import java.util.Scanner;

public class SWEA2007_패턴마디 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			String str = sc.next();
			
			String str2 = "";
			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				// �옄由우닔(i)瑜� �뒛�젮媛�硫� 鍮꾧탳 臾몄옄�뿴�쓣 �깮�꽦�븳�떎(str2)
				str2 += str.charAt(i);
				// str2�� str�쓽 洹� �떎�쓬 洹� �겕湲곗쓽 湲��옄媛� 媛숈�吏� �솗�씤
				// 媛숈쑝硫� 洹멸쾶 諛섎났�븯�뒗 臾몄옄�뿴.
				// break �븞�븯硫� �뮘源뚯� 媛��꽌 �씤�뜳�뒪�삤諛�
				if (str2.equals(str.substring(i+1, i+1+i+1))) {
					cnt = str2.length();
					break;
				}
			}
			
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}