package by.it.akhmelev.lesson14;

class Mercedes extends Car {

    Mercedes(int speed) {
        super(speed>200?200:speed);
    }

    @Override
    void beep() {
        System.out.println(this+" сигналит: Фа-фа!");
    }

    @Override
    public String toString() {
        return "Mercedes";
    }
}
