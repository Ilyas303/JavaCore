package homeworks.homework10;



public class App  {


    public static void main(String[] args) {
        int[] numbers = {12, 15, 20, 33, 40, 7, 100};


        ByCondition evenCondition = (number) -> number % 2 == 0;
        int[] evenNumbers = Sequence.filter(numbers, evenCondition);
        System.out.println("Четные числа: ");
        for (int number : evenNumbers) {
            System.out.println(number);
        }


        ByCondition sumOfDigitsEvenCondition = (number) -> {
            int sum = 0;
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
            return sum % 2 == 0;
        };

        int[] numbersWithEvenSumOfDigits = Sequence.filter(numbers, sumOfDigitsEvenCondition);
        System.out.println("Числа с четной суммой цифр: ");
        for (int number : numbersWithEvenSumOfDigits) {
            System.out.println(number);
        }
    }
}