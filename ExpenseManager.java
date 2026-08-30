import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseManager {

    private static final String FILE_NAME = "expenses.txt";


    // ================= SAVE EXPENSES =================

    public static void saveExpenses(ArrayList<Expense> expenses) {

        try {

            FileWriter writer = new FileWriter(FILE_NAME);

            for (Expense exp : expenses) {

                writer.write(
                        exp.getId() + "," +
                        exp.getTitle() + "," +
                        exp.getCategory() + "," +
                        exp.getAmount() + "," +
                        exp.getDate() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving expenses.");
        }
    }


    // ================= LOAD EXPENSES =================

    public static ArrayList<Expense> loadExpenses() {

        ArrayList<Expense> expenses = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            return expenses;
        }

        try {

            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                String[] data = line.split(",");

                if (data.length == 5) {

                    int id = Integer.parseInt(data[0]);

                    String title = data[1];

                    String category = data[2];

                    double amount =
                            Double.parseDouble(data[3]);

                    String date = data[4];

                    Expense expense = new Expense(
                            id,
                            title,
                            category,
                            amount,
                            date
                    );

                    expenses.add(expense);
                }
            }

            scanner.close();

        } catch (Exception e) {

            System.out.println("Error loading expenses.");
        }

        return expenses;
    }
}

