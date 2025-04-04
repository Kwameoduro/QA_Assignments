import java.util.Scanner;

public class SecondLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the number of rows in Matrix A: ");
        int n = scanner.nextInt();

        System.out.println("Please enter the number of columns in Matrix A: ");
        int m = scanner.nextInt();

        int[][] matrix_A = new int[n][m];

        System.out.println("Please enter the elements of Matrix A: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix_A[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Please enter the number of rows in Matrix B: ");
        int m_2 = scanner.nextInt();

        System.out.println("Please enter the number of columns in Matrix B: ");
        int p = scanner.nextInt();

        if (m != m_2) {
            System.out.println("number of columns in Matrix A and Matrix B are not equal. Try again");
            return;
        }
        int[][] matrix_B = new int[m_2][p];
        System.out.println("Please enter the elements of Matrix B: ");
        for (int i = 0; i < m_2; i++) {
            for (int j = 0; j < p; j++) {
                matrix_B[i][j] = scanner.nextInt();
            }
        }

        int[][] matrix_C = new int[n][p];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    matrix_C[i][j] += matrix_A[i][k] * matrix_B[k][j];
                }
            }
        }
        System.out.println("Matrix C equals: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(matrix_C[i][j] + " ");
            }
            System.out.println();
        }
    }
}

