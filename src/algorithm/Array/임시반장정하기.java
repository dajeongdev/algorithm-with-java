package algorithm.Array;

import java.util.Scanner;

public class 임시반장정하기 {
    public int solution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        for(int i =1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= 5; k++) {
                    if(arr[i][k] == arr[j][k]) { // i번 학생과 같은 반을 한 j반 학
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt > max) {
                max = cnt; // 최댓값
                answer = i; // i번 학생이 임시 반장
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        임시반장정하기 T = new 임시반장정하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n + 1][6];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 5; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n, arr));
    }
}
