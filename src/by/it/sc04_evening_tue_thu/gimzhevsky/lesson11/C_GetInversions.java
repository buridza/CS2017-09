package by.it.sc04_evening_tue_thu.gimzhevsky.lesson11;

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
    public static int inv = 0; //Счетчик инверсий
    private int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int ai = 0;
        int bi = 0;
        for (int i = 0; i < result.length; i++) {

            if (ai == a.length)
                result[i] = b[bi++];
            else if (bi == b.length)
                result[i] = a[ai++];
            else if (a[ai] <= b[bi])
                result[i] = a[ai++];
            else {
                result[i] = b[bi++];
                inv = inv + a.length - ai;
            }
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
        a = mergeSort(a,0,a.length-1);
        System.out.println("Отсортированный массив "+ Arrays.toString(a));
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return inv;
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
