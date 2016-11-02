package kurs;

public class Kredyt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double KWOTA = 10000;
		final double PROCENT = 0.07;
		final int ILE_RAT = 12;
		
		double kapital;
		double rata = 0;
		double wspQ = 0;
		double[] czesc_kap = new double[ILE_RAT+1];
		double czesc_proc = 0;
		double kapProc = 0;
		
			
		wspQ = 1 + (PROCENT/12);
	//	System.out.println(Math.pow(wspQ, ILE_RAT));
		
		rata = KWOTA * Math.pow(wspQ,ILE_RAT)*((1-wspQ)/(1-Math.pow(wspQ, ILE_RAT)));
		System.out.println("Rata: " +rata);
		kapital = rata*ILE_RAT;
		System.out.printf("Kapital do splaty: %8.2f \n", kapital);
		
		kapProc = kapital*PROCENT*PROCENT ;
		
		int i = 1;
		double PROC1 = PROCENT + 1;
		do {
			kapital = kapital - rata;
			
			czesc_kap[i] = (kapital*PROCENT*Math.pow(PROC1,(i-1)))/(Math.pow(PROC1, ILE_RAT)-1);
			czesc_proc = PROCENT* (kapital - ((kapital*PROCENT*Math.pow(PROC1,(i-1)))/(Math.pow(PROC1, ILE_RAT)-1)));
			
			System.out.print("Kapital po " + (i+1) + " racie: ");
			System.out.printf("%5.2f", kapital);
			System.out.print(" zl - Czesc kapital: ");
			System.out.printf("%5.2f", czesc_kap[i]);
			System.out.print(" zl - Czesc odsetk: ");
			System.out.printf("%5.2f", czesc_proc);
			System.out.println();
			i++;
		} while (i <= ILE_RAT);
	
	}

}
