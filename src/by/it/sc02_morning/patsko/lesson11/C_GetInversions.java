package by.it.sc02_morning.patsko.lesson11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
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
//добавить в merge одну строчку

public class C_GetInversions {
    static int counter;//статический счетчик для подсчета инверсий

    private int[] merge(int[] a,int[] b){
        int[] result=new int[a.length+b.length];
        int ind_a=0,ind_b=0;
        for (int i = 0; i <result.length ; i++) {
            if(ind_a==a.length){result[i]=b[ind_b++];}
            else    if(ind_b==b.length){result[i]=a[ind_a++];}
                    else {
                        //result[i] = (a[ind_a] < b[ind_b]) ? a[ind_a++] : b[ind_b++];
                        if((a[ind_a] < b[ind_b])) result[i]=a[ind_a++];
                        else {
                            result[i] = b[ind_b++];
                            counter++;//если a[0]>b[0] инкрементируем счетчик
                        }
                    }
        }
        return result;
    }
    private int[] mergeSort(int[] mas, int left, int right){
        if(left==right) {
            int[] r=new int[1];
            r[0]=mas[left]; return r;
        }
        int mid = (left + right) >>> 1;
        return merge(mergeSort(mas,left,mid),mergeSort(mas,mid+1,right));
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
        mergeSort(a,0,a.length-1);
        result=counter;
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc02_morning/patsko/lesson11/dataC.txt");
        C_GetInversions instance = new C_GetInversions();
        //long startTime = System.currentTimeMillis();
        int result = instance.calc(stream);
        //long finishTime = System.currentTimeMillis();
        System.out.print(result);
    }
}
