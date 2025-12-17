package Kontroler.Kontroler;

import Model.Model.*;

public class RezygnacjaZWizyty {

    private IModel model;
    private int idRezerwacji;
    private int pacjentID;
    private String powodRezygnacji;

    public RezygnacjaZWizyty(IModel model) {
        this.model = model;
    }

    /**
     * Rozpoczęcie procesu rezygnacji
     */
    public boolean rozpocznijRezygnacje(int idRezerwacji, int pacjentID) {
        System.out.println("KONTROLER: Rozpoczęcie rezygnacji z wizyty.");

        this.idRezerwacji = idRezerwacji;
        this.pacjentID = pacjentID;

        // W prawdziwym systemie tu byłoby sprawdzenie,
        // czy rezerwacja należy do pacjenta
        return true;
    }

    /**
     * Podanie powodu rezygnacji
     */
    public void podajPowod(String powod) {
        this.powodRezygnacji = powod;
        System.out.println("KONTROLER: Podano powód rezygnacji: " + powod);
    }

    /**
     * Zatwierdzenie rezygnacji
     */
    public void zatwierdzRezygnacje() {

        if (powodRezygnacji == null || powodRezygnacji.isEmpty()) {
            System.out.println("KONTROLER: Brak powodu rezygnacji!");
            return;
        }

        // zapis powodu
        model.zapiszPowodRezygnacji(idRezerwacji, powodRezygnacji);

        // usunięcie rezerwacji
        model.usunRezerwacjeZListyPacjenta(idRezerwacji, pacjentID);

        System.out.println("KONTROLER: Rezygnacja zakończona sukcesem.");
    }
}
