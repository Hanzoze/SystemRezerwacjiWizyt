package Kontroler.Kontroler;

import Model.Model.DAO;
import Model.Model.Model;
import Model.Model.Termin;
import Model.Model.FabrykaDanychOsobowych;
import Model.Model.DaneOsobowe;
import Model.Model.IDaneOsobowe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RezygnacjaWizytyTest {

    private DAO dao;
    private Model model;
    private RezygnacjaZWizyty rezygnacja;

    @BeforeEach
    void setUp() {
        dao = new DAO();
        model = new Model(dao, new FabrykaDanychOsobowych());

        Termin termin = new Termin();
        termin.setIdTerminu(10);
        termin.setData("2023-12-20 14:00");
        termin.setLekarz("Dr Who");
        termin.setStatus("ZAJĘTY");
        termin.setWymaganeSkierowanie(false);

        dao.dodajTermin(termin);

        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie("Jan");
        dane.setNazwisko("Kowalski");

        model.zapiszRezerwacje(10, dane);

        rezygnacja = new RezygnacjaZWizyty(model);
    }

    @Test
    void poprawnaRezygnacjaWizyty() {
        rezygnacja.procesRezygnacji(10, 1);
        rezygnacja.dodajPowod("Nie mogę przyjść");
        rezygnacja.zatwierdzRezygnacje();

        Termin t = dao.pobierzTermin(10);
        assertEquals("WOLNY", t.getStatus());
    }
}
