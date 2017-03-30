package sample;

/**
 * Created by bigi on 16.03.2017.
 */
public class tovar {
    private int id ;
    private String name ;
    private int mane ;
    private int Kolijestvo ;

    public int getKolijestvo() {
        return Kolijestvo;
    }

    public tovar(int id, String name, int mane, int kolijestvo) {
        this.id = id;
        this.name = name;
        this.mane = mane;
        Kolijestvo = kolijestvo;
    }

    public void setKolijestvo(int kolijestvo) {
        Kolijestvo = kolijestvo;

    }


    public int getId() {
        return id;

    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMane() {
        return mane;
    }

    public void setMane(int mane) {
        this.mane = mane;
    }


}
