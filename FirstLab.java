import java.util.Scanner;
import java.util.Arrays;

public class FirstLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;
        int Max_Grade, Min_Grade;
        double Average_Grade;
        int Sum_of_Grades = 0;
        int[] stats = new int[5];

        System.out.println("Please enter the number of students: ");
        N = scanner.nextInt();

        int[] scores = new int[N];

        System.out.println("Please enter the scores of all the students: ");
        for (int i = 0; i < N; i++) {
            scores[i] = getValidScore(scanner, i + 1);
        }
        Max_Grade = Arrays.stream(scores).max().getAsInt();
        Min_Grade = Arrays.stream(scores).min().getAsInt();

        for (int score : scores) {
            Sum_of_Grades += score;

            if (score > 80) {
                stats[4]++; // scores from 81 to 100
            } else if (score >= 61) {
                stats[3]++; // scores from 61 to 80
            } else if (score >= 41) {
                stats[2]++; // scores from 41 to 60
            } else if (score >= 21) {
                stats[1]++; // scores from 21 to 40
            } else {
                stats[0]++;
            }
        }

        Average_Grade = (double) Sum_of_Grades / N;
        System.out.println("Values: \n");
        System.out.println("Max grade is: " + Max_Grade);
        System.out.println("Min grade is: " + Min_Grade);
        System.out.println("Average grade is: " + Average_Grade);

        System.out.println("\nGraph:\n");
        int max_Height = getMax(stats);
        for (int i = max_Height; i > 0; i--) {
            System.out.printf("%3d >", i);
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print("#######  ");
                } else {
                    System.out.print("         ");
                }
            }
            System.out.println();
        }
        System.out.println("    +-------+-------+-------+-------+-------+");
        System.out.println("    | 0-20  | 21-40 | 41-60 | 61-80 | 81-100|");
    }

    private static int getValidScore(Scanner scanner, int student_Number) {
        while (true) {
            System.out.printf("Please enter the Student's score %d (0 to 100): ", student_Number);
            try {
                int score = scanner.nextInt();
                if (score >= 0 && score <= 100) {
                    return score;
                } else {
                    System.out.println("Invalid score. Please enter a valid score (0 to 100).");
                }
            } catch (Exception e) {
                System.out.println("Invalid score. Please enter a valid score (0 to 100).");
                scanner.next();
            }
        }
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
