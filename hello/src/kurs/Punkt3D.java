package kurs;

public class Punkt3D extends Punkt2D{

		
	public Punkt3D(){
		this.wsp[2] = 0;
	}
	
	public Punkt3D(int wspX, int wspY, int wspZ){
		this.wsp[0] = wspX;
		this.wsp[1] = wspY;
		this.wsp[2] = wspZ;
	}
	
	public void setWspXYZ(int wspX, int wspY, int wspZ){
		this.wsp[0] = wspX;
		this.wsp[1] = wspY;
		this.wsp[2] = wspZ;		
	}
	
	public int getWsp(int a){
		return wsp[a];
	}
	
}
