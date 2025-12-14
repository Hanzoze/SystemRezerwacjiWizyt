package Kontroler.Kontroler;

import Model.Model.IDaneOsobowe; // Pamiętaj o imporcie!

public interface IStrategiaPowiadomienia {
    void wyslijPowiadomienie(String tresc, IDaneOsobowe dane);
}