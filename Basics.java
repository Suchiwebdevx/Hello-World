package Com.main;

import java.util.Scanner;

public class Basics {
	public static void main(String args[]) {
		
		// 1. Variables and Data types
		String name = "Suchi";
        int age = 19;
        double marks = 85.5;
        boolean isIntern = true;
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);
        System.out.println("Intern: " + isIntern);

        // 2. Operators and User input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.println("Sum = " + (a + b));
        System.out.println("Difference = " + (a - b));
        System.out.println("Product = " + (a * b));

        // 3. if / else
        if (a > b) {
            System.out.println(a + " is greater");
        } else if (b > a) {
            System.out.println(b + " is greater");
        } else {
            System.out.println("Both are equal");
        }

        sc.close();
	}

}
