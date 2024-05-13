import java.util.ArrayList;
import java.util.Scanner;

class FinanceEntry {
    private double amount;
    private String category;
    private boolean isExpense;

    public FinanceEntry(double amount, String category, boolean isExpense) {
        this.amount = amount;
        this.category = category;
        this.isExpense = isExpense;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public boolean isExpense() {
        return isExpense;
    }
}

class FinanceManager {
    private ArrayList<FinanceEntry> entries;

    public FinanceManager() {
        entries = new ArrayList<>();
    }

    public void addEntry(double amount, String category, boolean isExpense) {
        entries.add(new FinanceEntry(amount, category, isExpense));
    }

    public void printSummary() {
        double totalExpenses = 0.0;
        double totalIncome = 0.0;

        for (FinanceEntry entry : entries) {
            if (entry.isExpense()) {
                totalExpenses += entry.getAmount();
            } else {
                totalIncome += entry.getAmount();
            }
        }

        double netSavings = totalIncome - totalExpenses;
        System.out.println("Financial Summary:");
        System.out.println("Total Income: $" + String.format("%.2f", totalIncome));
        System.out.println("Total Expenses: $" + String.format("%.2f", totalExpenses));
        System.out.println("Net Savings: $" + String.format("%.2f", netSavings));
    }
}

public class Main {
    public static void main(String[] args) {
        FinanceManager manager = new FinanceManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 'add' to add a new entry, 'summary' to display the summary, or 'exit' to quit:");
            String command = scanner.next();

            if (command.equalsIgnoreCase("exit")) {
                break;
            } else if (command.equalsIgnoreCase("add")) {
                System.out.print("Enter the amount: ");
                double amount = scanner.nextDouble();
                System.out.print("Enter the category: ");
                String category = scanner.next();
                System.out.print("Is this an expense? (true/false): ");
                boolean isExpense = scanner.nextBoolean();

                manager.addEntry(amount, category, isExpense);
                System.out.println("Entry added successfully!");
            } else if (command.equalsIgnoreCase("summary")) {
                manager.printSummary();
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }

        scanner.close();
    }
}
