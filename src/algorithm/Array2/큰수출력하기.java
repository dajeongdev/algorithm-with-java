package algorithm.Array2;

import java.util.ArrayList;
import java.util.Scanner;

public class 큰수출력하기 {
    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 1; i < n; i++) {
            if(arr[i] > arr[i - 1]) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        큰수출력하기 T = new 큰수출력하기();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        for(int x : T.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }
}
