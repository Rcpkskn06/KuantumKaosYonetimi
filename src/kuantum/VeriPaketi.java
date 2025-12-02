package kuantum;

public class VeriPaketi extends KuantumNesnesi {

	public VeriPaketi(String id) {
		super(id,100,1);
	}

	@Override
	public void analizEt() throws KuantumCokusuException {
		setStabilite(getStabilite() - 5);
		System.out.println("Veri içeriği okundu");
		if(stabilite <= 0)
		{
			throw new KuantumCokusuException(id);
		}
	}
	

}
