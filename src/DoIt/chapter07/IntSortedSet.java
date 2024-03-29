package DoIt.chapter07;

// int형 집합
public class IntSortedSet {

    private int max;   // 집합의 최대 개수
    private int num;   // 집합의 요소 개수
    private int[] set; // 집합 본체

    // 생성자
    public IntSortedSet(int capacity) {
        num = 0;
        max = capacity;
        try {
            set = new int[max]; // 집합 배열 생성
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    // 집합의 용량
    public int capacity() {
        return max;
    }

    // 집합의 요솟수
    public int size() {
        return num;
    }

    // 집합에서 n을 검색한다. (index 반환)
    public int indexOf(int n) {
        int pl = 0;     // 검색 범위 맨 앞의 index
        int pr = n - 1; // 검색 범위 맨 뒤의 index

        do {
            int pc = (pl + pr) / 2; // 중앙 요소의 index
            if (set[pc] == n) {
                return pc; // 검색 성공
            } else if (set[pc] < n) {
                pl = pc + 1; // 검색 범위를 앞쪽 절반으로 좁힘
            } else {
                pr = pc - 1; // 검색 범위를 뒤쪽 절반으로 좁힘
            }
        } while (pl <= pr);

        return -pl - 1;        // 검색 실패
    }

    // 집합에 n이 있는지 없는지 확인한다.
    public boolean contains(int n) {
        return (indexOf(n) >= 0) ? true : false;
    }

    // 집합에 n을 추가한다.
    public boolean add(int n) {
        int idx;
        if (num >= max || (idx = indexOf(n)) >= 0) { // 가득 참 또는 들어 있음
            return false;
        } else {
            idx = -(idx + 1);
            num++;
            for (int i = num - 1; i > idx; i--)
                set[i] = set[i - 1];
            set[idx] = n;
            return true;
        }
    }

    // 집합에서 n을 삭제한다.
    public boolean remove(int n) {
        int idx; // n이 저장된 요소의 인덱스
        if (num <= 0 || (idx = indexOf(n)) == -1) { // 비어 있거나 n이 존재하지 않음
            return false;
        } else {
            num--;
            for (int i = idx; i < num; i++) // set[idx]를 삭제하고
                set[i] = set[i + 1];        // 그 다음 요소를 한 칸 앞으로 옮김
            return true;
        }
    }

    // 집합 s에 복사한다. (s <- this)
    public void copyTo(IntSortedSet s) {
        int n = (s.max < num) ? s.max : num; // 복수할 요소의 개수
        for (int i = 0; i < n; i++)
            s.set[i] = set[i];
        s.num = n;
    }

    // 집합 s를 복사한다. (this <- s)
    public void copyFrom(IntSortedSet s) {
        int n = (max < s.num) ? max : s.num; // 복사할 요소의 개수
        for (int i = 0; i < n; i++)
            set[i] = s.set[i];
        num = n;
    }

    // 집합 s와 같은지 확인한다.
    public boolean equalTo(IntSortedSet s) {
        if (num != s.num) // 요소 개수가 같지 않으면
            return false; // 집합도 같지 않음

        for (int i = 0; i < num; i++)
            if (set[i] == s.set[i])
                return false;
        return true;
    }

    // 집합 s1과 s2의 합집합을 복사한다.
    public void unionOf(IntSortedSet s1, IntSortedSet s2) {
        copyFrom(s1);                    // 집합 s1을 복사
        for (int i = 0; i < s2.num; i++) // 집합 s2의 요소를 추가
            add(s2.set[i]);
    }

    // "{a b c}" 형식의 문자열로 표현을 바꾼다.
    public String toString() {
        StringBuffer temp = new StringBuffer("{ ");
        for (int i = 0; i < num; i++)
            temp.append(set[i] + " ");
        temp.append("}");
        return temp.toString();
    }

    // 공집합인지 확인한다.
    public boolean isEmpty() {
        return num == 0;
    }

    // 집합이 가득 찼는지 확인한다.
    public boolean isFull() {
        return num >= max;
    }

    // 집합을 초기화한다. (모든 요소를 삭제)
    public void clear() {
        num = 0;
    }

    // 집합 s의 모든 요소를 추가한다. (집합 s의 합집합 구하기)
    public boolean add(IntSortedSet s) {
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if (add(set[i]))
                flag = true;
        return flag;
    }

    // 집합 s에 들어 있는 요소만 남기고 들어 있지 않은 요소는 삭제한다. (집합 s와의 교집합 구하기)
    public boolean retain(IntSortedSet s) {
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if (s.contains(set[i]) == false) {
                remove(set[i]);
                flag = true;
            }
        return flag;
    }

    // 집합 s에 들어 있는 요소를 삭제한다. (집합 s와의 차집합 구하기)
    public boolean remove(IntSortedSet s) {
        boolean flag = false;
        for (int i = 0; i < num; i++)
            if(s.contains(set[i])) {
                remove(set[i]);
                flag = true;
            }
        return flag;
    }

    // IntSet에 대해 집합 s의 부분집합인지 판단한다.
    public boolean isSubsetOf(IntSortedSet s) {
        for (int i = 0 ; i < num; i++) {
            int j = 0;
            for (; j < s.num; j++)
                if (set[i] == s.set[j])
                    break;
            if (j == s.num) // set[i]는 s에 포함되지 않음
                return false;
        }
        return true;
    }

    // IntSet에 대해 집합 s의 진부분집합인지 판단한다.
    public boolean isProperSubsetOf(IntSortedSet s) {
        if (num >= s.num) // 요소수가 s 이상이면
            return false; // s의 진부분집합이 아님
        return s.isSubsetOf(s);
    }

    // IntSet에 대해 집합 s1과 s2의 교집합을 복사한다.
    public void intersectionOf(IntSortedSet s1, IntSortedSet s2) {
        clear();

        for (int i = 0; i < s1.num; i++)
            if (s2.contains(s1.set[i]))
                add(s1.set[i]);
    }

    // IntSet에 대해 집합 s1과 s2의 차집합을 복사한다.
    public void differenceOf(IntSortedSet s1, IntSortedSet s2) {
        clear();

        for (int i = 0; i < s1.num; i++)
            if (!s2.contains(s1.set[i]))
                add(s1.set[i]);
    }
}
