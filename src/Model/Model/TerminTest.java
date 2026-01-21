package Model.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TerminTest {

    @Test
    void testSetteryIGettery() {
        Termin termin = new Termin();

        termin.setIdTerminu(5);
        termin.setData("2026-01-21 09:00");
        termin.setLekarz("Dr Danylchenko");
        termin.setGabinet(202);
        termin.setStatus("WOLNY");
        termin.setSpecjalizacja("Kardiologia");
        termin.setWymaganeSkierowanie(true);

        assertEquals(5, termin.getIdTerminu());
        assertEquals("2026-01-21 09:00", termin.getData());
        assertEquals("Dr Danylchenko", termin.getLekarz());
        assertEquals(202, termin.getGabinet());
        assertEquals("WOLNY", termin.getStatus());
        assertEquals("Kardiologia", termin.getSpecjalizacja());
        assertTrue(termin.getWymaganeSkierowanie());
    }

    @Test
    void zmianaStatusuTerminu() {
        Termin termin = new Termin();
        termin.setStatus("WOLNY");

        termin.setStatus("ZAJĘTY");

        assertEquals("ZAJĘTY", termin.getStatus(), "Status terminu powinien się zmienić");
    }

    @Test
    void testWymaganeSkierowanie() {
        Termin termin = new Termin();
        termin.setWymaganeSkierowanie(false);

        assertFalse(termin.getWymaganeSkierowanie());

        termin.setWymaganeSkierowanie(true);

        assertTrue(termin.getWymaganeSkierowanie());
    }
}
