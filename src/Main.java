import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Load saved expenses
        ArrayList<Expense> expenses = ExpenseManager.loadExpenses();

        while (true) {

            System.out.println("\n================================");
            System.out.println("       STUDENT EXPENSE TRACKER");
            System.out.println("================================");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Search Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Delete Expense");
            System.out.println("6. Monthly Summary");
            System.out.println("7. Category Summary");
            System.out.println("8. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            String input = sc.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number (1-8).");
                continue;
            }

            switch (choice) {

                // =========================
                // 1. ADD EXPENSE
                // =========================
                case 1:
                    System.out.println("\n========== ADD EXPENSE ==========");

                    System.out.print("Enter expense ID: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter amount: ₹");
                    double amount = Double.parseDouble(sc.nextLine());

                    System.out.print("Enter date (DD-MM-YYYY): ");
                    String date = sc.nextLine();

                    Expense expense = new Expense(id, title, category, amount, date);
                    expenses.add(expense);

                    ExpenseManager.saveExpenses(expenses);
                    System.out.println("Expense added successfully!");
                    break;

                // =========================
                // 2. VIEW EXPENSES
                // =========================
                case 2:
                    System.out.println("\n========== ALL EXPENSES ==========");

                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        for (Expense exp : expenses) {
                            exp.displayExpense();
                            System.out.println("--------------------------------");
                        }
                    }
                    break;

                // =========================
                // 3. SEARCH EXPENSE
                // =========================
                case 3:
                    System.out.println("\n========== SEARCH EXPENSE ==========");

                    System.out.print("Enter expense ID: ");
                    int searchId = Integer.parseInt(sc.nextLine());

                    boolean found = false;
                    for (Expense exp : expenses) {
                        if (exp.getId() == searchId) {
                            System.out.println("\nExpense Found:");
                            exp.displayExpense();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Expense not found.");
                    }
                    break;

                // =========================
                // 4. UPDATE EXPENSE
                // =========================
                case 4:
                    System.out.println("\n========== UPDATE EXPENSE ==========");

                    System.out.print("Enter expense ID to update: ");
                    int updateId = Integer.parseInt(sc.nextLine());

                    boolean updated = false;

                    for (Expense exp : expenses) {
                        if (exp.getId() == updateId) {
                            System.out.println("\nCurrent Expense:");
                            exp.displayExpense();

                            System.out.print("\nEnter new title: ");
                            String newTitle = sc.nextLine();

                            System.out.print("Enter new category: ");
                            String newCategory = sc.nextLine();

                            System.out.print("Enter new amount: ₹");
                            double newAmount = Double.parseDouble(sc.nextLine());

                            System.out.print("Enter new date (DD-MM-YYYY): ");
                            String newDate = sc.nextLine();

                            exp.setTitle(newTitle);
                            exp.setCategory(newCategory);
                            exp.setAmount(newAmount);
                            exp.setDate(newDate);

                            ExpenseManager.saveExpenses(expenses);
                            System.out.println("\nExpense updated successfully!");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Expense not found.");
                    }
                    break;

                // =========================
                // 5. DELETE EXPENSE
                // =========================
                case 5:
                    System.out.println("\n========== DELETE EXPENSE ==========");

                    System.out.print("Enter expense ID to delete: ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    boolean deleted = false;

                    for (int i = 0; i < expenses.size(); i++) {
                        if (expenses.get(i).getId() == deleteId) {
                            expenses.remove(i);
                            ExpenseManager.saveExpenses(expenses);
                            System.out.println("\nExpense deleted successfully!");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Expense not found.");
                    }
                    break;

                // =========================
                // 6. MONTHLY SUMMARY
                // =========================
                case 6:
                    System.out.println("\n========== MONTHLY SUMMARY ==========");

                    System.out.print("Enter month (MM): ");
                    String month = sc.nextLine();

                    double monthlyTotal = 0;
                    int monthlyCount = 0;

                    for (Expense exp : expenses) {
                        String expenseDate = exp.getDate();
                        if (expenseDate.length() >= 5) {
                            String expenseMonth = expenseDate.substring(3, 5);
                            if (expenseMonth.equals(month)) {
                                monthlyTotal += exp.getAmount();
                                monthlyCount++;
                            }
                        }
                    }

                    System.out.println("\nMonth: " + month);
                    System.out.println("Number of Expenses: " + monthlyCount);
                    System.out.println("Total Spending: ₹" + monthlyTotal);
                    break;

                // =========================
                // 7. CATEGORY SUMMARY
                // =========================
                case 7:
                    System.out.println("\n========== CATEGORY SUMMARY ==========");

                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        ArrayList<String> categories = new ArrayList<>();

                        for (Expense exp : expenses) {
                            String currentCategory = exp.getCategory();
                            if (!categories.contains(currentCategory)) {
                                categories.add(currentCategory);
                            }
                        }

                        for (String cat : categories) {
                            double total = 0;
                            for (Expense exp : expenses) {
                                if (exp.getCategory().equalsIgnoreCase(cat)) {
                                    total += exp.getAmount();
                                }
                            }
                            System.out.println(cat + " : ₹" + total);
                        }
                    }
                    break;

                // =========================
                // 8. EXIT
                // =========================
                case 8:
                    System.out.println("\nThank you for using Student Expense Tracker!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice! Please enter a number between 1 and 8.");
            }
        }
    }
}