package Programmers.Level0_2;

import java.util.stream.IntStream;

public class 특별한이차원배열2 {
    /**
     * 문제 설명
     * n × n 크기의 이차원 배열 arr이 매개변수로 주어질 때,
     * arr이 다음을 만족하면 1을 아니라면 0을 return 하는 solution 함수를 작성해 주세요.
     *
     * 0 ≤ i, j < n인 정수 i, j에 대하여 arr[i][j] = arr[j][i]
     *
     * 제한사항
     * 1 ≤ arr의 길이 = arr의 원소의 길이 ≤ 100
     * 1 ≤ arr의 원소의 원소 ≤ 1,000
     * 모든 arr의 원소의 길이는 같습니다.
     *
     * 입출력 예
     * arr	result
     * [[5, 192, 33], [192, 72, 95], [33, 95, 999]]	1
     * [[19, 498, 258, 587], [63, 93, 7, 754], [258, 7, 1000, 723], [587, 754, 723, 81]]	0
     *
     * 입출력 예 설명
     * 입출력 예 #
     * 예제 1번에서 문제의 조건이 잘 보이도록 표를 만들면 다음과 같습니다.
     * i	j	arr[i][j]	arr[j][i]
     * 0	0	5	5
     * 0	1	192	192
     * 0	2	33	33
     * 1	0	192	192
     * 1	1	72	72
     * 1	2	95	95
     * 2	0	33	33
     * 2	1	95	95
     * 2	2	999	999
     * 조건을 만족하므로 1을 return 합니다.
     * 입출력 예 #2
     * 예제 2번의 arr에서 arr[0][1] = 498 ≠ 63 = arr[1][0]이므로 조건을 만족하지 않습니다. 따라서 0을 return 합니다.
     */
    public int solution(int[][] arr) {
        int answer = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != arr[j][i]) return 0;
            }
        }
        return answer;
    }

    public int otherSolution(int[][] arr) {
        return IntStream.range(0, arr.length).allMatch(i ->
                IntStream.range(i + 1, arr.length).allMatch(j -> arr[i][j] == arr[j][i])) ? 1 : 0;
    }

    public static void main(String[] args) {
        특별한이차원배열2 T = new 특별한이차원배열2();

        int[][] arr1 = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
        int[][] arr2 = {{19, 498, 258, 587}, {63, 93, 7, 754}, {258, 7, 1000, 723}, {587, 754, 723, 81}};

        System.out.println(T.solution(arr1));
        System.out.println(T.solution(arr2));
        System.out.println(T.otherSolution(arr1));
        System.out.println(T.otherSolution(arr2));
    }
}
