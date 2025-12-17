package Kontroler.Kontroler;

import Model.Model.IDaneOsobowe;

public interface IKontrolerPacjenta {

	void przegladanieOferty();

	void przegladanieWolnychTerminow();

	void rezerwacjaWizyty();

	void rezygnacjaZWizyty();

	IDaneOsobowe podanieDanychDoRezerwacji();

	void podaniePrzyczynyRezygnacji();

}