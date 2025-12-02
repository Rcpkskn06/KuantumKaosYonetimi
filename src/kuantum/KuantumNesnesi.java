package kuantum;

public abstract class KuantumNesnesi {
	protected String id;
	protected double stabilite;
	protected int tehlikeSeviyesi;
	
	public KuantumNesnesi(String id,double stabilite,int tehlikeSeviyesi)
	{
		this.id = id;
		setStabilite(stabilite);
		this.tehlikeSeviyesi = tehlikeSeviyesi;
	}
	
	public void setStabilite(double value)
	{
		if(value < 0)
		{
			stabilite = 0;
		}
		else if(value > 100)
		{
			stabilite = 100;
		}
		else
		{
			stabilite = value;
		}
	}
	
	public double getStabilite()
	{
		return stabilite;
	}
	
	public String getId()
	{
		return id;
	}
	
	public abstract void analizEt() throws KuantumCokusuException;
	
	public String durumBilgisi()
	{
		return "[" + id +"] Stabilite : " + stabilite;
	}
}
