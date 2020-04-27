//package tema2;
public class AngajatCuSalarFix extends Angajat {

	public AngajatCuSalarFix(String n,double s)
	{
		super(n,s);
	}
	public double calculSalar() {
		return salar;
	}
	public void schimbaSalarFix(double s)
	{
		salar=s;
	}
	public void doSomething(int x){
		System.out.println(x+1);
	}
}
