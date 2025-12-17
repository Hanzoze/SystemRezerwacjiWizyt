@Override
public void rezygnacjaZWizyty() {

    RezygnacjaZWizyty proces = new RezygnacjaZWizyty(model);

    int idRezerwacji = 1; // testowe ID
    int pacjentID = 100;

    proces.rozpocznijRezygnacje(idRezerwacji, pacjentID);

    podaniePrzyczynyRezygnacji(proces);

    proces.zatwierdzRezygnacje();
}

@Override
public void podaniePrzyczynyRezygnacji() {
    // wersja bez parametrów – nieużywana
}

public void podaniePrzyczynyRezygnacji(RezygnacjaZWizyty proces) {
    proces.podajPowod("Nie mogę przyjść z powodów zdrowotnych");
}
