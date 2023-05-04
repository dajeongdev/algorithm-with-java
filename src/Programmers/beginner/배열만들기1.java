package Programmers.beginner;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 배열만들기1 {
    /**
     * 문제 설명
     * 정수 n과 k가 주어졌을 때,
     * 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
     *
     * 제한사항
     * 1 ≤ n ≤ 1,000,000
     * 1 ≤ k ≤ min(1,000, n)
     *
     * 입출력 예
     * n	k	result
     * 10	3	[3, 6, 9]
     * 15	5	[5, 10, 15]
     *
     * 입출력 예 설명
     * 입출력 예 #1
     * 1 이상 10 이하의 3의 배수는 3, 6, 9 이므로 [3, 6, 9]를 return 합니다.
     * 입출력 예 #2
     * 1 이상 15 이하의 5의 배수는 5, 10, 15 이므로 [5, 10, 15]를 return 합니다.
     */
    public int[] solution(int n, int k) {
        int[] answer = new int[n / k];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = k;
            k += answer[0];
        }
        return answer;
    }

    public int[] otherSolution(int n, int k) {
        return IntStream.rangeClosed(1, n).filter(i -> i % k == 0).toArray();
    }

    public static void main(String[] args) {
        배열만들기1 T = new 배열만들기1();

        System.out.println(Arrays.toString(T.solution(10, 3)));
        System.out.println(Arrays.toString(T.solution(15, 5)));
        System.out.println(Arrays.toString(T.otherSolution(10, 3)));
        System.out.println(Arrays.toString(T.otherSolution(15, 5)));
    }
}
