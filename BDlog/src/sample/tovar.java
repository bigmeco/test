package sample;

/**
 * Created by bigi on 16.03.2017.
 */
public class tovar {
    private int id ;
    private String name ;
    private int mane ;

    public tovar(int id, String name, int mane) {
        this.id = id;
        this.name = name;
        this.mane = mane;
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
