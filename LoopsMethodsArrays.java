package Com.main;

public class LoopsMethodsArrays {
	
	 // 5. Methods
    static int square(int n) {
        return n * n;
    }

    static void greet(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {

        // 4. Loops
        System.out.println("For loop (1 to 5):");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        System.out.println("While loop (countdown):");
        int count = 3;
        while (count > 0) {
            System.out.println(count);
            count--;
        }

        // 5. Calling methods
        greet("Suchi");
        System.out.println("Square of 6 = " + square(6));

        // 6. Arrays
        int[] marks = {70, 85, 90, 65, 80};
        int total = 0;
        for (int i = 0; i < marks.length; i++) {
            total = total + marks[i];
        }
        System.out.println("Total = " + total);
        System.out.println("Average = " + (total / marks.length));

}
	}
