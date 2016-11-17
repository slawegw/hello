package kurs;

public class Lesson14 {
	
	public static void main(String[] args){
		
		Animals genericAnimal = new Animals();
		
		System.out.println(genericAnimal.getName());
		System.out.println(genericAnimal.favFood);
		
		Cats morris = new Cats("Morris", "Tuna", "Rubber Mouse");
		
		System.out.println(morris.getName());
		System.out.println(morris.favFood);
		
		Animals tabby = new Cats("Tabby", "Salmon","Ball");
		
		acceptAnimal(tabby);
		
	}
	
	public static void acceptAnimal(Animals randAnimal){
		System.out.println();
		System.out.println(randAnimal.getName());
		System.out.println(randAnimal.favFood);
		System.out.println();
		randAnimal.walkAround();
		
	
		System.out.println(((Cats)randAnimal).getToy());
		
		if(randAnimal instanceof Cats){
			System.out.println(randAnimal.getName() + " is a cat");
		}
	}

}
