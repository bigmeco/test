package sample;

/**
 * Created by bigi on 16.03.2017.
 */
public class ISTORIAZ {
    private int idzakazi ;
    private int idprodovets ;
    private int idtovar ;
    private String data ;

    public ISTORIAZ(int idzakazi, int idprodovets, int idtovar, String data) {
        this.idzakazi = idzakazi;
        this.idprodovets = idprodovets;
        this.idtovar = idtovar;
        this.data = data;
    }

    public int getIdzakazi() {
        return idzakazi;
    }

    public void setIdzakazi(int idzakazi) {
        this.idzakazi = idzakazi;
    }

    public int getIdprodovets() {
        return idprodovets;
    }

    public void setIdprodovets(int idprodovets) {
        this.idprodovets = idprodovets;
    }

    public int getIdtovar() {
        return idtovar;
    }

    public void setIdtovar(int idtovar) {
        this.idtovar = idtovar;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
