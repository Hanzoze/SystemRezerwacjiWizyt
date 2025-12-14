package Kontroler.Kontroler;

import Model.Model.*;

public class RezerwacjaWizyty {

	private IModel model;
	private int wybranyTerminID;
	private IDaneOsobowe danePacjenta;
	private IStrategiaPowiadomienia strategiaWyslaniaPowiadomienia;

	/**
	 * 
	 * @param model
	 */
	public RezerwacjaWizyty(IModel model) {
		this.model = model;
        this.strategiaWyslaniaPowiadomienia = new PowiedomienieEmail();
	}

    public void setStrategiaWyslaniaPowiadomienia(IStrategiaPowiadomienia strategiaWyslaniaPowiadomienia) {
        this.strategiaWyslaniaPowiadomienia = strategiaWyslaniaPowiadomienia;
        System.out.println("KONTROLER: Zmieniono sposób powiadamiania.");
    }

    /**
	 * 
	 * @param terminID
	 */
	public void rozpoczecieRezerwacji(int terminID) {
        System.out.println("KONTROLER: Próba rozpoczęcia rezerwacji terminu ID: " + terminID);

        boolean czyWolny = model.czyTerminWolny(terminID);
        if(czyWolny){
            this.wybranyTerminID = terminID;
            System.out.println("KONTROLER: Termin dostępny. Przejdź do podawania danych.");
            System.out.println(model.pobierzSzczegolyTerminu(terminID));
        } else {
            System.out.println("KONTROLER: Błąd. Termin zajęty lub nie istnieje.");
            this.wybranyTerminID = -1;
        }
	}

	/**
	 * 
	 * @param dane
	 */
	public boolean przetworzDane(IDaneOsobowe dane) {
		boolean czyPoprawne = model.podajDaneOsobowe(dane);

        if(czyPoprawne){
            System.out.println("KONTROLER: Dane osobowe poprawne. Finalizowanie rezerwacji...");
            finalRezerwacji();
            return true;
        }
        else {
            System.out.println("KONTROLER: Błąd w danych osobowych. Proszę poprawić.");
            return false;
        }
	}

	private void finalRezerwacji() {
		if(this.wybranyTerminID != -1 && this.danePacjenta != null) {
            model.zapiszRezerwacje(this.wybranyTerminID, this.danePacjenta);
            System.out.println("KONTROLER: Rezerwacja zakończona sukcesem.");

            if (strategiaWyslaniaPowiadomienia != null) {
                String tresc = "Potwierdzenie rezerwacji terminu nr " + wybranyTerminID;

                strategiaWyslaniaPowiadomienia.wyslijPowiadomienie(tresc, this.danePacjenta);
            }
        } else {
            System.out.println("KONTROLER: Nie można zakończyć rezerwacji. Brak wybranego terminu lub danych pacjenta.");
        }
	}

	/**
	 * 
	 * @param dane
	 */
	public boolean pobierzDaneOsobowe(IDaneOsobowe dane) {
		if(this.wybranyTerminID == -1) {
            System.out.println("KONTROLER: Nie wybrano poprawnego terminu!");
            return false;
        }
        this.danePacjenta = dane;
        System.out.println("KONTROLER: Dane osobowe pobrane.");
        return przetworzDane(this.danePacjenta);
	}

}