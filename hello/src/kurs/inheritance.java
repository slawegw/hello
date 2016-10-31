package kurs;

import java.util.Scanner;

public class inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Punkt3D wspol = new Punkt3D(0,0,0);
		
		int odczyt[] = new int[3];
				
		for (int j = 0; j < 3 ; j++) {
			System.out.print("Podaj wsp: " + j);
			odczyt[j] = in.nextInt();
		}
		
		
		wspol.setWspXYZ(odczyt[0], odczyt[1], odczyt[2]);
		
		System.out.println(" ");
		
		for (int i = 0; i<3; i++){
		System.out.println("Wspolrzedna "+ i + " to: " + wspol.getWsp(i));
		
		}
		
		

	}

}
