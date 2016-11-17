package kurs;

public class Lesson15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Vehicle car = new Vehicle(4,100.00);
		
		System.out.println("Cars Max SPeed " + car.getSpeed());
		System.out.println("Num of wheels " + car.getWheels());

		
		car.setCarStrength(10);
		System.out.println("Strength: " + car.getCarStrength());
		
	}

}
