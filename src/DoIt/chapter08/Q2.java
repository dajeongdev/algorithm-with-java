package DoIt.chapter08;

import java.util.Scanner;

// 브루트-포스법으로 문자열을 검색하는 프로그램
public class Q2 {

    // 브루트-포스법으로 문자열을 검색하는 메소드
    static int bfMatchLast(String txt, String pat) {
        int pt = txt.length() - 1; // txt를 따라가는 커서
        int pp = pat.length() - 1; // pat를 따라가는 커서

        while (pt >= 0 && pp >= 0) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt--;
                pp--;
            } else {
                pt = pt + (pat.length() - pp) - 2;
                pp = pat.length() - 1;
            }
        }
        if (pp < 0) // 검색 성공!
            return pt + 1;
        return -1;  // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = sc.next(); // 텍스트용 문자열

        System.out.print("패턴 : ");
        String s2 = sc.next(); // 패턴용 문자열

        int idx = bfMatchLast(s1, s2); // 문자열 s1에서 s2를 검색

        if (idx == -1) {
            System.out.println("텍스트에 패턴이 없습니다.");
        } else {
            // 일치하는 문자 바로 앞까지의 길이를 구한다.
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i+1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패턴: %%%ds\n", len), s2);
        }
    }
}