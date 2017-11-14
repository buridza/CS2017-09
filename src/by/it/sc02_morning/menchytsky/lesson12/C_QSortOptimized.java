package by.it.sc02_morning.menchytsky.lesson12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Видеорегистраторы и площадь 2.
Условие то же что и в задаче А.

        По сравнению с задачей A доработайте алгоритм так, чтобы
        1) он оптимально использовал время и память:
            - за стек отвечает элиминация хвостовой рекурсии,
            - за сам массив отрезков - сортировка на месте
            - рекурсионные вызовы должны проводится на основе 3-разбиения

        2) при поиске подходящих отрезков для точки реализуйте метод бинарного поиска,
        помните при реализации, что поиск множественный
        (т.е. отрезков, подходящих для точки, может быть много)

    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

*/


public class C_QSortOptimized {


    //отрезок
    private class Segment  implements Comparable<Segment>{
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
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


    int[] getAccessory2(InputStream stream) throws FileNotFoundException {
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
        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор
        QuickSort(points);
        System.out.println("points="+ Arrays.toString(points));
        QuickSort(segments);


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
        if(l<r) {

            int m = partition(a, l, r);
            QuickSort(a, l, m - 1);
            l = m + 1;
            //QuickSort(a, m+1,r);
        }
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
        InputStream stream = new FileInputStream(root + "by/it/akhmelev/lesson12/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result=instance.getAccessory2(stream);
        System.out.println("result="+ Arrays.toString(result));
    }

}
