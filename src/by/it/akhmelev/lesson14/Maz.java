package by.it.akhmelev.lesson14;

class Maz extends Car {

    Maz(int speed) {
        super(speed>80?80:speed);
    }

    @Override
    void beep() {
        System.out.println(this+" сигналит: У-у-у-у!");
    }

    @Override
    public String toString() {
        return "Maz";
    }
}
