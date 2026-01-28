package testyfitnes;

import fit.Fixture;

import Model.Model.DAO;
import Model.Model.Model;
import Model.Model.Termin;
import Model.Model.FabrykaDanychOsobowych;

import Kontroler.Kontroler.KontrolerPacjenta;

public class SetUp extends Fixture {

    // ===== statyczne obiekty używane w testach =====
    public static DAO dao;
    public static Model model;
    public static KontrolerPacjenta kontrolerPacjenta;

    public SetUp() {

        // ===== 1. Utworzenie DAO =====
        dao = new DAO();

        // ===== 2. Utworzenie modelu =====
        model = new Model(dao, new FabrykaDanychOsobowych());

        // ===== 3. Dane początkowe – wolny termin =====
        Termin wolnyTermin = new Termin();
        wolnyTermin.setIdTerminu(101);
        wolnyTermin.setData("2023-12-12 10:00");
        wolnyTermin.setLekarz("Dr House");
        wolnyTermin.setGabinet(1);
        wolnyTermin.setStatus("WOLNY");
        wolnyTermin.setWymaganeSkierowanie(false);
        dao.dodajTermin(wolnyTermin);

        // ===== 4. Dane początkowe – drugi wolny termin =====
        Termin wolnyTermin2 = new Termin();
        wolnyTermin2.setIdTerminu(102);
        wolnyTermin2.setData("2023-12-13 12:00");
        wolnyTermin2.setLekarz("Dr Who");
        wolnyTermin2.setGabinet(2);
        wolnyTermin2.setStatus("WOLNY");
        wolnyTermin2.setWymaganeSkierowanie(false);
        dao.dodajTermin(wolnyTermin2);

        // ===== 5. Dane początkowe – ZAJĘTY termin (do rezygnacji) =====
        Termin zajetyTermin = new Termin();
        zajetyTermin.setIdTerminu(200);
        zajetyTermin.setData("2023-12-20 14:00");
        zajetyTermin.setLekarz("Dr Strange");
        zajetyTermin.setGabinet(3);
        zajetyTermin.setStatus("ZAJĘTY");
        zajetyTermin.setWymaganeSkierowanie(false);
        dao.dodajTermin(zajetyTermin);

        // ===== 6. Utworzenie kontrolera pacjenta =====
        kontrolerPacjenta = new KontrolerPacjenta(model);
    }
}
