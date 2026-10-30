# Expense Tracker

A simple web app to record daily expenses and see how much was spent in total and by category. Built as the Practical Implementation Project of my YuvaIntern Full Stack Developer internship.

## Features
- Add an expense with a title, amount, category and date
- View all expenses in a table
- Delete an expense
- See the total spent and the total for each category
- Data is saved in the browser (localStorage), so it stays after refreshing
- Input validation: the title cannot be empty and the amount must be greater than 0

## Technologies Used
- HTML for the page structure
- CSS for styling
- JavaScript for the logic
- localStorage for saving data

## Project Structure
| File | Purpose |
|------|---------|
| Expense.html | Page structure: form, totals and table |
| style.css | Layout, colors and styling |
| script.js | Add and delete logic, validation, totals and saving |

## How to Run
1. Download or clone this repository.
2. Open the week3-expense-tracker folder.
3. Double-click Expense.html to open it in a browser (Chrome or Edge).

## How It Works
1. The form collects the expense details.
2. addExpense() validates the input and adds the expense to an array.
3. saveData() stores the array in localStorage.
4. render() redraws the table and the totals from the array.
5. deleteExpense() removes an item by its id and refreshes the page data.

## Testing
Tested with an empty title, a zero amount, a negative amount, multiple expenses in different categories, deleting an expense, and refreshing the page.

## Author
