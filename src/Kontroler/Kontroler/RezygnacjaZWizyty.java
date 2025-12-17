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
     * rozpoczęcie procesu rezygnacji
     */
    public boolean procesRezygnacji(int idRezerwacji, int pacjentID) {
        this.idRezerwacji = idRezerwacji;
        this.pacjentID = pacjentID;
        return true;
    }

    /**
     * dodanie powodu
     */
    public void dodajPowod(String powod) {
        this.powodRezygnacji = powod;
    }

    /**
     * zatwierdzenie rezygnacji
     */
    public void zatwierdzRezygnacje() {
        model.zapiszPowodRezygnacji(idRezerwacji, powodRezygnacji);
        model.usunRezerwacjeZListyPacjenta(idRezerwacji, pacjentID);
    }
}
