package Programmers.Level1_1;

public class 문자열다루기기본 {
    /**
     * [문제 설명]
     * 문자열 s의 길이가 4 혹은 6이고, 숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
     * 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
     *
     * [제한 사항]
     * s는 길이 1 이상, 길이 8 이하인 문자열입니다.
     *
     * [입출력 예]
     * s	return
     * "a234"	false
     * "1234"	true
     */
    public  boolean solution(String s) {
        boolean answer = true;

        if (s.length() != 4 && s.length() != 6) return false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }

        return answer;
    }

    /***
     * 참고할 만한 풀이
     */
    public boolean otherAnswer(String s) {
        if(s.length() == 4 || s.length() == 6){
            try{
                int x = Integer.parseInt(s);
                return true;
            } catch(NumberFormatException e){
                return false;
            }
        }
        else return false;
    }
}
