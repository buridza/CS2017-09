package by.it.sc02_morning.golikov.lesson11;

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

    private int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        for (int i = 0; i < result.length; i++) {
            if (ai == a.length)
                result[i] = b[bi++];

            else if (bi == b.length)
                result[i] = a[ai++];

            else if (a[ai] < b[bi])
                result[i] = a[ai++];

            else
                result[i] = b[bi++];
        }

        return result;
    }

    private int[] mergeSort (int[] mass, int left, int right) {
        if (left == right) {
            int[] one = new int[1];
            one[0] = mass[left];
            return one;
        }
        int mid = (left + right) / 2;
        int[] a = mergeSort(mass, left, mid);
        int[] b = mergeSort(mass, mid+1, right);
        int[] result = merge(a, b);
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
        a = mergeSort(a,0, a.length-1);





        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return a;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc02_morning/golikov/lesson11/dataB.txt");
        B_MergeSort instance = new B_MergeSort();
        //long startTime = System.currentTimeMillis();
        int[] result=instance.getMergeSort(stream);
        System.out.println("Отсортированный массив "+ Arrays.toString(result));
        //long finishTime = System.currentTimeMillis();
    }


}
