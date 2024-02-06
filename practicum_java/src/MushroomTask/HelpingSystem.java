package MushroomTask;
import java.util.Scanner;

public class HelpingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of transactions, not more than 5000: ");
        int n = scanner.nextInt();

        Company company = new Company();
        for (int i = 1; i <= Math.min(n, 5000); i++) {
            System.out.println("A deal " + i + ":");
            System.out.print("Enter the date and time of the transaction (YYYYMMDDHHmm): ");
            String dateTime = scanner.next();
            System.out.print("Enter mushroom type code (1-6): ");
            int mushroomType = scanner.nextInt();
            System.out.print("Enter the amount (in grams): ");
            int quantity = scanner.nextInt();
            System.out.print("Enter the mushroom quality (1-3): ");
            int quality = scanner.nextInt();
            System.out.print("Enter a name for the mushroom picker: ");
            scanner.nextLine(); 
            String picker = scanner.nextLine();

            Deal deal = new Deal(dateTime, mushroomType, quantity, quality, picker);
            company.addDeal(deal);
        }

        System.out.println("\nList of all transactions entered:");
        company.printDeals();

        System.out.println("\nSorted list of all entered trades::");
        company.printSortedDeals();

        System.out.println("\nList of the total amount of purchased mushrooms by species:");
        company.printTotalQuantity();
    }
}