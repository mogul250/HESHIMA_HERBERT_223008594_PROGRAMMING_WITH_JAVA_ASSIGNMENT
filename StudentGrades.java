import java.util.Scanner; // import Scanner for keyboard input

// Simple program for grading using a sentinel-controlled while-loop (beginner concepts only)
public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // create a Scanner for input

        int totalStudents = 0; // counter for how many students were entered
        int pass = 0;          // counter for number of passes (marks >= 50)
        int fail = 0;          // counter for number of fails (marks < 50)

        // Use an infinite loop and break when sentinel (-1) is entered
        while (true) { // starts a loop that will continue until we break out
            System.out.print("Enter student marks (0-100) or -1 to stop: ");
            int marks = sc.nextInt(); // read the marks as an integer

            // Check for sentinel value to end input
            if (marks == -1) { // if user typed -1
                break; // exit the while loop
            }

            // Basic validation hint (optional): you can ignore or warn on invalid inputs
            if (marks < 0 || marks > 100) { // check if marks are outside valid range
                System.out.println("Invalid marks. Please enter a value between 0 and 100, or -1 to stop.");
                continue; // skip the rest of the loop and ask again
            }

            totalStudents++; // we have one more valid student

            // Decide the grade using if-else chains (ranges provided in the task)
            if (marks >= 80) {
                System.out.println("Grade: A"); // print immediately
            } else if (marks >= 70) { // marks 70–79
                System.out.println("Grade: B");
            } else if (marks >= 60) { // marks 60–69
                System.out.println("Grade: C");
            } else if (marks >= 50) { // marks 50–59
                System.out.println("Grade: D");
            } else { // marks below 50
                System.out.println("Grade: F");
            }

            // Update pass/fail counters
            if (marks >= 50) { // pass condition
                pass++; // increase pass count
            } else { // fail condition
                fail++; // increase fail count
            }
        }

        // After input ends, print a summary report
        System.out.println("\n------ SUMMARY REPORT ------"); // header text
        System.out.println("Total Students: " + totalStudents); // show how many students
        System.out.println("Passed: " + pass); // number of passes
        System.out.println("Failed: " + fail); // number of fails

        // Calculate pass rate percentage (avoid division by zero)
        if (totalStudents > 0) { // ensure we do not divide by zero
            double passRate = ((double) pass / totalStudents) * 100.0; // convert to double for accurate percentage
            System.out.println("Pass Rate: " + passRate + "%"); // show percent
        } else {
            System.out.println("Pass Rate: N/A (no students entered)"); // message when no data
        }

        sc.close(); // close the Scanner
    }
}
