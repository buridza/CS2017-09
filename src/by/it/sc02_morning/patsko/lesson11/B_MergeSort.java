package by.it.sc02_morning.patsko.lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Реализуйте сортировку слиянием для одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо отсортировать полученный массив.

Sample Input:
5
2 3 9 2 9
Sample Output:
2 2 3 9 9
*/
public class B_MergeSort {

    private int[] merge(int[] a, int[] b){
        int [] result=new int[a.length+b.length];
        int ind_a=0, ind_b=0;
        for (int i = 0; i <result.length ; i++) {//булева алгебра, повторение веток ifа
            if(ind_a==a.length||a[ind_a]>b[ind_b]) result[i]=b[ind_b++];
            else result[i]=a[ind_a++];
//            if(ind_a==a.length){result[i]=b[ind_b++];}
//            else    if(ind_b==b.length){result[i]=a[ind_a++];}
//                    else result[i]=(a[ind_a]<b[ind_b])?a[ind_a++]:b[ind_b++];
        }


        return result;
    }
    private int[] mergeSort(int[] mas, int left, int right){
        if(left==right){
            int[] one=new int[1];
            one[0]=mas[left];
            return one;
        }
        int mid=(left+right)>>>1; //разделить пополам
        int[] a=mergeSort(mas, left,mid);
        int[] b=mergeSort(mas, mid+1, right);
        int[] result=merge(a,b);

        return result;
    }

    int[] getMergeSort(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        //сам массив
        int[] a=new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scanner.nextInt();
        System.out.println("Прочитан массив a="+ Arrays.toString(a));
        // тут реализуйте сортировку слиянием
        // https://ru.wikipedia.org/wiki/Сортировка_слиянием
        //!!!!!!!!!!!!!!!!!!!!!!!!     тут ваше решение   !!!!!!!!!!!!!!!!!!!!!!!!

        a=mergeSort(a,0, a.length-1);


        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return a;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc02_morning/patsko/lesson11/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        System.out.println("Отсортированный массив "+ Arrays.toString(result));
        //long finishTime = System.currentTimeMillis();
    }


}
