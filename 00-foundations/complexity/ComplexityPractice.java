public class ComplexityPractice {

    // Question 1
    public static void question1(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }
    }

    // Question 2
    public static void question2(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }
    }

    // Question 3
    public static void question3(int n) {

        for (int i = 1; i < n; i *= 2) {
            System.out.println(i);
        }
    }

    // Question 4
    public static void question4(int n) {

        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < n; j++) {
            System.out.println(j);
        }
    }

    // Question 5
    public static void question5(int n, int m) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                System.out.println(i + " " + j);
            }
        }
    }
}

//  answers 

// Question 1 → O(n)
// Question 2 → O(n²)
// Question 3 → O(log n)
// Question 4 → O(n)
// Question 5 → O(nm)