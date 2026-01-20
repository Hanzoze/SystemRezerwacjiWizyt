package Model.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    private Model model;
    private DAO dao;
    private IFabrykaDanychOsobowych fabrykaDanychOsobowy;

    @BeforeEach
    void setUp(){
        this.dao = new DAO();
        this.fabrykaDanychOsobowy = new FabrykaDanychOsobowych();
        this.model = new Model(dao, fabrykaDanychOsobowy);

        Termin t1 = new Termin();
        t1.setIdTerminu(100); // ID 100
        t1.setData("2023-12-12 12:00");
        t1.setLekarz("Dr House");
        t1.setGabinet(1);
        t1.setStatus("WOLNY");
        t1.setWymaganeSkierowanie(false);

        dao.dodajTermin(t1);
    }

    @Test
    void testCzyTerminWolny() {
        assertTrue(model.czyTerminWolny(100), "Termin 100 powinien być wolny");

        assertFalse(model.czyTerminWolny(999), "Nieistniejący termin nie powinien być wolny");
    }

    @Test
    void testPodanieDanychOsobowych() {
        IDaneOsobowe daneOsobowe = new DaneOsobowe();

        assertTrue(model.podajDaneOsobowe(daneOsobowe), "Podanie danych osobowych powinno zakończyć się sukcesem");
        assertFalse(model.podajDaneOsobowe(null), "Nie podanie danych osobowych powinno zakończyć się niepowodzeniem");
    }

    @Test
    void testScenariuszaRezerwacji() {
        int idTerminu = 100;
        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie("Jan");
        dane.setNazwisko("Kowalski");
        dane.setPesel("12345678901");

        assertTrue(model.czyTerminWolny(idTerminu));

        model.zapiszRezerwacje(idTerminu, dane);

        Termin t = dao.pobierzTermin(idTerminu);
        assertEquals("ZAJĘTY", t.getStatus(), "Status terminu powinien zmienić się na ZAJĘTY");

        assertFalse(model.czyTerminWolny(idTerminu), "Termin nie powinien być już dostępny");
    }
}