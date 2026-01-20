package Kontroler.Kontroler;

import Model.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RezerwacjaWizytyTest {

    private RezerwacjaWizyty process;
    private Model model;
    private DAO dao;
    private SpyStrategia powiadomienie;

    class SpyStrategia implements IStrategiaPowiadomienia {
        public boolean czyWyslane = false;
        public String adresat = "";

        @Override
        public void wyslijPowiadomienie(String tresc, IDaneOsobowe dane) {
            this.czyWyslane = true;
        }
    }

    @BeforeEach
    void setUp() {
        this.dao = new DAO();

        Termin t = new Termin();
        t.setIdTerminu(1);
        t.setData("2023-01-01");
        t.setStatus("WOLNY");
        t.setLekarz("Dr House");
        t.setWymaganeSkierowanie(false);
        dao.dodajTermin(t);

        this.model = new Model(dao, new FabrykaDanychOsobowych());

        this.process = new RezerwacjaWizyty(model);
        this.powiadomienie = new SpyStrategia();
        this.process.setStrategiaWyslaniaPowiadomienia(powiadomienie);
    }

    @Test
    void pelnyProcesRezerwacjiZakonczonySukcesem() {
        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie("Jan");
        dane.setNazwisko("Testowy");
        dane.setPesel("12345678901");
        dane.setEmail("jan@test.pl");

        process.rozpoczecieRezerwacji(1);

        boolean wynik = process.pobierzDaneOsobowe(dane);

        assertTrue(wynik, "Metoda powinna zwrócić true, gdy rezerwacja się udała");

        Termin t = dao.pobierzTermin(1);
        assertEquals("ZAJĘTY", t.getStatus(), "Status terminu powinien zmienić się na ZAJĘTY");

        assertTrue(powiadomienie.czyWyslane, "Metoda wysyłania powinna zostać wywołana");
    }

    @Test
    void probaRezerwacjiZajetegoTerminu() {
        Termin t = dao.pobierzTermin(1);
        t.setStatus("ZAJĘTY");
        dao.aktualizujTermin(t);

        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie("Anna");

        process.rozpoczecieRezerwacji(1); // Próba wybrania zajętego terminu
        boolean wynik = process.pobierzDaneOsobowe(dane); // Próba finalizacji

        assertFalse(wynik, "Rezerwacja nie powinna się udać dla zajętego terminu");

        assertFalse(powiadomienie.czyWyslane, "Nie wolno wysyłać powiadomienia, gdy rezerwacja się nie udała");
    }

    @Test
    void probaRezerwacjiNieistniejacegoTerminu() {
        process.rozpoczecieRezerwacji(999); // ID, którego nie ma w bazie
        boolean wynik = process.pobierzDaneOsobowe(new DaneOsobowe());

        assertFalse(wynik, "Nie można zarezerwować nieistniejącego terminu");
    }
}