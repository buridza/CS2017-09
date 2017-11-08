package by.it.sc02_morning.patsko.lesson12;

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
    private class Segment  implements Comparable<Segment>{           //implements Comparable{    ???
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
        }

        @Override
        public int compareTo(Segment o) {                           //compareTo(Object o)???
            //подумайте, что должен возвращать компаратор отрезков
            //и нужен ли он вообще.
            return this.stop-o.stop;
        }

        @Override
        public String toString() {return "("+start +":" + stop +')';}
    }
    private int partition(int[] a, int left, int right) {           //сортировка по убыванию
        int x=a[left],j=left, centre=left;
        for (int i = left+1; i <=right ; i++) {
            if(a[i]>x){                                             //если элемент больше опорного
                j++;
                swap(a,i,j);
            }
            if(a[i]==x){                                            //если элемент равен опорному
                centre++;
                swap(a,i,centre);
                j++;
                if(a[i]>x) swap(a,i,j);
            }
        }
        int resultIndex=j;
        while(centre!=left-1&&j!=left) {                           //перестановка опорного элемента и равных ему
            swap(a, j--, centre--);                                //в середину отрезка
        }
        return resultIndex;
    }
    private int partition(Segment[] a, int left, int right) {       //сортировка по возростанию
        int j=left, centre=left;
        for (int i = left+1; i <=right ; i++) {
            if(a[i].compareTo(a[left])<0){                         //если элемент меньше опорного
                j++;
                swap(a,i,j);
            }
            if(a[i].compareTo(a[left])==0){                         //если элемент равен опорному
                centre++;
                swap(a,i,centre);
                j++;
                if(a[i].compareTo(a[left])>0) swap(a,i,j);
            }
        }
        int resultIndex=j;
        while(centre!=left-1&&j!=left) {                            //перестановка опорного элемента и равных ему
            swap(a, j--, centre--);                                 //в середину отрезка
        }
        return resultIndex;
    }
    void qsort(int[] a, int left, int right){
        int centre;
        while(left<right) {
            int m = partition(a, left, right);
            centre=m;
            while(m>0&&centre>0&&a[m]==a[centre]) {centre--;}
            qsort(a, left, centre);                        //centre-индекс последнего элемента, который меньше опорного
            //qsort(a, m + 1, right);
            left=m+1;                                                //элиминация хвостовой рекурсии
        }
    }
    void qsort(Segment[] a, int left, int right){
        int centre;
        while(left<right) {
            int m = partition(a, left, right);
            centre=m;
            while(m>0&&centre>0&&a[m]==a[centre]) {centre--;}
            qsort(a, left, centre);
            //qsort(a, m + 1, right);
            left=m+1;                                                //элиминация хвостовой рекурсии
        }
    }
    void qsort(int[] a){
        qsort(a,0, a.length-1);
    }
    void qsort(Segment[] a){
        qsort(a,0, a.length-1);
    }
    private void swap(int[] arr, int a, int b){                    //обмен элементов массива int
        int tmp=arr[a];  arr[a]=arr[b];    arr[b]=tmp;
    }
    private void swap(Segment[] arr, int a, int b){            //обмен элементов массива Segment
        Segment tmp=arr[a];  arr[a]=arr[b];    arr[b]=tmp;
    }
    public int binarySearchSegment(int point, Segment[] segments){  //бинарный поиск подходящих отрезков
        int left=0, right=segments.length-1, mid;
        if(point>segments[segments.length-1].stop) return 0;
        while(left<=right){
            mid=(left+right)>>>1;
            if(mid==right) return mid;
            if(point>=segments[mid].start&&point<segments[mid+1].start) return mid;
            else    if(point>segments[mid].stop)  left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
    public int searchNumberOfCamera(int point, Segment[] segments){ //поиск количества отрезков, которые содержат точку
        int numOfCamera=0, lastIndexSegment;
        lastIndexSegment=binarySearchSegment(point, segments);
        if(lastIndexSegment==0) return 0;
        for (int i = 0; i <= lastIndexSegment; i++) {
            if(point>=segments[i].start&&point<=segments[i].stop){numOfCamera++;}
        }
        return numOfCamera;
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

//======================================================================================================================
        System.out.println();

        //long start, end;
        //start=System.nanoTime();   // получить начальное время
        qsort(points);                                               //сортировка точек(!по убыванию!)
        //end=System.nanoTime();    // получить конечное время
        //System.out.println("points sort="+ Arrays.toString(points));
        qsort(segments);                                             //сортировка сегментов по переменной stop(!по возрастанию!)
        //System.out.println("segments sort="+ Arrays.toString(segments));
        for (int i = 0; i <result.length ; i++) {
            result[i]=searchNumberOfCamera(points[i],segments);
        }
        //System.out.println("Time of running: "+(end-start)+" nanosec");
//======================================================================================================================
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/sc02_morning/patsko/lesson12/dataC.txt");
        C_QSortOptimized instance = new C_QSortOptimized();
        int[] result=instance.getAccessory2(stream);
        System.out.println("result="+ Arrays.toString(result));
    }


}
