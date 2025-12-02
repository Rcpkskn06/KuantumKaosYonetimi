package kuantum;

public class KuantumCokusuException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public KuantumCokusuException(String id)
	{
		super("Kuantum Çöküşü! Patlayan Nesne: " + id);
	}

}
