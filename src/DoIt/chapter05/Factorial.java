package DoIt.chapter05;

import java.util.Scanner;

// 팩토리얼을 재귀적으로 구현
public class Factorial {

    // 양의 정수 n의 팩토리얼을 반환한다.
    static int factorial(int n) {
        return n > 0 ? n * factorial(n - 1) : 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("정수를 입력하세요. : ");
        int x = sc.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}