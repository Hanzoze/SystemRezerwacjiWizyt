package Model.Model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DAOTest {

    private DAO dao;

    @BeforeEach
    void setUp() {
        this.dao = new DAO();
    }

    @Order(1)
    @ParameterizedTest(name = "Dodawanie terminu ID: {0} dla lekarza: {1}")
    @CsvSource({
            "101, Dr House",
            "102, Dr Quinn",
            "103, Dr Strange"
    })
    void addingNewTerminSuccessfully(int id, String lekarz) {
        Termin t = przygotujPrzykladowyTermin(id, lekarz);

        dao.dodajTermin(t);
        Termin pobrany = dao.pobierzTermin(id);

        assertAll("Sprawdzenie poprawności dodania",
                () -> assertNotNull(pobrany, "Termin nie powinien być nullem"),
                () -> assertEquals(id, pobrany.getIdTerminu(), "ID musi się zgadzać"),
                () -> assertEquals(lekarz, pobrany.getLekarz(), "Nazwisko lekarza musi się zgadzać")
        );
    }

    @Order(2)
    @ParameterizedTest(name = "Pobieranie nieistniejącego ID: {0}")
    @ValueSource(ints = { -1, 0, 9999, 555 })
    void gettingNonExistingTermin(int idNieistniejacy) {
        dao.dodajTermin(przygotujPrzykladowyTermin(1, "Dr Istniejacy"));

        Termin wynik = dao.pobierzTermin(idNieistniejacy);

        assertNull(wynik, "Dla ID " + idNieistniejacy + " metoda powinna zwrócić null");
    }

    @Order(3)
    @Test
    void updatingTermin() {
        Termin t = przygotujPrzykladowyTermin(50, "Dr Strange");
        t.setStatus("WOLNY");
        dao.dodajTermin(t);

        t.setStatus("ZAJĘTY");
        dao.aktualizujTermin(t);

        Termin poZmianie = dao.pobierzTermin(50);
        assertEquals("ZAJĘTY", poZmianie.getStatus());
    }

    private Termin przygotujPrzykladowyTermin(int id, String lekarz) {
        Termin t = new Termin();
        t.setIdTerminu(id);
        t.setData("2023-12-01 10:00");
        t.setLekarz(lekarz);
        t.setSpecjalizacja("Ogólny");
        t.setGabinet(101);
        t.setStatus("WOLNY");
        t.setWymaganeSkierowanie(false);
        return t;
    }
}