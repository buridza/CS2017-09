package by.it.sc02_morning.patsko.lesson12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/*
Первая строка содержит число 1<=n<=10000, вторая - n натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.

При сортировке реализуйте метод с вычислительной сложностью не более, чем O(n)
*/

public class B_CountSort {


    int[] countSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        int[] points=new int[n];
        //читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
            System.out.print(points[i]+" ");
        }
        System.out.println();
        //тут реализуйте логику задачи с применением сортировки подсчетом
//===================================Простой алгоритм сортировки подсчетом======================================
        int[] simpleArr=new int[10];
        //System.out.println(Arrays.toString(simpleArr));
        for (int i = 0; i < n; i++) {
            simpleArr[points[i]]++;
        }
        //System.out.println(Arrays.toString(simpleArr));
        int[] result=new int[n];
        int resultIndex=0;
        for (int i = 0; i < simpleArr.length; i++) {
            while(0<simpleArr[i]){
                result[resultIndex++]=i;    simpleArr[i]--;
            }
        }
        //System.out.println(Arrays.toString(result));
        /*
===================================Стабильная сортировка подсчетом==============================================
        int[] arr=new int[10];
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            arr[points[i]]=arr[points[i]]+1;
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < 10; i++) {
            arr[i]=arr[i]+arr[i-1];
        }
        System.out.println(Arrays.toString(arr));
        int[] result=new int[n];
        for (int i = n-1; i >= 0; i--) {
            arr[points[i]]--;
            result[arr[points[i]]]=points[i];
        }
        System.out.println(Arrays.toString(result));
================================================================================================================
        */
        points=result;
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return points;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc02_morning/patsko/lesson12/dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result=instance.countSort(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }


}
