/**
 * ArrayBasics.java
 *
 * Purpose:
 * Demonstrates the fundamental operations of a Java array.
 *
 * Topics covered:
 * 1. Creating an array
 * 2. Accessing elements
 * 3. Updating elements
 * 4. Finding array length
 * 5. Accessing first and last elements
 * 6. Traversing an array
 *
 * Complexity:
 * Access by index  -> O(1)
 * Update by index  -> O(1)
 * Traversal        -> O(n)
 * Auxiliary space  -> O(1)
 */
public class ArrayBasics {

    public static void main(String[] args) {

        // 1. Create an array
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Original array:");
        printArray(numbers);

        // 2. Array length
        System.out.println("\nArray length: " + numbers.length);

        // 3. Access elements by index
        System.out.println("\nAccessing elements:");
        System.out.println("Element at index 0: " + numbers[0]);
        System.out.println("Element at index 2: " + numbers[2]);
        System.out.println("Element at index 4: " + numbers[4]);

        // 4. First and last element
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        System.out.println("\nFirst element: " + first);
        System.out.println("Last element: " + last);

        // 5. Update an element
        System.out.println("\nUpdating index 2...");
        numbers[2] = 100;

        System.out.println("Array after update:");
        printArray(numbers);

        // 6. Traverse using a normal for loop
        System.out.println("\nTraversal using for loop:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + " -> Value " + numbers[i]);
        }

        // 7. Traverse using enhanced for loop
        System.out.println("\nTraversal using enhanced for loop:");

        for (int number : numbers) {
            System.out.println(number);
        }
    }

    /**
     * Prints every element of an integer array.
     *
     * Time Complexity: O(n)
     * Auxiliary Space: O(1)
     */
    public static void printArray(int[] numbers) {

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);

            if (i < numbers.length - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
