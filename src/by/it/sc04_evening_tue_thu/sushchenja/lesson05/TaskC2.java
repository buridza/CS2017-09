package by.it.sc04_evening_tue_thu.sushchenja.lesson05;

import java.util.Scanner;

/*
На входе вводится число и месяц 2017 года.
Программа должна выводить номер дня года, считая 1 января первым днем,
а 31 декабря 365-м.

Пример:
Ввод:
1 1

Вывод
1

Ввод:
31 12

Вывод
365

Ввод:
13 9

Вывод
256

 */
public class TaskC2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= b - 1; i++){
            sum = sum + GetDaysInMonth(i);
        }
        sum = sum + a;

        System.out.println(sum);
    }

    private static int GetDaysInMonth(int i) {
        switch (i) {
            case 1  : return 31;
            case 2  : return 28;
            case 3  : return 31;
            case 4  : return 30;
            case 5  : return 31;
            case 6  : return 30;
            case 7  : return 31;
            case 8  : return 31;
            case 9  : return 30;
            case 10 : return 31;
            case 11 : return 30;
            case 12 : return 31;
            default : return 0;
        }
    }
}
