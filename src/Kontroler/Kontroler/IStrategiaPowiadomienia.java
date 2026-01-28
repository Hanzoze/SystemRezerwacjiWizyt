package Kontroler.Kontroler;

import Model.Model.IDaneOsobowe;

public interface IStrategiaPowiadomienia {

    void wyslijPowiadomienie(String tresc, IDaneOsobowe dane);
}