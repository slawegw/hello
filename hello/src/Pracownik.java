
public class Pracownik {
	
	String pracow[] = new String[3]; // 0 - imie, 1 - nazwisko, 2 - spare
	float wyplata;
	
	public Pracownik(){
		pracow[0] = "";
		pracow[1] = "";
		wyplata = 0;
	}
	
	public Pracownik(String a, String b, float c){
		pracow[0] = a;
		pracow[1] = b;
		wyplata = c;
	}
	
	
	

}
