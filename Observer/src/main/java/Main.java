/**
 * Created by bigme on 29.04.2017.
 */
public class Main {
public  static void main (String[] args){
    Realizacia realizacia = new Realizacia();

    realizacia.addObserver(new ConsolObservers());
    realizacia.setReaz(21,56);
}
}
