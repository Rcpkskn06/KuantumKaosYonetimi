package kuantum;

public class AntiMadde extends KuantumNesnesi implements IKritik {

	public AntiMadde(String id) {
		super(id,100,10);
	}

	@Override
	public void acilDurumSogutmasi() {
		setStabilite(getStabilite() + 50);
	}

	@Override
	public void analizEt() throws KuantumCokusuException {
		System.out.println("Evrenin dokusu titriyor...");
		setStabilite(getStabilite() - 25);
		if(stabilite <= 0)
		{
			throw new KuantumCokusuException(id);
		}
	}

}

