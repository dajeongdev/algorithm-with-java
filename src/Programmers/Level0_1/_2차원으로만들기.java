package Programmers.Level0_1;

import java.util.Arrays;

public class _2차원으로만들기 {
    /**
     * 문제 설명
     * 정수 배열 num_list와 정수 n이 매개변수로 주어집니다.
     * num_list를 다음 설명과 같이 2차원 배열로 바꿔 return하도록 solution 함수를 완성해주세요.
     *
     * num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다.
     * 2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩 나눠 2차원 배열로 변경합니다.
     *
     * num_list	n	result
     * [1, 2, 3, 4, 5, 6, 7, 8]	2	[[1, 2], [3, 4], [5, 6], [7, 8]]
     *
     * 제한사항
     * num_list의 길이는 n의 배 수개입니다.
     * 0 ≤ num_list의 길이 ≤ 150
     * 2 ≤ n < num_list의 길이
     *
     * 입출력 예
     * num_list	n	result
     * [1, 2, 3, 4, 5, 6, 7, 8]	2	[[1, 2], [3, 4], [5, 6], [7, 8]]
     * [100, 95, 2, 4, 5, 6, 18, 33, 948]	3	[[100, 95, 2], [4, 5, 6], [18, 33, 948]]
     *
     * 입출력 예 설명
     * 입출력 예 #1
     * num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 2 * 4 배열로 변경한 [[1, 2], [3, 4], [5, 6], [7, 8]] 을 return합니다.
     * 입출력 예 #2
     * num_list가 [100, 95, 2, 4, 5, 6, 18, 33, 948] 로 길이가 9이고 n이 3이므로 3 * 3 배열로 변경한 [[100, 95, 2], [4, 5, 6], [18, 33, 948]] 을 return합니다.
     */
    public int[][] solution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        int count = 0;
        for (int i = 0; i < num_list.length / n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = num_list[count];
                count++;
            }
        }
        return answer;
    }

    public int[][] otherSolution(int[] num_list, int n) {
        int[][] answer = new int[num_list.length / n][n];
        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        _2차원으로만들기 T = new _2차원으로만들기();

        int[] numList1 = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] numList2 = {100, 95, 2, 4, 5, 6, 18, 33, 948};

        System.out.println(Arrays.deepToString(T.solution(numList1, 2)));
        System.out.println(Arrays.deepToString(T.solution(numList2, 3)));
        System.out.println(Arrays.deepToString(T.otherSolution(numList1, 2)));
        System.out.println(Arrays.deepToString(T.otherSolution(numList2, 3)));
    }
}
