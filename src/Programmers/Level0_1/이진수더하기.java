package Programmers.Level0_1;

public class 이진수더하기 {
    /**
     * 문제 설명
     * 이진수를 의미하는 두 개의 문자열 bin1과 bin2가 매개변수로 주어질 때,
     * 두 이진수의 합을 return하도록 solution 함수를 완성해주세요.
     *
     * 제한사항
     * return 값은 이진수를 의미하는 문자열입니다.
     * 1 ≤ bin1, bin2의 길이 ≤ 10
     * bin1과 bin2는 0과 1로만 이루어져 있습니다.
     * bin1과 bin2는 "0"을 제외하고 0으로 시작하지 않습니다.
     *
     * 입출력 예
     * bin1	bin2	result
     * "10"	"11"	"101"
     * "1001"	"1111"	"11000"
     *
     * 입출력 예 설명
     * 입출력 예 #1
     * 10 + 11 = 101 이므로 "101" 을 return합니다.
     * 입출력 예 #2
     * 1001 + 1111 = 11000 이므로 "11000"을 return합니다.
     */
    public String solution(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
    }

    public static void main(String[] args) {
        이진수더하기 T = new 이진수더하기();

        System.out.println(T.solution("10", "11"));
        System.out.println(T.solution("1001", "1111"));
    }
}
