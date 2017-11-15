package by.it.akhmelev.lesson14;

public class Car extends AbstractCar{

    Car(int speed) {
        super(speed);
    }

    @Override
    public String toString() {
        return "Автомобиль";
    }
}
