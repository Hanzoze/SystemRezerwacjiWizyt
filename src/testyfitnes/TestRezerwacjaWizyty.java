package testyfitnes;

import fit.ColumnFixture;
import Model.Model.IDaneOsobowe;
import Model.Model.DaneOsobowe;
import Kontroler.Kontroler.RezerwacjaWizyty;

public class TestRezerwacjaWizyty extends ColumnFixture {

    public int idTerminu;
    public String imie;
    public String nazwisko;
    public String pesel;
    public String email;
    public String telefon;

    public boolean rezerwujWizyte() {
        if (!SetUp.model.czyTerminWolny(idTerminu)) {
            return false;
        }

        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie(imie);
        dane.setNazwisko(nazwisko);
        dane.setPesel(pesel);
        dane.setEmail(email);
        dane.setNumerTelefonu(telefon);

        RezerwacjaWizyty proces = new RezerwacjaWizyty(SetUp.model);

        boolean czyRozpoczeto = proces.rozpoczecieRezerwacji(idTerminu);

        boolean wynikOperacji = false;
        if (czyRozpoczeto) {
            wynikOperacji = proces.pobierzDaneOsobowe(dane);
        }

        boolean czyZajetyPo = !SetUp.model.czyTerminWolny(idTerminu);

        return wynikOperacji && czyZajetyPo;
    }
}