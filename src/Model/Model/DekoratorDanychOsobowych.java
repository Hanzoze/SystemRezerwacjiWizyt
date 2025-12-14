package Model.Model;

public class DekoratorDanychOsobowych implements IDaneOsobowe {

	protected IDaneOsobowe komponent;

    public DekoratorDanychOsobowych(IDaneOsobowe komponent) {
        this.komponent = komponent;
    }

    @Override
    public String getImie() {
        return "";
    }

    @Override
    public boolean setImie(String imie) {
        return false;
    }

    @Override
    public String getNazwisko() {
        return "";
    }

    @Override
    public boolean setNazwisko(String nazwisko) {
        return false;
    }

    @Override
    public String getPesel() {
        return "";
    }

    @Override
    public boolean setPesel(String pesel) {
        return false;
    }

    @Override
    public String getNumerIdentyfikacyjny() {
        return "";
    }

    @Override
    public boolean setNumerIdentyfikacyjny(String numerIdentyfikacyjny) {
        return false;
    }

    @Override
    public String getNumerTelefonu() {
        return "";
    }

    @Override
    public boolean setNumerTelefonu(String numerTelefonu) {
        return false;
    }

    @Override
    public String getEmail() {
        return "";
    }

    @Override
    public boolean setEmail(String email) {
        return false;
    }

    @Override
    public String getSkierowanie() {
        return "";
    }

    @Override
    public boolean setSkierowanie(String skierowanie) {
        return false;
    }
}