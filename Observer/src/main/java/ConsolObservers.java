/**
 * Created by bigme on 29.04.2017.
 */
public class ConsolObservers implements Observer {
    @Override
    public void handleEvent(int t, int p) {
        System.out.println(t+"   iii   "+p);
    }
}
