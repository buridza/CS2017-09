package by.it.sc04_evening_tue_thu.bukhtik.lesson06;
/*
Рисуем долларовый прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник высотой m и шириной n из знаков $.

Пример: m=2, n=4
$$$$
$$$$

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить прямоугольник размером m на n из знаков $.
4. В программе должен использоваться цикл for.

 */

import java.util.Scanner;

public class TaskA2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
       /* String s = "";     для 2-го варианта решения  */

        System.out.println("m=" + m + "," + "n=" + n);

       /* for (int i = 0; i < n; i++) {
            s = s + "$";
        }

        for (int j = 0; j < m; j++) {

            System.out.println(s);

        }
                    для 2-го варианта решения     */

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print('$');
            }
            System.out.println();

        }
    }
}



