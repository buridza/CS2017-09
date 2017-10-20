package by.it.sc03_evening_mon_fri.liubimov_pavel.lesson07;

import java.util.ArrayList;
import java.util.Scanner;

/*
Создайте список строк.
Вводите строки с клавиатуры, пока пользователь не введет слово END.
Каждую введенную строку, кроме слова END добавьте в список типа ArrayList.

Напечатайте список, не используйте для этого цикл.
Список - это объект. Его можно просто напечатать, как переменную.

Для вот такого ввода:
ONE
TWO
THREE
FOUR
FIVE
END
Ожидается такой вывод:
[ONE, TWO, THREE, FOUR, FIVE]

*/
public class TaskA2 {
    public static void main(String args[]){
        ArrayList<Integer> array=new ArrayList<>();
        Scanner in=new Scanner(System.in);
        for (int i = 0; i<10;i++){
            array.add(in.nextInt());
        }
        for (int value:array)
            System.out.print(" "+value);
            int min=Integer.MAX_VALUE;
            for (int value:array)
                if (value<min)
                    min=value;
            System.out.println("\nmin="+min);
            System.out.println(array);
    }
}
