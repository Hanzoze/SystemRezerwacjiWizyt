package Model.Model;

public interface IDAO {

	/**
	 * 
	 * @param idTerminu
	 */
	Termin pobierzTermin(int idTerminu);

	Termin[] pobierzWszystkieTerminy();

	/**
	 * 
	 * @param termin
	 */
	void dodajTermin(Termin termin);

	/**
	 * 
	 * @param termin
	 */
	void aktualizujTermin(Termin termin);

	/**
	 * 
	 * @param rezerwacja
	 */
	void dodajRezerwacje(Rezerwacja rezerwacja);

	/**
	 * 
	 * @param idRezerwacji
	 * @param pacjentID
	 */
	void usunRezerwacje(int idRezerwacji, int pacjentID);

	/**
	 * 
	 * @param pacjentID
	 */
	Rezerwacja[] pobierzRezerwacjePacjenta(int pacjentID);

	/**
	 * 
	 * @param idTerminu
	 * @param powod
	 */
	void zapiszPowodRezygnacji(int idTerminu, String powod);

}