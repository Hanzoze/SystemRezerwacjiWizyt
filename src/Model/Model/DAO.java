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
        stworzDaneTestowe();
    }

    private void stworzDaneTestowe() {
        Termin t1 = new Termin();
        t1.setIdTerminu(1);
        t1.setData("2023-12-01 10:00");
        t1.setLekarz("Dr House");
        t1.setSpecjalizacja("Diagnosta");
        t1.setGabinet(101);
        t1.setStatus("WOLNY");
        t1.setWymaganeSkierowanie(false);

        Termin t2 = new Termin();
        t2.setIdTerminu(2);
        t2.setData("2023-12-01 11:00");
        t2.setLekarz("Dr Quinn");
        t2.setSpecjalizacja("Internista");
        t2.setGabinet(102);
        t2.setStatus("WOLNY");
        t2.setWymaganeSkierowanie(true);

        tabelaTerminy.add(t1);
        tabelaTerminy.add(t2);
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