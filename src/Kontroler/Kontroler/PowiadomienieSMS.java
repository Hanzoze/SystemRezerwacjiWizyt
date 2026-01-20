package Kontroler.Kontroler;

import Model.Model.IDaneOsobowe;

public class PowiadomienieSMS implements IStrategiaPowiadomienia {
    public boolean czyWyslane = false;

    @Override
    public void wyslijPowiadomienie(String tresc, IDaneOsobowe dane) {
        String telefon = dane.getNumerTelefonu();
        System.out.println("[SMS] Wysyłanie pod numer " + telefon + ": " + tresc);
    }
}