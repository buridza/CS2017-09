package by.it.akhmelev.lesson13;

//напишите три статических метода,
//один метод static double sum(double[] salary) - считает сумму всех зарплат.
//второй static double[] add(double[] salary, double percent) вычисляет новый массив с надбавкой в percent%.
//третий static void sort(double[] salary) сортирует массив salary.

// в методе main
// с консоли вводите заработные платы в массив размером в 12 элементов
// выведите на консоль по очереди:

// неотсортированные зарплаты без надбавок (используйте Arrays.toString)
// сумму без надбавок.
// неотсортированные зарплаты с надбавкой в 20% (используйте Arrays.toString)
// сумму с этой надбавкой.
// отсортированные зарплаты с надбавкой в 50% (используйте Arrays.toString)
// сумму с этой надбавкой.

import java.util.Arrays;
import java.util.Scanner;

public class TaskA1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double[] sal=new double[12];
        for (int i = 0; i < 12; i++)
            sal[i]=scanner.nextDouble();
        Salary salary=new Salary(sal);
        System.out.println(salary);
        System.out.println(salary.getSum());

        System.out.println(Arrays.toString(salary.getSalary(20)));
        System.out.println(salary.getSum(20));

        salary.sort();
        System.out.println(Arrays.toString((salary.getSalary(50))));
        System.out.println(salary.getSum(50));
    }
}
