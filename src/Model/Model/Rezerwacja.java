package Model.Model;

public class Rezerwacja {

    private Termin termin;
    private IDaneOsobowe danePacjenta;
    private int idRezerwacji;

    // Gettery i Settery
    public Termin getTermin() {
        return termin;
    }

    public void setTermin(Termin termin) {
        this.termin = termin;
    }

    public IDaneOsobowe getDanePacjenta() {
        return danePacjenta;
    }

    public void setDanePacjenta(IDaneOsobowe danePacjenta) {
        this.danePacjenta = danePacjenta;
    }

    public int getIdRezerwacji() {
        return idRezerwacji;
    }

    public void setIdRezerwacji(int idRezerwacji) {
        this.idRezerwacji = idRezerwacji;
    }
}