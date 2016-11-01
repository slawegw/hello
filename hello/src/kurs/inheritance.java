package kurs;

import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Punkt3D wspol = new Punkt3D();

		int odczyt[] = { -1, -1, -1 };
		boolean ifTrue = false;

		for (int j = 0; j < 3; j++) {
			ifTrue = false;

			while (!ifTrue) {
				try {
					System.out.print("Podaj wsp " + j + ": ");
					odczyt[j] = Integer.parseInt(in.readLine());
				} catch (NumberFormatException e) {
					System.out.println(" Wrong data" + e);
				} catch (IOException n) {
					System.out.println("Blad odczytu");
				}
				ifTrue = odczyt[j] == -1 ? false : true;
			}
		}

		wspol.setWspXYZ(odczyt[0], odczyt[1], odczyt[2]);

		System.out.print("Wsp to: ");

		for (int i : wspol.wsp) {
			System.out.print(" " + i);

		}

	}

}
