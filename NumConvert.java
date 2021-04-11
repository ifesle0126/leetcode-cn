public class NumConvert {

    public static void main(String[] args) {
        int step = solution(100, 1000, 203, 2003, 0);
        System.out.println(step);
    }
    
    private static int solution(int a, int b, int A, int B, int step) {
        if (a > A || b > B) {
            return Integer.MAX_VALUE;
        }
        if (a == A && b == B) {
            return step;
        }
        return Math.min(solution(a + 1, b + 1, A, B, step + 1), solution(a * 2, b * 2, A, B, step + 1));
    }
}
