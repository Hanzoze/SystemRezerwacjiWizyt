package Kontroler.Kontroler;

import Model.Model.*;

public class KontrolerPacjenta implements IKontrolerPacjenta {

    private IModel model;

    public KontrolerPacjenta(IModel model) {
        this.model = model;
    }

    @Override
    public void przegladanieOferty() {
    }

    @Override
    public void przegladanieWolnychTerminow() {
    }

    @Override
    public void rezerwacjaWizyty() {

        RezerwacjaWizyty proces = new RezerwacjaWizyty(model);

        int wybranyTerminId = 1; // przekazywane z Widoku
        proces.rozpoczecieRezerwacji(wybranyTerminId);

        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie("Jan");
        dane.setNazwisko("Kowalski");
        dane.setPesel("90101055555");
        dane.setEmail("jan.kowalski@test.pl");
        dane.setNumerTelefonu("500600700");

        proces.pobierzDaneOsobowe(dane);
    }

    @Override
    public void rezygnacjaZWizyty() {

        RezygnacjaZWizyty proces = new RezygnacjaZWizyty(model);

        int idRezerwacji = 1; // z Widoku
        int pacjentId = 10;   // z Widoku

        proces.procesRezygnacji(idRezerwacji, pacjentId);
    }

    @Override
    public void podanieDanychDoRezerwacji() {
        // dane przekazywane z Widoku – logika w RezerwacjaWizyty
    }

    @Override
    public void podaniePrzyczynyRezygnacji() {

        RezygnacjaZWizyty proces = new RezygnacjaZWizyty(model);
        proces.dodajPowod("Nie mogę przyjść w tym terminie");
        proces.zatwierdzRezygnacje();
    }
}
