//package tema2;
public class AngajatCuOra extends Angajat {

	private double[] ore = new double[31];
	private int nrOre;
	public AngajatCuOra(String n,double s)
	{
		super(n,s);
	}
	public double calculSalar() {
		double sum=0;
		for(int i=0;i<nrOre;i++)
			sum+=ore[i];
		return sum*salar;
	}
	public void schimbaSalarPeOra(double s)
	{
		salar=s;
	}
	public void adaugaOre(double o)
	{
		ore[nrOre]=o;
		nrOre++;
	}
	public void doSomething(int x){
		System.out.println(x);
	}
}