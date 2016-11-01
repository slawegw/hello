package kurs;

public class StopyProc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final int START_RATE = 10;
		final int FINAL_RATE = 15;
		final int MONTHS = 12;
		final int START_SALDO = 10000;
		
		//Set 6 columns [0.10, 0.11 0.12, 0.13, 0.14, 0.15]
		double[] intrestRate = new double[FINAL_RATE - START_RATE + 1];
			
		for (int i = 0; i < intrestRate.length; i++){
			
			intrestRate[i] = (START_RATE + i)/100.0;    
		}
		
		double[][] balances = new double[MONTHS][FINAL_RATE - START_RATE + 1];
		
		// Zainicjowanie salda poczatkowego
		for (int i = 0; i < balances[0].length; i++){
			balances[0][i] = START_SALDO;
		}
		
		// Obliczenie odsetek
		for (int i = 1; i < balances.length; i++){
			for (int j = 0; j < balances[i].length; j++ ){
				
				balances[i][j] = balances[i - 1][j] * intrestRate[j] + balances[i-1][j]; 
			}
		}
		
		// Wydruk wiersza stóp procentowych
		for (double intrest : intrestRate) {
			System.out.printf("%10.1f ", intrest * 100);
		}
		
		System.out.println();
		
		//Wydruk tabeli
		for (double[] row : balances){
			for (double result : row){
				
				System.out.printf("%10.2f", result);
			}
			System.out.println();
		}
		
		

	}

}
