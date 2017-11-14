package by.it.sc04_evening_tue_thu.runec.lesson12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/*
Первая строка содержит число 1<=n<=10000, вторая - n натуральных чисел, не превышающих 10.
Выведите упорядоченную по неубыванию последовательность этих чисел.

При сортировке реализуйте метод с вычислительной сложностью не более, чем O(n)
*/

public class B_CountSort {

    public static int[] sort(int[] array) {
        int min, max = min = array[0];
// тупо находим максимальное и минимальное значение
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
// понеслась
        return sort(array, min, max);
    }

    static int[] sort(int[] array, int min, int max) {
// счетчик это такой массив в котором мы будем считать, как часто встречаются
// числа в сортируемом массиве.
// допустим массив равен = {0,2,1,5,1}, min = 0, max = 5
// счетчик = count[0]....count[5]
        int[] count = new int[max - min + 1];
// итак считаем...
        for (int i = 0; i < array.length; i++) {
// подсчитываем сколько раз встречается число,
// встретилось +1 к счетчику
            count[array[i] - min]++;
        }
// например. count[0]=1, count[1]=2, count[3]=0,count[4]=0,count[5]=1
        int idx = 0;
// теперь все готово
// пробегаем по всему счетчику (от 0 до 5)
// count[i] - показывает сколько раз встречается то или иное число
        for (int i = 0; i < count.length; i++) {
// count[0]=1, значит array[0]=0;
// count[1]=2, значит вставляем два раза array[1]=array[2]=1;
// count[2]=1, опять только один раз. array[3]=2;
// count[3]=0, значит ничего не вставляем и т.д.
            for (int j = 0; j < count[i]; j++) {
                array[idx++] = i + min;
            }
        }
// ну собственно и всё
        return array;
    }

    int[] countSort(InputStream stream) throws FileNotFoundException {
//подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
//!!!!!!!!!!!!!!!!!!!!!!!!! НАЧАЛО ЗАДАЧИ !!!!!!!!!!!!!!!!!!!!!!!!!
//размер массива
        int n = scanner.nextInt();
        int[] points=new int[n];

//читаем точки
        for (int i = 0; i < n; i++) {
            points[i]=scanner.nextInt();
        }
//тут реализуйте логику задачи с применением сортировки подсчетом

        sort(points);
/*
int[] sort=new int[10];
// System.out.println(Arrays.toString(sort));
for (int i = 0; i < n; i++) {
sort[points[i]]++;
}
// System.out.println(Arrays.toString(sort));

int[] index=new int[n];
int resultIndex=0;

for (int i = 0; i < sort.length; i++) {
while(0<sort[i]){
index[resultIndex++]=i; sort[i]--;
}
//System.out.println(Arrays.toString(index));
}
points=index;
*/
//!!!!!!!!!!!!!!!!!!!!!!!!! КОНЕЦ ЗАДАЧИ !!!!!!!!!!!!!!!!!!!!!!!!!
        return points;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/akhmelev/lesson12/dataB.txt");
        B_CountSort instance = new B_CountSort();
        int[] result=instance.countSort(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}