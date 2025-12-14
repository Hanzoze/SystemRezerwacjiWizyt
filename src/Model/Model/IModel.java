package Model.Model;

public interface IModel {

	/**
	 * 
	 * @param idTerminu
	 */
	boolean czyTerminWolny(int idTerminu);

	/**
	 * 
	 * @param idTerminu
	 */
	String pobierzSzczegolyTerminu(int idTerminu);

	/**
	 * 
	 * @param idTerminu
	 * @param dane
	 */
	void zapiszRezerwacje(int idTerminu, IDaneOsobowe dane);

	/**
	 * 
	 * @param data
	 * @param lekarz
	 * @param gabinet
	 */
	void dodajNowyTermin(String data, String lekarz, int gabinet);

	/**
	 * 
	 * @param lekarz
	 * @param data
	 */
	boolean sprawdzKonfliktTerminow(String lekarz, String data);

	/**
	 * 
	 * @param specjalizacja
	 */
	String[] pobierzListeWolnychTerminow(String specjalizacja);

	/**
	 * 
	 * @param idRezerwacji
	 * @param pacjentID
	 */
	void usunRezerwacjeZListyPacjenta(int idRezerwacji, int pacjentID);

	/**
	 * 
	 * @param idRezerwacji
	 * @param powod
	 */
	void zapiszPowodRezygnacji(int idRezerwacji, String powod);

	/**
	 * 
	 * @param idTerminu
	 */
	boolean czyWymagaSkierowanie(int idTerminu);

	/**
	 * 
	 * @param dane
	 */
	boolean podajDaneOsobowe(IDaneOsobowe dane);

}