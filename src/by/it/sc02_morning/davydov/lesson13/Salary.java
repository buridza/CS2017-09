package by.it.sc02_morning.davydov.lesson13;

import java.util.Arrays;

public class Salary {
    private double[] salary = new double[12];

    Salary(double[] salary) {
        this.salary = salary;
    }

    double getSum() {
        double sum = 0;

        for (int i = 0; i < salary.length; i++) {
            sum = sum + salary[i];
        }
        return sum;
    }

    double getSum(double percent) {
        double sum = 0;

        for (int i = 0; i < salary.length; i++) {
            sum = sum + salary[i];

        }

        return sum + sum * percent / 100;
    }

    double[] getSalary() {
        return salary;

    }

    double[] getSalary(double percent) {
        double[] salary2 = new double[12];

        for (int i = 0; i < salary.length; i++) {
            salary2[i] = salary[i] + salary[i] * percent / 100;

        }
        return salary2;

    }

    void setSalary(double percent) {
        for (int i = 0; i < salary.length; i++) {
            salary[i] = salary[i] + salary[i] * percent / 100;
        }

    }

    void sort() {
        Arrays.sort(salary);

    }

    @Override
    public String toString() {
        return Arrays.toString(salary);
    }
}
/*


 в методе main
 с консоли вводите заработные платы в массив чисел типа double размером в 12 элементов
 и передайте их в конструктор Salary
 выведите на консоль по очереди:

 неотсортированные зарплаты без надбавок
 сумму без надбавок.
 неотсортированные зарплаты с надбавкой в 20%
 сумму с этой надбавкой.
 отсортированные зарплаты с надбавкой в 50%
 сумму с этой надбавкой.
*/