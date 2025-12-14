package Kontroler.Kontroler;

import Model.Model.*;

public class SystemRezerwacjiWizyt {

	private Rola wybranaRola;

	/**
	 * 
	 * @param args
	 */
    static void main(String[] args) {
        System.out.println("=== SYSTEM REZERWACJI WIZYT LEKARSKICH ===");

        SystemRezerwacjiWizyt system = new SystemRezerwacjiWizyt();

        Rola rolaTestowa = Rola.PACJENT;

        System.out.println("Zalogowano jako: " + rolaTestowa);

        system.uruchomSystem(rolaTestowa);
    }

	/**
	 * 
	 * @param wybranaRola
	 */
    public void uruchomSystem(Rola wybranaRola) {
        this.wybranaRola = wybranaRola;

        IDAO dao = new DAO();
        IFabrykaDanychOsobowych fabryka = new FabrykaDanychOsobowych();

        IModel model = new Model(dao, fabryka);

        model.dodajNowyTermin("2023-12-24 10:00", "Dr Dolittle", 999);

        switch (wybranaRola) {
            case PACJENT:
                uruchomScenariuszPacjenta(model);
                break;

            case ADMIN:
                //TODO: Scenaariusz administratora
                //uruchomScenariuszAdministratora(model);
                break;

            default:
                System.out.println("Nieznana rola.");
        }
    }

    private void uruchomScenariuszPacjenta(IModel model) {
        System.out.println("\n--- [SCENARIUSZ PACJENTA: REZERWACJA WIZYTY] ---");

        IKontrolerPacjenta pacjent = new KontrolerPacjenta(model);

        pacjent.rezerwacjaWizyty();

        System.out.println("--- [KONIEC SCENARIUSZA PACJENTA] ---");
    }

}