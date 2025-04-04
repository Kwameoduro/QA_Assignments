import java.util.Scanner;
import java.util.Arrays;

public class FirstLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N;  // the number of students
        int Max_Grade, Min_Grade;  // the variables to store maximum and minimum grades
        double Average_Grade;  // the variable to store the average grade
        int Sum_of_Grades = 0; // the sum of all grades
        int[] stats = new int[5];  // array to store count of students in grade ranges


        // Getting scores of all students
        System.out.println("Please enter the number of students: ");
        N = scanner.nextInt();

        int[] scores = new int[N]; // Array to store student scores

        // Getting scores of all the students
        System.out.println("Please enter the scores of all the students: ");
        for (int i = 0; i < N; i++) {
            scores[i] = getValidScore(scanner, i + 1);
        }

        // Finding the maximum and minimum grades
        Max_Grade = Arrays.stream(scores).max().getAsInt();
        Min_Grade = Arrays.stream(scores).min().getAsInt();


        // grouping scores in different grade ranges
        for (int score : scores) {
            Sum_of_Grades += score; // calculates the total sum of scores

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

        // Calculating the average grade
        Average_Grade = (double) Sum_of_Grades / N;

        // Displays Statistics
        System.out.println("Values: \n");
        System.out.println("Max grade is: " + Max_Grade);
        System.out.println("Min grade is: " + Min_Grade);
        System.out.println("Average grade is: " + Average_Grade);


        // Generating a graph representation of the grades distribution
        System.out.println("\nGraph:\n");
        int max_Height = getMax(stats); // finding the highest frequency in any grade range
        for (int i = max_Height; i > 0; i--) {
            System.out.printf("%3d >", i);
            for (int stat : stats) {
                if (stat >= i) {
                    System.out.print("#######  "); // printing the bars for the range
                } else {
                    System.out.print("         "); // empty if no students are in the range
                }
            }
            System.out.println();
        }

        // Display grade ranges below the graph
        System.out.println("    +-------+-------+-------+-------+-------+");
        System.out.println("    | 0-20  | 21-40 | 41-60 | 61-80 | 81-100|");
    }


    // method to validate and get a student's score within range 0 to 100
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
                scanner.next(); // Clears invalid input
            }
        }
    }

    // Method to get the highest value in the array
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
