//package tema2;
public abstract class Angajat implements Worker{
	protected String nume;
	protected double salar;
	public Angajat(String nume,double salar)
	{
		this.nume=nume;
		this.salar=salar;
	}
	public abstract double calculSalar();
	public boolean equals(Object A)
	{
		if(A instanceof Angajat)
		{
			if(this.nume.equals(((Angajat)A).nume))
				return true;
			return false;
		}
		return false;
	}
}
