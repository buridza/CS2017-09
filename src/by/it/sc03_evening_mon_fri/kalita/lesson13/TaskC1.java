package by.it.sc03_evening_mon_fri.kalita.lesson13;
/*
Свой поиск и вывод.

Повторите решение задачи B не используя класс Arrays (!!!!) и его методы.
Также добавьте в класс Salary два дополнительных консруктора которые принимают
1) массив String[]
2) произвольное количество чисел типа double (не массив)
*/

import java.util.Random;

public class TaskC1 {
   /* неотсортированные зарплаты без надбавок
    сумму без надбавок.
    неотсортированные зарплаты с надбавкой в 20%
    сумму с этой надбавкой.
    отсортированные зарплаты с надбавкой в 50%
    сумму с этой надбавкой.*/
   public static void main(String[] args) {
       Random random = new Random();
       double[] arr = new double[12];
       for (int i = 0, iter = 12; i < 12; i++) {
           arr[i] = iter--;
       }
       Salary salary = new Salary(arr);
       System.out.println(salary);
       System.out.println(salary.getSum());
       System.out.println(salary.getSalary(1.20));
       System.out.println(salary.getSum(1.20));
       salary.sort();

       System.out.println(salary.getSalary(1.50));
       System.out.println(salary.getSum(1.50));
       System.out.println();
   }


}
