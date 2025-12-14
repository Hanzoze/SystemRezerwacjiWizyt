package Model.Model;

public class Termin {

    private int idTerminu;
    private String data;
    private String lekarz;
    private int gabinet;
    private String status;
    private String specjalizacja;
    private boolean wymaganeSkierowanie;

    public int getIdTerminu() {
        return this.idTerminu;
    }

    public void setIdTerminu(int idTerminu) {
        this.idTerminu = idTerminu;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLekarz() {
        return this.lekarz;
    }

    public void setLekarz(String lekarz) {
        this.lekarz = lekarz;
    }

    // POPRAWKA: Zmieniono void na int i dodano return
    public int getGabinet() {
        return this.gabinet;
    }

    public void setGabinet(int gabinet) {
        this.gabinet = gabinet;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecjalizacja() {
        return this.specjalizacja;
    }

    public void setSpecjalizacja(String specjalizacja) {
        this.specjalizacja = specjalizacja;
    }

    public boolean getWymaganeSkierowanie() {
        return this.wymaganeSkierowanie;
    }

    public void setWymaganeSkierowanie(boolean wymaganeSkierowanie) {
        this.wymaganeSkierowanie = wymaganeSkierowanie;
    }
}