package Kontroler.Kontroler;

import Model.Model.*;

public class RezygnacjaZWizyty {

    private IModel model;
    private int idTerminu;
    private int pacjentID;
    private String powodRezygnacji;

    public RezygnacjaZWizyty(IModel model) {
        this.model = model;
    }

    /**
     * rozpoczęcie procesu rezygnacji
     *
     * @param idTerminu
     * @param pacjentID
     * @return
     */
    public boolean procesRezygnacji(int idTerminu, int pacjentID) {
        this.idTerminu = idTerminu;
        this.pacjentID = pacjentID;
        return true;
    }

    /**
     * dodanie powodu rezygnacji
     *
     * @param powod
     */
    public void dodajPowod(String powod) {
        this.powodRezygnacji = powod;
    }

    /**
     * zatwierdzenie rezygnacji
     */
    public void zatwierdzRezygnacje() {
        model.zapiszPowodRezygnacji(idTerminu, powodRezygnacji);
        model.usunRezerwacjeZListyPacjenta(idTerminu, pacjentID);
    }
}
