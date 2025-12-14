package Model.Model;

import java.util.ArrayList;
import java.util.List;

public class Model implements IModel {

	private IDAO dao;
	private Termin[] spisTerminow;
	private Rezerwacja[] spisRezerwacji;
	private String[] spisPowodow;
    private IFabrykaDanychOsobowych fabrykaDanychOsobowy;

    public Model(IDAO dao, IFabrykaDanychOsobowych fabrykaDanychOsobowy) {
        this.dao = dao;
        this.fabrykaDanychOsobowy = fabrykaDanychOsobowy;
    }

	/**
	 * 
	 * @param idTerminu
	 */
	public boolean zmienTermin(int idTerminu) {
		// TODO - implement Model.zmienTermin
		throw new UnsupportedOperationException();
	}

    @Override
    public boolean czyTerminWolny(int idTerminu) {
        Termin t = dao.pobierzTermin(idTerminu);
        return t != null && "WOLNY".equals(t.getStatus());
    }

    @Override
    public String pobierzSzczegolyTerminu(int idTerminu) {
        Termin t = dao.pobierzTermin(idTerminu);
        if (t != null){
            return "Termin ID: " + t.getIdTerminu() + ", Data: " + t.getData() + ", Lekarz: " + t.getLekarz() +
                   ", Gabinet: " + t.getGabinet() + ", Status: " + t.getStatus() + ", Specjalizacja: " + t.getSpecjalizacja();
        }
        return "Nie znaleziono terminu o podanym ID.";
    }

    @Override
    public void zapiszRezerwacje(int idTerminu, IDaneOsobowe dane) {
        if (czyTerminWolny(idTerminu)) {
            Termin t = dao.pobierzTermin(idTerminu);
            Rezerwacja r = new Rezerwacja();

            r.setTermin(t);
            r.setDanePacjenta(dane);

            dao.dodajRezerwacje(r);
            System.out.println("MODEL: Zapisano rezerwację dla terminu ID: " + idTerminu);
        } else {
            System.out.println("MODEL: Nie można zarezerwować (termin zajęty lub nie istnieje).");
        }
    }

    @Override
    public void dodajNowyTermin(String data, String lekarz, int gabinet) {
        Termin t = new Termin();

        //Uproszczona generacja ID
        t.setIdTerminu((int)(Math.random() * 1000));
        t.setData(data);
        t.setLekarz(lekarz);
        t.setGabinet(gabinet);
        t.setStatus("WOLNY");
        dao.dodajTermin(t);
        System.out.println("MODEL: Dodano nowy termin ID: " + t.getIdTerminu());
    }

    @Override
    public boolean sprawdzKonfliktTerminow(String lekarz, String data) {
        Termin[] terminy = dao.pobierzWszystkieTerminy();
        for (Termin t : terminy) {
            if (t.getLekarz().equals(lekarz) && t.getData().equals(data)) {
                return true; // Konflikt
            }
        }
        return false;
    }

    @Override
    public String[] pobierzListeWolnychTerminow(String specjalizacja) {
        Termin[] terminy = dao.pobierzWszystkieTerminy();
        List<String> wolne = new ArrayList<>();

        for(Termin t : terminy){
            if("WOLNY".equals(t.getStatus())){
                if(specjalizacja == null || specjalizacja.isEmpty() || specjalizacja.equalsIgnoreCase(t.getSpecjalizacja())){
                    wolne.add(t.getIdTerminu() + ": " + t.getData() + " (" + t.getLekarz() + ")");
                }
            }
        }
        return wolne.toArray(new String[0]);
    }

    @Override
    public void usunRezerwacjeZListyPacjenta(int idRezerwacji, int pacjentID) {
        dao.usunRezerwacje(idRezerwacji, pacjentID);
        System.out.println("MODEL: Zlecono usunięcie rezerwacji " + idRezerwacji);
    }

    @Override
    public void zapiszPowodRezygnacji(int idRezerwacji, String powod) {
        dao.zapiszPowodRezygnacji(idRezerwacji, powod);
    }

    @Override
    public boolean czyWymagaSkierowanie(int idTerminu) {
        Termin t = dao.pobierzTermin(idTerminu);
        if (t != null) {
            return t.getWymaganeSkierowanie();
        }
        return false;
    }

    @Override
    public boolean podajDaneOsobowe(IDaneOsobowe dane) {
        return dane != null;
    }

    public IFabrykaDanychOsobowych getFabrykaDanychOsobowych() {
        return this.fabrykaDanychOsobowy;
    }
}