package by.it.sc03_evening_mon_fri.tutina.lesson06;
/*
Треугольник из $
Прочитать переменную size с клавиатуры

Используя цикл for вывести на экран
прямоугольный треугольник из букв алфавита (ENGLISH), начиная с буквы A со сторонами size * size.

Пример
Ввод: 10
Вывод:
A
AB
ABC
ABCD
ABCDE
ABCDEF
ABCDEFG
ABCDEFGH
ABCDEFGHI
ABCDEFGHIJ
*/

import java.util.Scanner;
public class TaskA3 {
    public static void main(String[] args) {
        for (int i = 1, num = 65, size = new Scanner(System.in).nextInt(); i < size+1; i++,num=65) {
            for (int j = 0; j < i; j++) {
                System.out.print((char)num++);
            }
            System.out.println();

        }
    }

}
