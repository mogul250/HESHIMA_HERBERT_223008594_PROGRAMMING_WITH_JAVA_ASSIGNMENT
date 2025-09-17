import java.util.Scanner; // import Scanner for keyboard input

// Simple program for supermarket billing using a for-loop (beginner concepts only)
public class SupermarketBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // create a Scanner object to read input

        // Ask the cashier how many different items were bought
        System.out.print("Enter number of different items bought: ");
        int n = sc.nextInt(); // read integer count of items

        // Create arrays to store details for each item (same size as number of items)
        String[] itemNames = new String[n]; // stores item names
        int[] quantities = new int[n];      // stores quantities per item
        double[] prices = new double[n];    // stores price per unit per item
        double[] subtotals = new double[n]; // stores subtotal per item (price * quantity)

        double total = 0.0; // this will hold the grand total before discount

        // Consume the leftover newline after nextInt so that nextLine works correctly
        sc.nextLine(); // moves the scanner to the next line

        // Use a for loop to repeat input for each item
        for (int i = 0; i < n; i++) { // start loop from 0 up to n-1
            System.out.println("\nItem " + (i + 1) + " details:"); // show which item we are entering

            // Read the item name (use nextLine to allow spaces in the name)
            System.out.print("Enter item name: ");
            itemNames[i] = sc.nextLine(); // store name in the array

            // Read the price per unit (double allows decimals)
            System.out.print("Enter price per unit: ");
            prices[i] = sc.nextDouble(); // store price

            // Read the quantity purchased (integer)
            System.out.print("Enter quantity: ");
            quantities[i] = sc.nextInt(); // store quantity

            // Calculate subtotal for this item: price × quantity
            subtotals[i] = prices[i] * quantities[i]; // simple arithmetic multiplication

            // Add this item's subtotal to the grand total
            total += subtotals[i]; // running sum

            // Consume the leftover newline so the next item name input works with nextLine()
            sc.nextLine();
        }

        // Check if discount applies: if total > 50,000 → 5% discount
        double discount = 0.0; // start with no discount
        if (total > 50000) { // if condition to test the threshold
            discount = total * 0.05; // calculate 5% of total
        }

        // Final amount to pay after subtracting discount
        double finalAmount = total - discount; // subtraction

        // Print a formatted receipt showing all items and totals
        System.out.println("\n========== RECEIPT =========="); // header line
        System.out.printf("%-20s %8s %12s %12s%n", "Item", "Qty", "Price", "Subtotal"); // column titles
        System.out.println("-----------------------------------------------"); // separator
        for (int i = 0; i < n; i++) { // loop to print each item line
            System.out.printf("%-20s %8d %12.2f %12.2f%n",
                itemNames[i], quantities[i], prices[i], subtotals[i]); // formatted row
        }
        System.out.println("-----------------------------------------------"); // separator
        System.out.printf("%-20s %32.2f%n", "Grand Total:", total); // show total before discount
        System.out.printf("%-20s %32.2f%n", "Discount:", discount); // show discount amount
        System.out.printf("%-20s %32.2f%n", "Final Amount:", finalAmount); // show final payable

        sc.close(); // close the Scanner (good practice)
    }
}
