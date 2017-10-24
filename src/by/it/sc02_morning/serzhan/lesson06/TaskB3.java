package by.it.sc02_morning.serzhan.lesson06;

/*
Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N, которое должно быть больше 0
2. потом вводит N чисел с консоли типа int
3. выводит на экран максимальное, минимальное и среднее арифметическое из введенных N чисел.


Требования:
1. Программа должна считывать числа с клавиатуры.
2. Программа должна выводить строку "Minimum = " минимальное число в формате int.
3. Программа должна выводить строку "Maximum = " максимальное число в формате int.
4. Программа должна выводить строку "Average = " среднее арифметическое в формате double.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TaskB3 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = 0;
        int n = Integer.parseInt(reader.readLine());
        if (n > 0) {
            maximum = Integer.parseInt(reader.readLine());
            for (int x = 0; x < n - 2; x++) {
                int s = Integer.parseInt(reader.readLine());
                if (s > maximum) maximum = s;
            }
            if (maximum == 0) {
                maximum = 1;
            }
            System.out.println(maximum);
        }
    }
}

