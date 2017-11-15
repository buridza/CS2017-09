package by.it.akhmelev.lesson14;

class AbstractCar {
    private int speed;

    AbstractCar(int speed) {
        this.speed = speed;
    }

    void start() {
        System.out.println(this + " поехал со скоростью " + speed + " км/ч");
    }

    void stop() {
        System.out.println(this + " остановился");
    }

    ;

    void beep() {
        System.out.println(this + " сигналит: Пи-бип!");
    }

    void fire(){
        System.out.println(this+" включил зажигание");
    }
}
