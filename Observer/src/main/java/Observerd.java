/**
 * Created by bigme on 29.04.2017.
 */
public interface Observerd {
    void addObserver (Observer observer);
    void removeObserver (Observer observer);
    void notifyObserver ();
}
