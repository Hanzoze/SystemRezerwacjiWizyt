package Model.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DAO implements IDAO {

    private List<Termin> tabelaTerminy = new ArrayList<>();
    private List<Rezerwacja> tabelaRezerwacje = new ArrayList<>();
    private Map<Integer, String> tabelaPowody = new HashMap<>();

    public DAO() {

    }

    @Override
    public Termin pobierzTermin(int idTerminu) {
        for (Termin t : tabelaTerminy) {
            if (t.getIdTerminu() == idTerminu) {
                return t;
            }
        }
        return null;
    }

    @Override
    public Termin[] pobierzWszystkieTerminy() {
        return tabelaTerminy.toArray(new Termin[0]);
    }

    @Override
    public void dodajTermin(Termin termin) {
        tabelaTerminy.add(termin);
    }

    @Override
    public void aktualizujTermin(Termin termin) {
        for (int i = 0; i < tabelaTerminy.size(); i++) {
            if (tabelaTerminy.get(i).getIdTerminu() == termin.getIdTerminu()) {
                tabelaTerminy.set(i, termin);
                break;
            }
        }
    }

    @Override
    public void dodajRezerwacje(Rezerwacja rezerwacja) {
        int noweId = tabelaRezerwacje.size() + 1;
        rezerwacja.setIdRezerwacji(noweId);

        tabelaRezerwacje.add(rezerwacja);

        if (rezerwacja.getTermin() != null) {
            rezerwacja.getTermin().setStatus("ZAJĘTY");
        }
        System.out.println("DAO: Dodano rezerwację nr " + noweId);
    }

    @Override
    public void usunRezerwacje(int idRezerwacji, int pacjentID) {
        Rezerwacja doUsuniecia = null;

        for (Rezerwacja r : tabelaRezerwacje) {
            if (r.getIdRezerwacji() == idRezerwacji) {
                doUsuniecia = r;
                break;
            }
        }

        if (doUsuniecia != null) {
            if (doUsuniecia.getTermin() != null) {
                doUsuniecia.getTermin().setStatus("WOLNY");
            }
            tabelaRezerwacje.remove(doUsuniecia);
            System.out.println("DAO: Usunięto rezerwację nr " + idRezerwacji);
        } else {
            System.out.println("DAO: Nie znaleziono rezerwacji do usunięcia.");
        }
    }

    @Override
    public Rezerwacja[] pobierzRezerwacjePacjenta(int pacjentID) {
        return tabelaRezerwacje.toArray(new Rezerwacja[0]);
    }

    @Override
    public void zapiszPowodRezygnacji(int idRezerwacji, String powod) {
        tabelaPowody.put(idRezerwacji, powod);
        System.out.println("DAO: Zapisano powód dla rezerwacji " + idRezerwacji + ": " + powod);
    }
}