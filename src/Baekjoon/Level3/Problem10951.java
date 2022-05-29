package Baekjoon.Level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10951 {
    /**
     * [A+B - 4]
     * 입력이 끝날 때까지 A+B를 출력하는 문제. EOF에 대해 알아 보세요.
     *
     * 문제
     * 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
     *
     * 입력
     * 입력은 여러 개의 테스트 케이스로 이루어져 있다.
     *
     * 각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
     *
     * 출력
     * 각 테스트 케이스마다 A+B를 출력한다.
     *
     * 예제 입력 1
     * 1 1
     * 2 3
     * 3 4
     * 9 8
     * 5 2
     * 예제 출력 1
     * 2
     * 5
     * 7
     * 17
     * 7
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String nums;

        while ((nums = br.readLine()) != null) {
            int A = nums.charAt(0) - 48;
            int B = nums.charAt(2) - 48;
            sb.append(A + B).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}
