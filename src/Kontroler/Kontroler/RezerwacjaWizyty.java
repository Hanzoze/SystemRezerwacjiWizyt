package Kontroler.Kontroler;

import Model.Model.*;

public class RezerwacjaWizyty {

    private IModel model;
    private int wybranyTerminID;
    private IDaneOsobowe danePacjenta;
    private IStrategiaPowiadomienia strategiaWyslaniaPowiadomienia;

    public RezerwacjaWizyty(IModel model) {
        this.model = model;
    }

    public void setStrategiaWyslaniaPowiadomienia(
            IStrategiaPowiadomienia strategia) {
        this.strategiaWyslaniaPowiadomienia = strategia;
    }

    /**
     * rozpoczęcie rezerwacji
     */
    public boolean rozpoczecieRezerwacji(int terminID) {
        if (model.czyTerminWolny(terminID)) {
            this.wybranyTerminID = terminID;
            return true;
        } else {
            this.wybranyTerminID = -1;
            return false;
        }
    }

    /**
     * pobranie danych pacjenta
     */
    public boolean pobierzDaneOsobowe(IDaneOsobowe dane) {
        if (wybranyTerminID == -1) {
            return false;
        }
        this.danePacjenta = dane;
        return przetworzDane(dane);
    }

    /**
     * przetworzenie danych
     */
    private boolean przetworzDane(IDaneOsobowe dane) {
        if (model.podajDaneOsobowe(dane)) {
            finalizacjaRezerwacji();
            return true;
        }
        return false;
    }

    /**
     * finalizacja
     */
    private void finalizacjaRezerwacji() {
        model.zapiszRezerwacje(wybranyTerminID, danePacjenta);

        if (strategiaWyslaniaPowiadomienia != null) {
            strategiaWyslaniaPowiadomienia
                    .wyslijPowiadomienie(
                            "Potwierdzenie rezerwacji",
                            danePacjenta
                    );
        }
    }
}
