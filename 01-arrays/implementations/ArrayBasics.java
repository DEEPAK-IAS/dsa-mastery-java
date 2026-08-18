public class ArrayBasics {

    public static void main(String[] args) {

        // Creating an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Access
        System.out.println("First element: " + numbers[0]);

        // Access last element
        System.out.println(
                "Last element: " + numbers[numbers.length - 1]
        );

        // Update
        numbers[2] = 100;

        // Traverse
        System.out.println("Array elements:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}