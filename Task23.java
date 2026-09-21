/*23. Найти и вывести все пятизначные числа из заданной последовательности чисел,
средняя цифра которых равна сумме крайних цифр. Подсчитать их количество.
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько чисел будет в последовательности? ");
        int count = scanner.nextInt();

        int matchedCount = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Введите число: ");
            int number = scanner.nextInt();


            if (number >= 10000 && number <= 99999) {


                int firstDigit = number / 10000;
                int middleDigit = (number / 100) % 10;
                int lastDigit = number % 10;


                if (middleDigit == (firstDigit + lastDigit)) {
                    System.out.println("Подходящее число: " + number);
                    matchedCount = matchedCount + 1;
                }
            }
        }
        System.out.println("Всего найдено подходящих чисел: " + matchedCount);
        scanner.close();
    }
}