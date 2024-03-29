package algorithm.Array;

import java.util.ArrayList;
import java.util.Scanner;

public class 뒤집은소수 {
    public boolean isPrime(int num) { // 소수인지 확인
        if(num == 1) {
            return false;
        }
        for(int i = 2; i < num; i++) {
            if(num % i == 0) { // 약수 존재 -> 소수 아님
                return false;
            }
        }
        return true; // 1 아니고 약수 아님 -> 소수
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while(tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(res)) {
                answer.add(res);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        뒤집은소수 T = new 뒤집은소수();
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
