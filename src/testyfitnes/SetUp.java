package testyfitnes;

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
    }

    private void przygotujDanePoczatkowe() {
        model.dodajNowyTermin("2023-12-12", "Dr House", 101);
    }
}