package by.it.sc04_evening_tue_thu.olgakuchuk.lesson06;

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


import java.util.Scanner;

public class TaskB3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        int array[] = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt(); // Заполняем массив элементами, введёнными с клавиатуры
        }
      /*  System.out.print ("Inserted array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print (" " + array[i]); // Выводим на экран, полученный массив
        }
        System.out.println();  */

        int min = array[0];
        for (int i = 0; i != array.length; i++) {
            if(array[i] < min){
                min = array[i];}
        }
        int max = array[0];
        for (int i = 0; i != array.length; i++) {
            if(array[i] > max){
                max = array[i];}
        }

        double ave = 0;
        double sum=0;
        for (int a = 0; a != array.length; a++) {
            sum=sum+array[a];
            int d =array.length;
            ave = (sum/d);}



        System.out.println("Minimum = "+min);
        System.out.println("Maximum = "+max);
        System.out.println("Average = "+ave);

    }

    }


