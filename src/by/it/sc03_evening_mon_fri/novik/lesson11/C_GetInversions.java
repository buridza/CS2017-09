package by.it.sc03_evening_mon_fri.novik.lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Головоломка (т.е. не обязательно).

Рассчитать число инверсий одномерного массива.
Сложность алгоритма должна быть не хуже, чем O(n log n)

Первая строка содержит число 1<=n<=10000,
вторая - массив A[1…n], содержащий натуральные числа, не превосходящие 10E9.
Необходимо посчитать число пар индексов 1<=i<j<n, для которых A[i]>A[j]A[i]>A[j].

    (Такая пара элементов называется инверсией массива.
    Количество инверсий в массиве является в некотором смысле
    его мерой неупорядоченности: например, в упорядоченном по неубыванию
    массиве инверсий нет вообще, а в массиве, упорядоченном по убыванию,
    инверсию образуют каждые (т.е. любые) два элемента.
    )

Sample Input:
5
2 3 9 2 9
Sample Output:
2

*/


public class C_GetInversions {

    private static int inverse = 0;

    int[] merge(int[] arr1, int[] arr2) {

        int sumOfLength = arr1.length + arr2.length;
        int[] result = new int[sumOfLength];
        int i = 0;
        int j = 0;
        //int inverse = 0;

        for (int k = 0; k < sumOfLength; k++) {

            if (i >= arr1.length) {

                result[k] = arr2[j];

                j++;

            } else if (j >= arr2.length) {

                result[k] = arr1[i];

                i++;

            } else if (arr1[i] < arr2[j]) {

                result[k] = arr1[i];

                i++;

            } else {

                result[k] = arr2[j];

                j++;

                inverse++;

            }

        }

        return result;
    }

    int[] mergeSort(int[] arr) {

        if (arr.length < 2) {

            return arr;

        }

        int middleIndex = (arr.length - 1) / 2;

        int[] leftArr = Arrays.copyOfRange(arr, 0, middleIndex + 1);
        int[] rightArr = Arrays.copyOfRange(arr, middleIndex, arr.length - 1);

        //System.out.println(rightArr.length);

        return merge(mergeSort(leftArr), mergeSort(rightArr));

    }

    int calc(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!
        //размер массива
        int n = scanner.nextInt();
        //сам массив
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int result = 0;
        //!!!!!!!!!!!!!!!!!!!!!!!!     тут ваше решение   !!!!!!!!!!!!!!!!!!!!!!!!

        mergeSort(a);







        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return inverse;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/akhmelev/lesson11/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
