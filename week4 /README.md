
# Week 4: Testing and Quality Assurance

*Intern:* Suchi Upadhyay
*Internship:* YuvaIntern Full Stack Developer

This folder contains the JUnit unit tests written in the Testing and Quality Assurance phase.

## Contents
| File | Purpose |
|------|---------|
| BankAccount.java | Class under test. Deposit and withdraw return true or false so they can be tested |
| BankAccountTest.java | 8 JUnit 5 tests for BankAccount |

## What the Tests Cover
| Test | Checks |
|------|--------|
| depositIncreasesBalance | A valid deposit raises the balance |
| depositZeroIsRejected | A deposit of 0 is refused |
| depositNegativeIsRejected | A negative deposit is refused |
| withdrawReducesBalance | A valid withdrawal lowers the balance |
| withdrawMoreThanBalanceIsRejected | Withdrawing more than the balance is refused |
| withdrawExactBalanceWorks | Withdrawing the exact balance leaves 0 |
| withdrawNegativeIsRejected | A negative withdrawal is refused |
| negativeOpeningBalanceThrowsException | A negative opening balance throws an exception |

## Results
All 8 tests pass (Runs: 8/8, Errors: 0, Failures: 0).

To check that the tests catch real bugs, I temporarily changed amount > balance to amount >= balance in withdraw(). The test withdrawExactBalanceWorks failed, and the other 7 still passed. I then restored the correct code.

## How to Run
1. Open Eclipse and create a Java project.
2. Copy both files into the com.main package inside src.
3. Add the JUnit 5 library (Ctrl + 1 on the red error, then "Add JUnit 5 library to the build path").
4. Right-click BankAccountTest, then choose Run As, then JUnit Test.

## Expense Tracker Testing
The Expense Tracker in week3-expense-tracker was also tested with 11 manual test cases. This found and fixed two bugs:
1. The amount field rejected decimals such as 10.50, fixed with step="0.01".
2. An old error message stayed on screen, fixed by clearing it when the user edits a field.

## Tools Used
Java, JUnit 5, Eclipse IDE, web browser
