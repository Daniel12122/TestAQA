package test;

public class SecondTask {
    public static void main(String[] args) {
        int n = 5;
        int m = 10;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (inRectangle(i, j, n, m)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            System.out.println();
        }
    }

    private static boolean inRectangle(int i, int j, int n, int m) {
        return i == 0 || i == n - 1 || j == 0 || j == m - 1;
    }
}
