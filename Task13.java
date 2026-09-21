/*13. Для каждого числа из заданной последовательности натуральных чисел, найти
произведение цифр больших 7
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько чисел будет в последовательности? ");
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.print("\nВведите число: ");
            int number = scanner.nextInt();

            int temp = number;
            int product = 1;
            boolean found = false;


            while (temp > 0) {
                int digit = temp % 10;
                if (digit > 7) {
                    product = product * digit;
                    found = true;
                }

                temp = temp / 10;
            }
            if (found) {
                System.out.println("Произведение цифр больше 7 для числа " + number + " равно: " + product);
            } else {
                System.out.println("В числе " + number + " нет цифр больше 7");
            }
        }
        scanner.close();
    }
}