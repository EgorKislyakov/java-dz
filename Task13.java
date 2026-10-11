/* «Уплотнить» матрицу, удаляя из нее столбцы, заполненные четными
числами.
 */
import java.util.Random;
import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер матрицы n: ");
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Выберите ввод (1 - случайно, 2 - с клавиатуры): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(20) - 10;
                }
            }
        } else {
            System.out.println("Введите элементы матрицы:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }

        System.out.println("\nИсходная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int newColCount = 0;
        for (int j = 0; j < n; j++) {
            boolean allEven = true;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] % 2 != 0) {
                    allEven = false;
                    break;
                }
            }
            if (!allEven) {
                newColCount++;
            }
        }

        int[][] result = new int[n][newColCount];
        int currentNewCol = 0;

        for (int j = 0; j < n; j++) {
            boolean allEven = true;
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] % 2 != 0) {
                    allEven = false;
                    break;
                }
            }

            if (!allEven) {
                for (int i = 0; i < n; i++) {
                    result[i][currentNewCol] = matrix[i][j];
                }
                currentNewCol++;
            }
        }

        System.out.println("\nУплотненная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < newColCount; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


