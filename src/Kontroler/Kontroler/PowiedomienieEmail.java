package Kontroler.Kontroler;

import Model.Model.IDaneOsobowe;

public class PowiedomienieEmail implements IStrategiaPowiadomienia {

    @Override
    public void wyslijPowiadomienie(String tresc, IDaneOsobowe dane) {
        String email = dane.getEmail();
        System.out.println("[EMAIL] Wysyłanie na adres " + email + ": " + tresc);
    }
}