/*Для каждой строки матрицы найти наибольшее число
возрастающих (убывающих) элементов матрицы, идущих подряд. Упорядочить
строки матрицы по возрастанию (убыванию) их числа. Вывести саму матрицу.
На основе исходной матрицы построить «зубчатый» массив, где каждая строка
будет представлять собой самую длинную последовательность возрастающих
(у
бывающих) элементов матрицы, идущих подряд. Полученный «зубчатый»
массив вывести на экран
 */
import java.util.Random;
import java.util.Scanner;

public class task3 {
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

        int[] maxLens = new int[n];
        for (int i = 0; i < n; i++) {
            int maxLen = 1;
            int currentLen = 1;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > matrix[i][j - 1]) {
                    currentLen++;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                    }
                } else {
                    currentLen = 1;
                }
            }
            maxLens[i] = maxLen;
        }

        int[][] jagged = new int[n][];
        for (int i = 0; i < n; i++) {
            int maxLen = 1;
            int currentLen = 1;
            int endIndex = 0;

            for (int j = 1; j < n; j++) {
                if (matrix[i][j] > matrix[i][j - 1]) {
                    currentLen++;
                    if (currentLen > maxLen) {
                        maxLen = currentLen;
                        endIndex = j;
                    }
                } else {
                    currentLen = 1;
                }
            }

            int startIndex = endIndex - maxLen + 1;
            jagged[i] = new int[maxLen];
            for (int k = 0; k < maxLen; k++) {
                jagged[i][k] = matrix[i][startIndex + k];
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (maxLens[j] > maxLens[j + 1]) {
                    int tempLen = maxLens[j];
                    maxLens[j] = maxLens[j + 1];
                    maxLens[j + 1] = tempLen;

                    int[] tempRow = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = tempRow;
                }
            }
        }

        System.out.println("\nУпорядоченная матрица:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("\nЗубчатый массив:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < jagged[i].length; j++) {
                System.out.print(jagged[i][j] + " ");
            }
            System.out.println();
        }
    }
}

