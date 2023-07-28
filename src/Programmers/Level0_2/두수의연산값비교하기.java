package Programmers.Level0_2;

public class 두수의연산값비교하기 {
    /**
     * 문제 설명
     * 연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
     * 12 ⊕ 3 = 123
     * 3 ⊕ 12 = 312
     * 양의 정수 a와 b가 주어졌을 때, a ⊕ b와 2 * a * b 중 더 큰 값을 return하는 solution 함수를 완성해 주세요.
     * 단, a ⊕ b와 2 * a * b가 같으면 a ⊕ b를 return 합니다.
     *
     * 제한사항
     * 1 ≤ a, b < 10,000
     *
     * 입출력 예
     * a	b	result
     * 2	91	364
     * 91	2	912
     *
     * 입출력 예 설명
     * 입출력 예 #1
     * a ⊕ b = 291 이고, 2 * a * b = 364 입니다. 둘 중 더 큰 값은 364 이므로 364를 return 합니다.
     * 입출력 예 #2
     * a ⊕ b = 912 이고, 2 * a * b = 364 입니다. 둘 중 더 큰 값은 912 이므로 912를 return 합니다.
     */
    public int solution(int a, int b) {
        int ab = Integer.parseInt(a + "" + b);
        int ab2 = 2 * a * b;
        return ab >= ab2 ? ab : ab2;
    }

    public static void main(String[] args) {
        두수의연산값비교하기 T = new 두수의연산값비교하기();

        System.out.println(T.solution(2, 91));
        System.out.println(T.solution(91, 2));
    }
}
