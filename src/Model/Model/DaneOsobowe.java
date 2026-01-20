package Model.Model;

public class DaneOsobowe implements IDaneOsobowe {

    private String imie;
    private String nazwisko;
    private String pesel;
    private String numerIdentyfikacyjny;
    private String numerTelefonu;
    private String email;
    private String skierowanie;


    @Override
    public String getImie() {
        return this.imie;
    }

    @Override
    public boolean setImie(String imie) {
        this.imie = imie;
        return true; // Operacja się udała
    }

    @Override
    public String getNazwisko() {
        return this.nazwisko;
    }

    @Override
    public boolean setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        return true;
    }

    @Override
    public String getPesel() {
        return this.pesel;
    }

    @Override
    public boolean setPesel(String pesel) {
        this.pesel = pesel;
        return true;
    }

    @Override
    public String getNumerIdentyfikacyjny() {
        return this.numerIdentyfikacyjny;
    }

    @Override
    public boolean setNumerIdentyfikacyjny(String numerIdentyfikacyjny) {
        this.numerIdentyfikacyjny = numerIdentyfikacyjny;
        return true;
    }

    @Override
    public String getNumerTelefonu() {
        return this.numerTelefonu;
    }

    @Override
    public boolean setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
        return true;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    @Override
    public String getSkierowanie() {
        return this.skierowanie;
    }

    @Override
    public boolean setSkierowanie(String skierowanie) {
        this.skierowanie = skierowanie;
        return true;
    }
}