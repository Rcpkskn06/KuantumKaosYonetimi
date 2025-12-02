package kuantum;

public class KaranlikMadde extends KuantumNesnesi implements IKritik {

	public KaranlikMadde(String id) {
		super(id,100,7);
	}

	@Override
	public void acilDurumSogutmasi() {
		setStabilite(getStabilite() + 50);
	}

	@Override
	public void analizEt() throws KuantumCokusuException {
		setStabilite(getStabilite() - 15);
		if(stabilite <= 0)
		{
			throw new KuantumCokusuException(id);
		}
	}

}

