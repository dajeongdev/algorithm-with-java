package Java.array;

import java.util.Scanner;

// 좌표에 X표하기
public class MultiArrEx1 {

    public static void main(String[] args) {
        final int SIZE = 10;
        int x = 0, y = 0;

        char[][] board = new char[SIZE][SIZE];
        byte[][] shipBoard = {
                // 1 2 3 4 5 6 7 8 9
                { 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 1
                { 1, 1, 1, 1, 0, 0, 1, 0, 0 }, // 2
                { 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 3
                { 0, 0, 0, 0, 0, 0, 1, 0, 0 }, // 4
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, // 5
                { 1, 1, 0, 1, 0, 0, 0, 0, 0 }, // 6
                { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 7
                { 0, 0, 0, 1, 0, 0, 0, 0, 0 }, // 8
                { 0, 0, 0, 0, 0, 1, 1, 1, 0 }, // 9
        };

        // 1행에 행번호를, 1열에 열번호를 저장함
        for (int i = 1; i < SIZE; i++)
            board[0][i] = board[i][0] = (char)(i+'0');

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.printf("좌표를 입력하세요. (종료는 00)> ");
            String input = sc.nextLine();

            if (input.length() == 2) { // 두 글자를 입력한 경우
                x = input.charAt(0) - '0'; // 문자를 숫자로 변환
                y = input.charAt(1) - '0';

                if (x == 0 && y == 0)
                    break; // x와 y 모두 0인 경우 종료
            }
            if (input.length() != 2 || x <= 0 || x >= SIZE || y <= 0 || y >= SIZE) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                continue;
            }

            // shipBoard[x-1][y-1]의 값이 1이면, 'O'을 board[x][y]에 저장함
            board[x][y] = shipBoard[x-1][y-1] == 1 ? '0' : 'X';
            // 배열 board의 내용을 화면에 출력
            for (int i = 0; i < SIZE; i++)
                System.out.println(board[i]);
            System.out.println();
        }
    }
}
