package by.it.sc02_morning.menchytsky.lesson12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Это тот случай когда задача A будет довольно сложной.
Если вы не решите ее за предложенное время, на ближайшем занятии
мы обсудим верное решение. Оно довольно простое, но не очевидное.

Задача. Видеорегистраторы и площадь.

На площади установлены камеры.
Известны данные о том, когда каждая из них включалась и выключалась (отрезки работы)
Известен список событий на площади (время начала каждого события).
Вам необходимо определить для каждого события сколько камер его записали.

В первой строке задано два целых числа:
    число включений камер (отрезки) 1<=n<=50000
    число событий (точки) 1<=m<=50000.

Следующие n строк содержат по два целых числа ai и bi (ai<=bi) -
координаты концов отрезков (время работы одной какой-то камеры).
Последняя строка содержит m целых чисел - координаты точек (время начала каждого события).
Все координаты не превышают 10E8 по модулю (!).

Точка считается принадлежащей отрезку, если она находится внутри него или на границе.

Для каждой точки в порядке их появления во вводе выведите,
скольким отрезкам она принадлежит.
    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

Подсказки и проверка решения:
1) самый быстрый алгоритм имеет сложность O(n log n)
2) этот код имеет внутренний класс Segment, можно добавить другие по аналогии
3) заготовку программы придется довольно изрядно доработать
*/

public class A_QSort {

    //отрезок
    private class Segment  implements Comparable<Segment>{
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
            //тут можно доделать конструктор на случай если
            //концы отрезков придут в обратном порядке
        }

        @Override
        public int compareTo(Segment otherSegment) {
            //подумайте, что должен возвращать компаратор отрезков
            //и нужен ли он вообще.
            return this.stop-otherSegment.stop;
        }

        @Override
        public String toString() {
            return "("+start +":" + stop +')';
        }
    }


    int[] getAccessory(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //число отрезков отсортированного массива
        int n = scanner.nextInt();
        Segment[] segments=new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points=new int[m];
        int[] result=new int[m];

        //читаем сами отрезки
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            segments[i]=new Segment(scanner.nextInt(),scanner.nextInt());
        }
        System.out.println("segments="+ Arrays.toString(segments));
        //читаем точки
        for (int i = 0; i < m; i++) {
            points[i]=scanner.nextInt();
        }
        System.out.println("points="+ Arrays.toString(points));
        //тут реализуйте логику задачи
        //ОБЯЗАТЕЛЬНО с применением быстрой сортировки
        QuickSort(points);//сортируем точки
        //System.out.println("points after sort ="+ Arrays.toString(points));
        QuickSort(segments);//сортируем отрезки по возростанию
        // System.out.println("segments after sort ="+ Arrays.toString(segments));

        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                if(segments[i].start<=points[j] && segments[i].stop>=points[j]){
                    result[j]++;
                }
            }
        }

        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }

    void QuickSort(int[] a, int l, int r){
        if(l>=r)
             return;
        int m = partition(a, l, r);
        QuickSort(a, l, m-1);
        QuickSort(a, m+1,r);
    }
    void QuickSort(Segment[] a, int l, int r){
         if(l>=r)
             return;
         int m = partition(a, l, r);
         QuickSort(a, l, m-1);
         QuickSort(a, m+1, r);
    }

    void QuickSort(int[] a){
         QuickSort(a, 0, a.length-1);
    }
    void QuickSort(Segment[] a){
         QuickSort(a, 0, a.length-1);
    }

    int partition(int[] a, int l, int r){
        int x = a[l];
        int j=l;
        for(int i=l+1; i<=r; i++) {
            if (a[i] <= x) {
                j=j+1;
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
            int tmp=a[j];
            a[j]=a[l];
            a[l]=tmp;
        return j;
    }
    int partition(Segment[] a, int l, int r){
        int j=l;
        Segment x=a[l];
         for(int i=l+l; i<r; i++){
             if(a[i].compareTo(x)<=0){
                 j=j+1;
                 Segment tmp = a[j];
                 a[j] = a[i];
                 a[i] = tmp;
             }
         }
        Segment tmp=a[j];
        a[j]=a[l];
        a[l]=tmp;
        return j;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc02_morning/menchytsky/lesson12/dataA.txt");
        A_QSort instance = new A_QSort();
        int[] result=instance.getAccessory(stream);
        System.out.println("result="+ Arrays.toString(result));
    }

}
