import java.util.Scanner;

public class SecondLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting dimensions for Matrix A
        System.out.println("Please enter the number of rows in Matrix A: ");
        int n = scanner.nextInt();
        System.out.println("Please enter the number of columns in Matrix A: ");
        int m = scanner.nextInt();

        // Declaring Matrix A
        int[][] matrix_A = new int[n][m];

        // Inputting Matrix A elements
        System.out.println("Please enter the elements of Matrix A: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix_A[i][j] = scanner.nextInt();
            }
        }

        // Getting dimensions for Matrix B
        System.out.println("Please enter the number of rows in Matrix B: ");
        int m_2 = scanner.nextInt();
        System.out.println("Please enter the number of columns in Matrix B: ");
        int p = scanner.nextInt();


        // Checking if Matrix A columns match with Matrix B rows)
        if (m != m_2) {
            System.out.println("number of columns in Matrix A and Matrix B are not equal. Try again");
            return; // Exits the program if dimensions are wrong
        }

        // Declaring Matrix B
        int[][] matrix_B = new int[m_2][p];

        // Inputting elements for Matrix B
        System.out.println("Please enter the elements of Matrix B: ");
        for (int i = 0; i < m_2; i++) {
            for (int j = 0; j < p; j++) {
                matrix_B[i][j] = scanner.nextInt();
            }
        }

        // Declaring Matrix C ( the Resultant Matrix)
        int[][] matrix_C = new int[n][p];


        // Performs the Matrix Multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                for (int k = 0; k < m; k++) {
                    matrix_C[i][j] += matrix_A[i][k] * matrix_B[k][j];
                }
            }
        }

        // Displays the result of Matrix C
        System.out.println("Matrix C equals: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                System.out.print(matrix_C[i][j] + " "); // Prints each element with a space
            }
            System.out.println();
        }
    }
}
