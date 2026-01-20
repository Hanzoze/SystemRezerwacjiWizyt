package Model.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnonimizatorDanychTest {

    @Test
    void testAnonimizacjiPesel() {
        IDaneOsobowe dane = new DaneOsobowe();
        dane.setImie("Anna");
        dane.setNazwisko("Nowak");
        dane.setPesel("89012345678");
        dane.setNumerTelefonu("600700800");

        AnonimizatorDanych anonimizator = new AnonimizatorDanych(dane);
        assertEquals("***********5678", anonimizator.getPesel(), "PESEL powinien być zanonimizowany");
    }

}