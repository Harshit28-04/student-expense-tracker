## Student Expense Tracker

A simple Java-based console application designed to help students manage and track their daily expenses.

## Features

* Add new expenses
* View all expenses
* Update existing expenses
* Delete expenses
* Monthly spending summary
* Category-wise spending summary
* Save expenses using file handling
* Load saved expenses when the program starts

## Technologies Used

* Java
* ArrayList
* File Handling
* Object-Oriented Programming
* Scanner

## Project Structure

```text
student-expense-tracker/
│
├── src/
│   ├── Main.java
│   ├── Expense.java
│   └── ExpenseManager.java
│
├── README.md
└── expenses.txt
```

## How to Run

### Compile

```bash
javac src/*.java
```

### Run

```bash
java -cp src Main
```

## How It Works

The application provides a menu-driven interface where users can add, view, update, delete, and analyze their expenses.

Each expense contains:

* Expense ID
* Title
* Category
* Amount
* Date

The application uses a text file to store expense data so that saved expenses can be loaded when the program starts again.

## Example

```text
================================
       STUDENT EXPENSE TRACKER
================================
1. Add Expense
3. View Expenses
4. Update Expense
5. Delete Expense
6. Monthly Summary
7. Category Summary
8. Exit
================================
```

## Future Improvements

* Graphical User Interface (GUI)
* User login system
* Budget limits and alerts
* Spending charts
* Database integration
* Improved input validation

## Author

**Harshit**

Java project created to practice Object-Oriented Programming, collections, and file handling.
