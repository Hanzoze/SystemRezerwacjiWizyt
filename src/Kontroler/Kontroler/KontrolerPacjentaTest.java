package Kontroler.Kontroler;

import Model.Model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KontrolerPacjentaTest {

    private KontrolerPacjenta kontrolerPacjenta;
    private DAO dao;
    private Model model;

    @BeforeEach
    void setUp() {
        this.dao = new DAO();

        Termin t = new Termin();
        t.setIdTerminu(1);
        t.setData("2023-12-12");
        t.setLekarz("Dr House");
        t.setStatus("WOLNY");
        t.setWymaganeSkierowanie(false);

        this.dao.dodajTermin(t);

        this.model = new Model(dao, new FabrykaDanychOsobowych());
        this.kontrolerPacjenta = new KontrolerPacjenta(model);
    }

    @Test
    void testRezerwacjaWizytyZmianaStanu() {
        assertEquals("WOLNY", dao.pobierzTermin(1).getStatus(),
                "Przed testem termin powinien być wolny");

        kontrolerPacjenta.rezerwacjaWizyty();

        Termin terminPoRezerwacji = dao.pobierzTermin(1);

        assertNotNull(terminPoRezerwacji, "Termin nie powinien zniknąć");
        assertEquals("ZAJĘTY", terminPoRezerwacji.getStatus(),
                "Po udanej rezerwacji status terminu powinien być ZAJĘTY");
    }

    @Test
    void testPodaniaDanychDoRezerwacji() {
        IDaneOsobowe dane = kontrolerPacjenta.podanieDanychDoRezerwacji(false);

        assertEquals("Jan", dane.getImie());

        assertEquals("Kowalski", dane.getNazwisko());

        assertEquals("90101055555", dane.getPesel());

        assertEquals("jan.kowalski@test.pl", dane.getEmail());

        assertEquals("500600700", dane.getNumerTelefonu());
    }
}