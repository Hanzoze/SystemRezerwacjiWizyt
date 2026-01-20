package Model.Model;

public class AnonimizatorDanych extends DekoratorDanychOsobowych {

    public AnonimizatorDanych(IDaneOsobowe komponent) {
        super(komponent);
    }

    @Override
    public String getPesel() {
        String prawdziwyPesel = komponent.getPesel();
        if (prawdziwyPesel != null && prawdziwyPesel.length() > 4) {
            return "***********" + prawdziwyPesel.substring(prawdziwyPesel.length() - 4);
        }
        return "***********";
    }

    @Override
    public String getImie() {
        return komponent.getImie();
    }

    @Override
    public String getNazwisko() {
        return komponent.getNazwisko();
    }

    @Override
    public String getNumerIdentyfikacyjny() {
        return komponent.getNumerIdentyfikacyjny();
    }

    @Override
    public String getNumerTelefonu() {
        return komponent.getNumerTelefonu();
    }

    @Override
    public String getEmail() {
        return komponent.getEmail();
    }

    @Override
    public String getSkierowanie() {
        return komponent.getSkierowanie();
    }
}