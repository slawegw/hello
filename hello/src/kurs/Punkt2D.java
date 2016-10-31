package kurs;

public class Punkt2D {

	public int wsp[] = new int[3];
	
	
	
	public Punkt2D() {
		wsp[0] = -1;
		wsp[1] = -1;
	}

	public Punkt2D(int wspX, int wspY)
	{
		this.wsp[0] = wspX;
		this.wsp[1] = wspY;
	}
	
	public void setWspXY(int wspX, int wspY){
		this.wsp[0] = wspX;
		this.wsp[1] = wspY;
	}
	
	public int[] getPoint(){
		
		return wsp;
	}
	
	
}
