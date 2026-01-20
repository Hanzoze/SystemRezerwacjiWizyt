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

        int wybranyTerminId = 1;
        boolean czyWolny = proces.rozpoczecieRezerwacji(wybranyTerminId);

        if (!czyWolny) {
            System.out.println("BŁĄD: Wybrany termin jest już zajęty. Nie można kontynuować.");
            return;
        }

        boolean czyTrzebaSkierowanie = model.czyWymagaSkierowanie(wybranyTerminId);

        IDaneOsobowe dane = podanieDanychDoRezerwacji(czyTrzebaSkierowanie);

        proces.pobierzDaneOsobowe(dane);
    }

    @Override
    public void rezygnacjaZWizyty() {

        RezygnacjaZWizyty proces = new RezygnacjaZWizyty(model);

        int idRezerwacji = 1;
        int pacjentId = 10;

        proces.procesRezygnacji(idRezerwacji, pacjentId);
    }

    @Override
    public IDaneOsobowe podanieDanychDoRezerwacji(boolean wymaganeSkierowanie) {

        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie("Jan");
        dane.setNazwisko("Kowalski");
        dane.setPesel("90101055555");
        dane.setEmail("jan.kowalski@test.pl");
        dane.setNumerTelefonu("500600700");

        if (wymaganeSkierowanie) {
            System.out.println("Ten termin wymaga skierowania.");

            String kod = "SKIER-2023";
            System.out.println(kod);

            dane.setSkierowanie(kod);
        } else {
            System.out.println("(Skierowanie nie jest wymagane)");
        }

        return dane;
    }

    @Override
    public void podaniePrzyczynyRezygnacji() {

        RezygnacjaZWizyty proces = new RezygnacjaZWizyty(model);
        proces.dodajPowod("Nie mogę przyjść w tym terminie");
        proces.zatwierdzRezygnacje();
    }
}
