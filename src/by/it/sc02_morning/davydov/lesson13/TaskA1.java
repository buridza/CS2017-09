package by.it.sc02_morning.davydov.lesson13;

import java.util.Arrays;
import java.util.Scanner;

/*
напишите три статических метода,
один метод static double sum(double[] salary) - считает сумму всех зарплат.
второй static double[] add(double[] salary, double percent) вычисляет новый массив с надбавкой в percent%.
третий static void sort(double[] salary) сортирует массив salary.

 в методе main
 с консоли вводите заработные платы в массив размером в 12 элементов
 выведите на консоль по очереди:

 неотсортированные зарплаты без надбавок (используйте Arrays.toString)
 сумму без надбавок.
 неотсортированные зарплаты с надбавкой в 20% (используйте Arrays.toString)
 сумму с этой надбавкой.
 отсортированные зарплаты с надбавкой в 50% (используйте Arrays.toString)
 сумму с этой надбавкой.
*/
public class TaskA1 {


    public static void main(String[] args) {
        double[] salary = new double[12];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < salary.length; i++) {
            salary[i] = sc.nextDouble();

        }


        System.out.println(Arrays.toString(salary));

        System.out.println(sum(salary));

        System.out.println(Arrays.toString(add(salary, 20)));

        System.out.println(sum(add(salary, 20)));

        sort(salary);

        System.out.println(Arrays.toString(add(salary, 50)));

        System.out.println(sum(add(salary, 50)));


    }


    static double sum(double[] salary) {
        double sum = 0;
        for (int i = 0; i < salary.length; i++) {
            sum = sum + salary[i];
        }
        return sum;
    }


    static double[] add(double[] salary, double percent) {
        double[] salary2 = new double[12];

        for (int i = 0; i < salary.length; i++) {
            salary2[i] = salary[i] + (salary[i] * percent / 100);
        }

        return salary2;
    }


    static void sort(double[] salary) {
        Arrays.sort(salary);

    }


}
