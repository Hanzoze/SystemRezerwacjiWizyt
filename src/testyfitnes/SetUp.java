package testyfitnes;

import Model.Model.Termin;
import fit.Fixture;
import Model.Model.DAO;
import Model.Model.Model;
import Model.Model.FabrykaDanychOsobowych;
import Kontroler.Kontroler.KontrolerPacjenta;

public class SetUp extends Fixture {

    public static DAO dao;
    public static Model model;
    public static KontrolerPacjenta kontrolerPacjenta;


    public SetUp() {

        dao = new DAO();

        model = new Model(dao, new FabrykaDanychOsobowych());

        przygotujDanePoczatkowe();

        kontrolerPacjenta = new KontrolerPacjenta(model);

        Termin t1 = new Termin(); t1.setIdTerminu(101); t1.setStatus("WOLNY");
        dao.dodajTermin(t1);

        Termin t2 = new Termin(); t2.setIdTerminu(102); t2.setStatus("WOLNY");
        dao.dodajTermin(t2);
    }

    private void przygotujDanePoczatkowe() {
        model.dodajNowyTermin("2023-12-12", "Dr House", 101);
    }
}