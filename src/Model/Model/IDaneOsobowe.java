package Model.Model;

public interface IDaneOsobowe {

	String getImie();

	/**
	 * 
	 * @param imie
	 */
	boolean setImie(String imie);

	String getNazwisko();

	/**
	 * 
	 * @param nazwisko
	 */
	boolean setNazwisko(String nazwisko);

	String getPesel();

	/**
	 * 
	 * @param pesel
	 */
	boolean setPesel(String pesel);

	String getNumerIdentyfikacyjny();

	/**
	 * 
	 * @param numerIdentyfikacyjny
	 */
	boolean setNumerIdentyfikacyjny(String numerIdentyfikacyjny);

	String getNumerTelefonu();

	/**
	 * 
	 * @param numerTelefonu
	 */
	boolean setNumerTelefonu(String numerTelefonu);

	String getEmail();

	/**
	 * 
	 * @param email
	 */
	boolean setEmail(String email);

	String getSkierowanie();

	/**
	 * 
	 * @param skierowanie
	 */
	boolean setSkierowanie(String skierowanie);

}