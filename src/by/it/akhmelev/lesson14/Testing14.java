package by.it.akhmelev.lesson14;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

import static org.junit.Assert.*;

@SuppressWarnings("all") //море warnings. всех прячем.

//поставьте курсор на следующую строку и нажмите Ctrl+Shift+F10
public class Testing14 {

    @Test(timeout = 1500)
    public void testTaskA1() throws Exception {
        findClass("Car");
        findClass("Maz");
        findClass("Mercedes");
        run("").
                include("Автомобиль поехал со скоростью").include(" 100 км/ч").
                include("Автомобиль сигналит: Пи-бип!").
                include("Автомобиль остановился").
                include("Maz поехал со скоростью 60 км/ч").
                include("Maz сигналит: У-у-у-у!").
                include("Maz остановился").
                include("Mercedes поехал со скоростью").include(" 150 км/ч").
                include("Mercedes сигналит: Фа-фа!").
                include("Mercedes остановился");
    }

    @Test(timeout = 1500)
    public void testTaskB1() throws Exception {
        Class<?> sup=findClass("AbstractCar");
        Class<?> car=findClass("Car");
        if (car.getSuperclass()!=sup) fail("Ошибка наследования в Car");
        if (findClass("Maz").getSuperclass()!=car) fail("Ошибка наследования в Maz");
        if (findClass("Mercedes").getSuperclass()!=car) fail("Ошибка наследования в Mercedes");
        run("").
                include("Автомобиль включил зажигание").
                include("Автомобиль поехал со скоростью").include(" 100 км/ч").
                include("Автомобиль сигналит: Пи-бип!").
                include("Автомобиль остановился").
                include("Maz включил зажигание").
                include("Maz поехал со скоростью 60 км/ч").
                include("Maz сигналит: У-у-у-у!").
                include("Maz остановился").
                include("Mercedes включил зажигание").
                include("Mercedes поехал со скоростью").include(" 150 км/ч").
                include("Mercedes сигналит: Фа-фа!").
                include("Mercedes остановился");
    }


    @Test(timeout = 1500)
    public void testTaskC1() throws Exception {
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        StackTraceElement element;
        int i = 0;
        do {
            element = trace[i++];
        }
        while (!element.getMethodName().contains("test"));

        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        String index=System.getProperty("user.dir")+"/src/"
                +clName.replace(".","/").replace("TaskC1","doc")+"/index.html";
        File file= new File(index);
        if (!file.exists())
            fail("Документация javadoc не найдена");
        Scanner sc=new Scanner(file);
        String javadoc="???";
        while (sc.hasNext()){
            String line=sc.nextLine();
            System.out.println(line);
            if (line.contains("DOCTYPE HTML PUBLIC"))
                javadoc="javadoc";
        }
        assertEquals("Неверная javadoc документация на классы","javadoc",javadoc);

    }


    /*
    ===========================================================================================================
    НИЖЕ ВСПОМОГАТЕЛЬНЫЙ КОД ТЕСТОВ. НЕ МЕНЯЙТЕ В ЭТОМ ФАЙЛЕ НИЧЕГО.
    Но изучить как он работает - можно, это всегда будет полезно.
    ===========================================================================================================
     */

    private Class findClass(String SimpleName) {
        String full = this.getClass().getName();
        String dogPath = full.replace(this.getClass().getSimpleName(), SimpleName);
        try {
            return Class.forName(dogPath);
        } catch (ClassNotFoundException e) {
            fail("\nТест не пройден. Класс " + SimpleName + " не найден.");
        }
        return null;
    }

    private Method findMethod(Class<?> cl, String name, Class... param) {
        try {
            return cl.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            fail("\nТест не пройден. Метод " + cl.getName() + "." + name + " не найден");
        }
        return null;
    }

    private Constructor<?> findConstructor(Class<?> cl, Class<?>... param) {
        try {
            return cl.getDeclaredConstructor(param);
        } catch (NoSuchMethodException e) {
            fail("\nТест не пройден. Конструктор " + cl.getName() + " не найден (с числом параметров: " + param.length + ")");
        }
        return null;
    }

    private Object invoke(Method method, Object o, Object... value) {
        try {
            return method.invoke(o, value);
        } catch (Exception e) {
            fail("\nНе удалось вызвать метод " + method.getName());
        }
        return null;
    }

    //метод находит и создает класс для тестирования
    //по имени вызывающего его метода, testTaskA1 будет работать с TaskA1
    private static Testing14 run(String in) {
        Throwable t = new Throwable();
        StackTraceElement trace[] = t.getStackTrace();
        StackTraceElement element;
        int i = 0;
        do {
            element = trace[i++];
        }
        while (!element.getMethodName().contains("test"));

        String[] path = element.getClassName().split("\\.");
        String nameTestMethod = element.getMethodName();
        String clName = nameTestMethod.replace("test", "");
        clName = element.getClassName().replace(path[path.length - 1], clName);
        System.out.println("\n---------------------------------------------");
        System.out.println("Старт теста для " + clName + "\ninput:" + in);
        System.out.println("---------------------------------------------");
        return new Testing14(clName, in);
    }

    public Testing14() {
        //Конструктор тестов
    }

    //Конструктор тестов
    //    private Testing(String className) {
    //        this(className, "");
    //    }

    //Основной конструктор тестов
    private Testing14(String className, String in) {
        //this.className = className;
        Class<?> c = null;
        try {
            c = Class.forName(className);
        } catch (ClassNotFoundException e) {
            fail("Не найден класс " + className);
        }
        reader = new StringReader(in); //заполнение ввода
        InputStream inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                return reader.read();
            }
        };
        System.setIn(inputStream);   //перехват ввода

        System.setOut(newOut); //перехват стандартного вывода
        try {
            Class[] argTypes = new Class[]{String[].class};
            Method main = c.getDeclaredMethod("main", argTypes);
            main.invoke(null, (Object) new String[]{});

        } catch (Exception x) {
            x.printStackTrace();
        }
        System.setOut(oldOut); //возврат вывода
    }

    //проверка вывода
    private Testing14 is(String str) {
        assertTrue("Ожидается такой вывод:\n<---начало---->\n" + str + "<---конец--->",
                stringWriter.toString().equals(str));
        return this;
    }

    private Testing14 include(String str) {
        assertTrue("Строка не найдена: " + str + "\n", stringWriter.toString().contains(str));
        return this;
    }

    private Testing14 exclude(String str) {
        assertTrue("Лишние данные в выводе: " + str + "\n", !stringWriter.toString().contains(str));
        return this;
    }


    //переменные теста
    private StringWriter stringWriter = new StringWriter();
    private PrintStream oldOut = System.out;
    private StringReader reader;


    //поле для перехвата потока вывода
    private PrintStream newOut;

    {
        newOut = new PrintStream(new OutputStream() {
            private byte bytes[] = new byte[2];

            @Override
            public void write(int b) throws IOException {
                if (b < 0) { //ловим и собираем двухбайтовый UTF (первый код > 127, или в байте <0)
                    if (bytes[0] == 0) { //если это первый байт
                        bytes[0] = (byte) b; //то запомним его
                    } else {
                        bytes[1] = (byte) b; //иначе это второй байт
                        String s = new String(bytes); //соберем весь символ
                        stringWriter.append(s); //запомним вывод для теста
                        oldOut.append(s); //копию в обычный вывод
                        bytes[0] = 0; //забудем все.
                    }
                } else {
                    char c = (char) b; //ловим и собираем однобайтовый UTF
                    bytes[0] = 0;
                    if (c != '\r') {
                        stringWriter.write(c); //запомним вывод для теста
                    }
                    oldOut.write(c); //копию в обычный вывод
                }
            }
        });
    }

}
