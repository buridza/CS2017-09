package by.it.sc03_evening_mon_fri.liubimov_pavel.lesson07;

/* Массив из чисел в обратном порядке
1. Создать массив на 10 чисел.
2. Ввести с клавиатуры 10 целых чисел и записать их в массив.
3. Расположить элементы массива в обратном порядке.
4. Вывести результат на экран, каждое значение выводить с новой строки.

Например, для такого ввода
1 2 3 4 5 6 7 8 9 0

вывод ожидается такой
0
9
8
7
6
5
4
3
2
1

*/


import java.util.ArrayList;
import java.util.Scanner;

public class TaskA1 {
    public static void main(String args[]){
        ArrayList<Integer> a=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        for (int i = 0;i<3;i++) {
            a.add(in.nextInt());
           // System.out.println(a);
        }
        for (int value:a)
            System.out.println(value);
        }
    }

