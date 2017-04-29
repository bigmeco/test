import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigme on 29.04.2017.
 */
public class Realizacia implements Observerd {
    int t;
    int p;
    List<String> strings = new ArrayList<>();

    List<Observer> observers = new ArrayList<>();

    public void setStrings(String strings){
        this.strings.add(strings);
        notifyObserver();
    }

    public void setReaz(int t,int p){
        this.t = t;
        this.p = p;
        notifyObserver();
    }
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.handleEvent(t, p);
        }
    }
}
