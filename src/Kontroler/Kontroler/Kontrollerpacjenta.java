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

        proces.rozpoczecieRezerwacji(1);


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

    }

    @Override
    public void podanieDanychDoRezerwacji() {

    }

    @Override
    public void podaniePrzyczynyRezygnacji() {

    }
}