package by.it.sc04_evening_tue_thu.olgakuchuk.lesson10;
/*
вспомогательный класс.
событие у аудитории(два поля: начало и конец)

Обратите внимание на метод compareTo
*/
class Event implements Comparable<Event>{
    private int start;
    private int stop;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    Event(int start, int stop) {
        this.start = start;
        this.stop = stop;}

    @Override
    public String toString() {
        return "(" + start + ":" + stop + ")";
    }


    @Override
    public int compareTo(Event otherEvent) {
        //сортировка по умолчанию не работает.
        //переопределите возвращаемое значение
        //используя this и otherEvent

        //подсказка, правильно написанный компаратор возвращает
        //1 если порядок следования в массиве или коллекции this и otherEvent правильный
        //0 если объекты равны
        //-1 если порядок следования в массиве  или коллекции this и otherEvent неправильный

        return this.stop-otherEvent.stop;

       /* if (this.start>otherEvent.start) return 1;
        if (this.start==otherEvent.start) return 0;
        return -1; */

       // return 0;
    }
}
