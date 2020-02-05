import java.util.Scanner;
 
public class SWEA1223_계산기2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            String str = sc.next();
            
            char[] stack = new char[n+1]; // 연산자만 저장
            char[] arr = new char[n+1]; // 출력대신 저장
            int arr_index = 0; // arr 인덱스 관리
            int top = -1; // 스택의 인덱스 관리용
            
            for (int i = 0; i < n; i++) {             
                char c = str.charAt(i);
                
                switch (c) {
                case '*':
                    // 스택에 나보다 우선순위가 작은 것이 남아 있을때까지 꺼내서 arr에 저장
                    while(top > -1 && (stack[top] == '*')) {
                            arr[arr_index++] = stack[top];
                            top--;
                    }
                    stack[++top] = c;
                    break;
                    
                case '+':
                    // 스택에 나보다 우선순위가 작은 것이 남아 있을때까지 꺼내서 arr에 저장
                    while(top > -1 && (stack[top] == '*' || stack[top] == '+')) {
                        arr[arr_index++] = stack[top];
                        top--;
                    }
                    stack[++top] = c;
                    break;
 
                default:
                    // 숫자인 경우 그냥 저장
                    arr[arr_index++] = c;
                    break;
                }
            }
            // stack에 남아있는 값들 arr에 삽입
            while(top > -1) {
                arr[arr_index++] = stack[top--];
            }
            
            int top2 = -1;
            int[] arr_num = new int[n]; // 후위표기법 arr 중에서 숫자만 저장하는 스택
            
            for (int i = 0; i < arr.length-1; i++) {
                char c = arr[i];
                String c2 = Character.toString(c);
                //System.out.print("c : " + c + " ");
                int num1 , num2;
                
                if(c2.equals("+")) { // 곱과 똑같
                    num2 = arr_num[top2--];
                    num1 = arr_num[top2--];
                    arr_num[++top2] = num1 + num2;
                }
                else if(c2.equals("*")) { // *면 현재 arr_num값과 그 전 값을 빼서 연산해주고 인덱스를 한 개 증가시킨 뒤 거기에 저장
                    num2 = arr_num[top2--];
                    num1 = arr_num[top2--];
                    arr_num[++top2] = num1 * num2;
                }
                else { // 숫자면 그냥 저장
                    arr_num[++top2] = Integer.parseInt(c2);
                }                
            }            
            System.out.println("#" + tc + " " + arr_num[0]);
        }        
    }
}