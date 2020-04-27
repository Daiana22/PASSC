//package tema2;
public class Firma {
	
	private Angajat[] angajati = new Angajat[1024];
	private int nrAngajati;
	public int angajeaza(Angajat A)
	{
		if(nrAngajati<1024)
		{
			for(int i=0;i<nrAngajati;i++)
				if(A.equals(angajati[i]))
					return -2;
			angajati[nrAngajati]=A;
			nrAngajati++;
			return 0;
		}
		else
			return -1;
	}
	public double salariuMediu()
	{
		double sum=0;
		for(int i=0;i<nrAngajati;i++)
			sum+=angajati[i].calculSalar();
		return sum/nrAngajati;
	}
	public static void main(String args[])
	{
		Firma f=new Firma();
		AngajatCuSalarFix a1= new AngajatCuSalarFix("mihai", 1000);
		AngajatCuOra a2= new AngajatCuOra("Mircea", 100);
		a2.adaugaOre(8);
		f.angajeaza(a1);
		f.angajeaza(a2);
		System.out.println(f.salariuMediu());
		System.out.println(f.angajeaza(a1));
		a2.schimbaSalarPeOra(200);
		System.out.println(f.salariuMediu());
		a1.schimbaSalarFix(2000);
		System.out.println(f.salariuMediu());
		
	}
}
