package Model.Model;

public class FabrykaDanychOsobowych implements IFabrykaDanychOsobowych {

    public FabrykaDanychOsobowych() {
    }

    @Override
    public IDaneOsobowe utworzDaneOsobowe() {
        return new DaneOsobowe();
    }
}