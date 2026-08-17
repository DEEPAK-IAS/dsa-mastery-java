public class BigOExamples {

    public static void constantTime(int[] numbers) {
        System.out.println(numbers[0]);
    }

    public static void linearTime(int[] numbers) {
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    public static void quadraticTime(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                System.out.println(numbers[i] + " " + numbers[j]);
            }
        }
    }

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        constantTime(numbers);
        linearTime(numbers);
        quadraticTime(numbers);
    }
}