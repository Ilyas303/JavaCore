package homeworks.homework10;

public class Sequence {
    public static int[] filter(int[] array, ByCondition condition) {

        int count = 0;
        for (int number : array) {
            if (condition.isOk(number)) {
                count++;
            }
        }

        if (count == 0) {
            return new int[0];
        }


        int[] result = new int[count];
        int index = 0;


        for (int number : array) {
            if (condition.isOk(number)) {
                result[index++] = number;
            }
        }

        return result;
    }
}