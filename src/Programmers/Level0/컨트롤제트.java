package Programmers.Level0;

import java.util.Stack;

public class 컨트롤제트 {
    /**
     * 문제 설명
     * 숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다.
     * 문자열에 있는 숫자를 차례대로 더하려고 합니다.
     * 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다.
     * 숫자와 "Z"로 이루어진 문자열 s가 주어질 때,
     * 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
     *
     * 제한사항
     * 1 ≤ s의 길이 ≤ 200
     * -1,000 < s의 원소 중 숫자 < 1,000
     * s는 숫자, "Z", 공백으로 이루어져 있습니다.
     * s에 있는 숫자와 "Z"는 서로 공백으로 구분됩니다.
     * 연속된 공백은 주어지지 않습니다.
     * 0을 제외하고는 0으로 시작하는 숫자는 없습니다.
     * s는 "Z"로 시작하지 않습니다.
     * s의 시작과 끝에는 공백이 없습니다.
     * "Z"가 연속해서 나오는 경우는 없습니다.
     *
     * 입출력 예
     * s	result
     * "1 2 Z 3"	4
     * "10 20 30 40"	100
     * "10 Z 20 Z 1"	1
     * "10 Z 20 Z"	0
     * "-1 -2 -3 Z"	-3
     *
     * 입출력 예 설명
     * 입출력 예 #1
     * 본문과 동일합니다.
     * 입출력 예 #2
     * 10 + 20 + 30 + 40 = 100을 return 합니다.
     * 입출력 예 #3
     * "10 Z 20 Z 1"에서 10 다음 Z, 20 다음 Z로 10, 20이 지워지고 1만 더하여 1을 return 합니다.
     */
    public int solution(String s) {
        int answer = 0;
        int temp = 0;
        for (String num : s.split(" ")) {
            if (!"Z".equals(num)) {
                answer += Integer.parseInt(num);
                temp = Integer.parseInt(num);
            } else {
                answer -= temp;
                continue;
            }
        }
        return answer;
    }

    public int otherSolution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (String num : s.split(" ")) {
            if (num.equals("Z")) {
                if (!stack.isEmpty()) answer -= stack.pop();
            } else {
                answer += stack.push(Integer.parseInt(num));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        컨트롤제트 T = new 컨트롤제트();

        System.out.println(T.solution("1 2 Z 3"));
        System.out.println(T.solution("10 20 30 40"));
        System.out.println(T.solution("10 Z 20 Z 1"));
        System.out.println(T.solution("10 Z 20 Z"));
        System.out.println(T.solution("-1 -2 -3 Z"));

        System.out.println(T.otherSolution("1 2 Z 3"));
        System.out.println(T.otherSolution("10 20 30 40"));
        System.out.println(T.otherSolution("10 Z 20 Z 1"));
        System.out.println(T.otherSolution("10 Z 20 Z"));
        System.out.println(T.otherSolution("-1 -2 -3 Z"));
    }
}
