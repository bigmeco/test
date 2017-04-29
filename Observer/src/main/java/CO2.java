import java.util.List;

/**
 * Created by bigme on 29.04.2017.
 */
public class CO2 implements Observer2 {
    String name;

    public CO2(String name){
        this.name = name;
    }

    @Override
    public void handleEvent(List<String> strings) {
        System.out.println(name +"  ev");
    }
}
