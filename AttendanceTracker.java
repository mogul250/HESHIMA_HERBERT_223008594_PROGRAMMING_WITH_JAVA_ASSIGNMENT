import java.util.Scanner; // import Scanner for keyboard input

// Simple program for class attendance using a do-while loop and arrays (beginner concepts only)
public class AttendanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // create a Scanner for input

        // Ask for fixed class size (total number of students)
        System.out.print("Enter total number of students in the class: ");
        int totalStudents = sc.nextInt(); // total class size

        // Array to store attendance numbers per day (up to 30 days as specified)
        int[] attendance = new int[30]; // integer array with capacity for 30 entries

        int days = 0; // counter for how many days of records were entered
        String choice; // will store "yes" or "no" from user

        // Consume any leftover newline so next() works as expected
        sc.nextLine();

        // Use do-while to ensure at least one day's attendance is recorded
        do {
            System.out.print("Enter number of students present today: ");
            int present = sc.nextInt(); // read today's present count
            attendance[days] = present; // store in the array at index 'days'
            days++; // increase day count since we recorded one day

            // Consume leftover newline after nextInt()
            sc.nextLine();

            // Ask whether to continue for another day (stop when "no")
            if (days < 30) { // only ask if we still have space in the array
                System.out.print("Do you want to enter attendance for another day? (yes/no): ");
                choice = sc.nextLine(); // read the user's decision
            } else {
                choice = "no"; // reached maximum of 30 days, force stop
            }
        } while (choice.equalsIgnoreCase("yes")); // loop while the answer is "yes"

        // Now analyze the attendance data
        int sum = 0;     // will hold the total number of present students across all days
        int lowDays = 0; // will count days with attendance below 50% of total class size

        // Loop through the recorded days to compute statistics
        for (int i = 0; i < days; i++) { // iterate from 0 up to days-1
            sum += attendance[i]; // add today's presence to sum

            // Check if this day's attendance is below 50% threshold
            if (attendance[i] < (totalStudents * 0.5)) { // compare with half of class size
                lowDays++; // increment the count of low attendance days
            }
        }

        // Calculate average attendance: total present divided by number of days recorded
        double average = (days > 0) ? ((double) sum / days) : 0.0; // avoid division by zero

        // Print the attendance table
        System.out.println("\n----- ATTENDANCE REPORT -----"); // header line
        System.out.printf("%-8s %s%n", "Day", "Present"); // table headings
        System.out.println("-----------------------"); // separator

        for (int i = 0; i < days; i++) { // print each day's record
            System.out.printf("%-8s %d%n", "Day " + (i + 1), attendance[i]); // formatted row
        }

        // Show calculated statistics
        System.out.println("-----------------------"); // separator
        System.out.println("Total Days Recorded: " + days); // number of entries
        System.out.println("Average Attendance: " + average); // show average as a number
        double lowPercent = (days > 0) ? (((double) lowDays / days) * 100.0) : 0.0; // percent of low days
        System.out.println("Days with low attendance (<50%): " + lowDays + " (" + lowPercent + "%)"); // show low days summary

        sc.close(); // close the Scanner
    }
}
