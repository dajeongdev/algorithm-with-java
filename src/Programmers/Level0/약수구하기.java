package Programmers.Level0;

import java.util.ArrayList;
import java.util.Arrays;

public class 약수구하기 {
    /**
     * 문제 설명
     * 정수 n이 매개변수로 주어질 때, n의 약수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 10,000
     *
     * 입출력 예
     * n	result
     * 24	[1, 2, 3, 4, 6, 8, 12, 24]
     * 29	[1, 29]
     *
     * 입출력 예 설명
     * 입출력 예 #1
     * 24의 약수를 오름차순으로 담은 배열 [1, 2, 3, 4, 6, 8, 12, 24]를 return합니다.
     * 입출력 예 #2
     * 29의 약수를 오름차순으로 담은 배열 [1, 29]를 return합니다.
     */
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        약수구하기 T = new 약수구하기();

        System.out.println(Arrays.toString(T.solution(24)));
        System.out.println(Arrays.toString(T.solution(29)));
    }
}
