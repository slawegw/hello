package kurs;

public class Kredyt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final double KWOTA = 275000;
		final double PROCENT = 0.0447;
		final int ILE_RAT_W_ROKU = 12;
		final int ILE_RAT = 30*ILE_RAT_W_ROKU;
		
		double kapital;
		double stale_kap = 0;
		double stale_odset = 0;
		double stale_rata = 0;
		double stale_dosplaty = 0;
		double rata = 0;
		double wspQ = 0;
		double[] czesc_kap = new double[ILE_RAT+1];
		double czesc_proc = 0;
		double kapProc = 0;
		double poracie = 0;
		double malejaceSuma = 0;
		
			
		wspQ = 1 + (PROCENT/12);
	//	System.out.println(Math.pow(wspQ, ILE_RAT));
		
		rata = KWOTA * Math.pow(wspQ,ILE_RAT)*((1-wspQ)/(1-Math.pow(wspQ, ILE_RAT)));
		System.out.println("Rata: " +rata);
		kapital = rata*ILE_RAT;
		System.out.printf("Kapital do splaty: %8.2f \n", kapital);
		
		kapProc = kapital*PROCENT*PROCENT ;
		
		// raty rowne
		stale_kap = KWOTA/ILE_RAT;
		stale_odset = KWOTA*PROCENT/ILE_RAT_W_ROKU;
	//	stale_rata = stale_kap+stale_odset;
//		malejaceSuma = stale_kap+stale_odset;
//		System.out.print("Rata 1: ");
//		System.out.printf("%5.2f", malejaceSuma);
//		System.out.print(" Pozostalo: ");
//		System.out.printf("%5.2f", (KWOTA - stale_kap));
//		System.out.println();
//		
		int i = 0;
		double PROC1 = PROCENT + 1;
		do {
			kapital = kapital - rata;
			
			//stale_odset = stale_kap*PROCENT/ILE_RAT_W_ROKU;			
			stale_odset = (KWOTA - stale_kap * i)*PROCENT/ILE_RAT_W_ROKU;
			
			stale_rata = stale_kap+stale_odset;		
			if ((i)%50 == 0) {
			System.out.print("Rata " + (i+1) + ": ");
			System.out.printf("%5.2f", stale_rata);
			System.out.print(" Pozostalo: ");
			System.out.printf("%5.2f", (KWOTA - stale_kap * i));
			System.out.println();
			}
			
			stale_dosplaty = stale_kap + stale_odset;
			malejaceSuma = malejaceSuma + stale_rata;
			
			//czesc_kap[i] = (kapital*PROCENT*Math.pow(PROC1,(i-1)))/(Math.pow(PROC1, ILE_RAT)-1);
			//czesc_proc = PROCENT* (kapital - ((kapital*PROCENT*Math.pow(PROC1,(i-1)))/(Math.pow(PROC1, ILE_RAT)-1)));
			
	//		System.out.print("Kapital po " + (i+1) + " racie: ");
	//		System.out.printf("%5.2f", kapital);
		//	System.out.print(" zl - Czesc kapital: ");
			//System.out.printf("%5.2f", czesc_kap[i]);
			//System.out.print(" zl - Czesc odsetk: ");
			//System.out.printf("%5.2f", czesc_proc);
		//	System.out.println();
			i++;
		} while (i < ILE_RAT);
		
		System.out.printf("Kapital do splaty: %8.2f \n", malejaceSuma);
	
	}

}
